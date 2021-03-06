
package br.ufscar.dc.compiladores.t1;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class Principal {

    public static void main(String[] args) {
        // Cria o arquivo de acordo com o caminho passado por argumento na linha de comando
        try (PrintWriter pw = new PrintWriter(new File(args[1]))) {
            // Inicializa o arquivo de entrada com o código
            CharStream cs = CharStreams.fromFileName(args[0]);
            
            // Inicializa as regras léxicas
            LALexer lex = new LALexer(cs);
            
            // Variável para controle dos tokens de acordo com as regras léxicas
            Token t = null;
            
            // Percorre o arquivo de entrada aplicando as regras léxicas
            while((t = lex.nextToken()).getType() != Token.EOF){
                // Verifica o token retornado da análise léxica e verifica se é correspondente a um erro,
                // caso for, salva no arquivo a mensagem do erro correspondente
                switch(LALexer.VOCABULARY.getDisplayName(t.getType())) {
                    // Verifica erros gerais que não são especificados por nenhuma outra regra léxica
                    case "ERRO":
                      pw.println("Linha " + lex.getLine() + ": " + t.getText() + " - simbolo nao identificado");
                      return;
                    // Verifica erros de comentários que foram abertos e não foram fechados
                    case "COMENT_ERRADO":
                      pw.println("Linha " + lex.getLine() + ": comentario nao fechado");
                      return;
                    // Verifica erros de strings que foram abertas e não foram fechadas
                    case "LITERAL_ERRADO":
                      pw.println("Linha " + lex.getLine() + ": cadeia literal nao fechada");
                      return;
                }
                
                // Caso não tenha retornado nenhum erro, grava no arquivo o token correspondente a regra léxica lida
                pw.println("<" + "'" + t.getText() + "'" + "," + LALexer.VOCABULARY.getDisplayName(t.getType()) + ">");
            }
        } catch (IOException ex) {
            // Printa no terminal caso a criação do arquivo não tenha sido realizada de forma correta
            System.out.println("Falha na criação do arquivo de saída.");
        }
    }
}