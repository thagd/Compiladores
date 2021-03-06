
package br.ufscar.dc.compiladores.t2;

import org.antlr.v4.runtime.ANTLRErrorListener; 
import org.antlr.v4.runtime.Token; 
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Parser;
import java.io.PrintWriter;
import java.util.BitSet;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

// Classe para customizar os erros gerados na analise lexica e sintatica
public class MyCustomErrorListener implements ANTLRErrorListener {
    PrintWriter pw;
    // pw é o arquivo de saída passado para a função
    public MyCustomErrorListener(PrintWriter pw) {
      this.pw = pw;
    }

    @Override
    public void	reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
    }
    
    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
    }
    
    // Verifica os erros, se é sintático ou semântico e grava no arquivo de saída a mensagem correspondente
    @Override
    public void	syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        // Verifica o token que ocorreu o erro
        Token t = (Token) offendingSymbol;
        
        switch(LALexer.VOCABULARY.getDisplayName(t.getType())) {
            // Verifica erros gerais que não são especificados por nenhuma outra regra léxica
            case "ERRO":
              pw.println("Linha " + line + ": " + t.getText() + " - simbolo nao identificado");
              return;
            // Verifica erros de comentários que foram abertos e não foram fechados
            case "COMENT_ERRADO":
              pw.println("Linha " + line + ": comentario nao fechado");
              return;
            // Verifica erros de strings que foram abertas e não foram fechadas
            case "LITERAL_ERRADO":
              pw.println("Linha " + line + ": cadeia literal nao fechada");
              return;
            default:
                // Formata os erros sintáticos
                if(t.getText() == "<EOF>"){
                    pw.println("Linha "+line+": erro sintatico proximo a EOF");
                } else {
                    pw.println("Linha "+line+": erro sintatico proximo a "+t.getText());
                }
        }
        // Cria uma exception para parar a verificação de erros e printar um unico erro no arquivo de saida 
        throw new RuntimeException();
    }
}