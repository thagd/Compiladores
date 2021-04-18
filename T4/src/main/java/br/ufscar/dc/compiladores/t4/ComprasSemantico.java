package br.ufscar.dc.compiladores.t4;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import br.ufscar.dc.compiladores.t4.TabelaDeSimbolos;

public class ComprasSemantico extends ComprasBaseVisitor<Void> {

    Escopos escopo = new Escopos();
    
    /*
        Verifica se já existe um item com o nome no escopo
    */
    @Override
    public Void visitNome(ComprasParser.NomeContext ctx) {
        TabelaDeSimbolos escopoAtual = escopo.obterEscopoAtual();
        
        if(!escopoAtual.existe(ctx.getText())){
            escopoAtual.inserir(ctx.getText());
        } else {
            String mensagem = String.format("Item %s já existe na lista de compras", ctx.getText());
            ComprasSemanticoUtils.adicionarErroSemantico(ctx.start, mensagem);
        }
        return null;
    }
}