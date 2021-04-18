package br.ufscar.dc.compiladores.t4;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

public class Principal {

    public static void main(String[] args) {
        // Cria o arquivo de acordo com o caminho passado por argumento na linha de comando
        try (PrintWriter pw = new PrintWriter(new File(args[1]))) {
            // Inicializa o arquivo de entrada com o código
            CharStream cs = CharStreams.fromFileName(args[0]);
            
            // Inicializa as regras léxicas
            ComprasLexer lex = new ComprasLexer(cs);
            
            CommonTokenStream tokens = new CommonTokenStream(lex);
            ComprasParser parser = new ComprasParser(tokens);
            
            // Variável para controle dos tokens de acordo com as regras léxicas
            Token t = null;
            
            // Remove a mensagem de erro padrão
            parser.removeErrorListeners();
            // Registra o error personalizado da analise lexica e sintatica
            MyCustomErrorListener mcel = new MyCustomErrorListener(pw);
            parser.addErrorListener(mcel);
            
            /*
            // Percorre o código
            ProgramaContext arvore = parser.programa();
            
            // Inicializa o analisador semântico
            ComprasSemantico semantico = new ComprasSemantico();
            
            // Percorre o código realizando a análise semântica
            semantico.visitPrograma(arvore);
            
            // Escreve no arquivo os erros gerados na análise semântica
            ComprasSemanticoUtils.errosSemanticos.forEach((erro) -> pw.println(erro));
*/
            
            // Verifica se tem algum erro no código
            try {
                // Roda a analise sintatica
                parser.lista_compras();
            } catch (Exception ex){
            }
            pw.println("Fim da compilacao");
        } catch (IOException ex) {
            // Printa no terminal caso a criação do arquivo não tenha sido realizada de forma correta
            System.out.println("Falha na criação do arquivo de saída.");
        }
    }
}