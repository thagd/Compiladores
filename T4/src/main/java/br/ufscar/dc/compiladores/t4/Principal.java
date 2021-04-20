package br.ufscar.dc.compiladores.t4;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import br.ufscar.dc.compiladores.t4.ComprasParser.Lista_comprasContext;
import br.ufscar.dc.compiladores.t4.ComprasGeradorPDF;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class Principal {
    
    static CharStream cs;
    static ComprasLexer lexer;
    static CommonTokenStream tokens;
    static ComprasParser parser;
    static ComprasVisitor semantico;

    public static void main(String[] args) throws DocumentException {     
        try (PrintWriter pw = new PrintWriter(new File(args[1]))){
            if(lexer_parser(args[0], pw) && semantico(args[0], pw)){
                geradorPDF(args[0],args[1]);
            }
        } catch(IOException e){
            System.out.println("Falha na criação do arquivo de saída.");
        }
    }
    
    static boolean lexer_parser(String file, PrintWriter pw) throws IOException {
        try {
            cs = CharStreams.fromFileName(file);
            lexer = new ComprasLexer(cs);
            tokens = new CommonTokenStream(lexer);
            parser = new ComprasParser(tokens);
            
            // Remove a mensagem de erro padrão
            parser.removeErrorListeners();
            // Registra o error personalizado da analise lexica e sintatica
            MyCustomErrorListener mcel = new MyCustomErrorListener(pw);
            parser.addErrorListener(mcel);
            // Roda a analise sintatica
            parser.lista_compras();
            return true;
        } catch (IOException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    static boolean semantico(String file, PrintWriter pw) throws IOException {
        try {
            cs = CharStreams.fromFileName(file);
            lexer = new ComprasLexer(cs);
            tokens = new CommonTokenStream(lexer);
            parser = new ComprasParser(tokens);
            // Percorre o código
            Lista_comprasContext arvore = parser.lista_compras();
            
            // Inicializa o analisador semântico
            ComprasSemantico semantico = new ComprasSemantico();
            
            // Percorre o código realizando a análise semântica
            semantico.visitLista_compras(arvore);
            
            // Escreve no arquivo os erros gerados na análise semântica
            ComprasSemanticoUtils.errosSemanticos.forEach((erro) -> pw.println(erro));
            
            pw.println("Fim da compilacao");
            
            if(ComprasSemanticoUtils.errosSemanticos.isEmpty()){
                return true;
            }
            return false;
        } catch (IOException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    static void geradorPDF(String file, String filePDF) throws IOException, DocumentException {
        try {
            cs = CharStreams.fromFileName(file);
            lexer = new ComprasLexer(cs);
            tokens = new CommonTokenStream(lexer);
            parser = new ComprasParser(tokens);
            Lista_comprasContext arvore = parser.lista_compras();
            ComprasGeradorPDF pdf = new ComprasGeradorPDF();
            
            // criação do objeto documento
            Document document = new Document();
            
            PdfWriter.getInstance(document, new FileOutputStream(filePDF+"PDF"));
            document.open();

            pdf.visitLista_compras(arvore);
            
            // adicionando um parágrafo ao documento
            document.add(new Paragraph(pdf.pdf.toString()));
            
            document.close();
        } catch (IOException e){
            System.out.println(e.toString());
        }
    }
}