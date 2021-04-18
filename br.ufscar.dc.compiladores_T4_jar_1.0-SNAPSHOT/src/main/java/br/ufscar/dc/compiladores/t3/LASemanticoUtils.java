package br.ufscar.dc.compiladores.t3;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import br.ufscar.dc.compiladores.t3.TabelaDeSimbolos.TipoVariavel;

public class LASemanticoUtils {
    // Inicializa a lista de erros semânticos
    public static List<String> errosSemanticos = new ArrayList<>();
    
    // adiciona erro semântico na lista de erros
    public static void adicionarErroSemantico(Token t, String mensagem) {
        int linha = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }
    
    // verifica o tipo de uma variavel
    public static TipoVariavel verificaTipo(String strTipoVar) {
        TipoVariavel tipoVar = TipoVariavel.INVALIDO;
        
        switch (strTipoVar) {
            case "literal":
                tipoVar = TipoVariavel.LITERAL;
                break;
            case "inteiro":
                tipoVar = TipoVariavel.INTEIRO;
                break;
            case "real":
                tipoVar = TipoVariavel.REAL;
                break;
            case "logico":
                tipoVar = TipoVariavel.LOGICO;
                break;
            default:
                break;
        }
        return tipoVar;
    }
    
    public static TipoVariavel verificaTipo(Escopos escopos, LAParser.ExpressaoContext ctx){
        TipoVariavel tipoVariavel = null;
        for (LAParser.Termo_logicoContext termo_logico : ctx.termo_logico()) {
            if(tipoVariavel == null){
                tipoVariavel = verificaTipo(escopos, termo_logico);
            } else if (verificaTipo(escopos, termo_logico) != tipoVariavel){
                return TipoVariavel.INVALIDO;
            }
        }
        return tipoVariavel;
    }
    
    public static TipoVariavel verificaTipo(Escopos escopos, LAParser.Termo_logicoContext ctx){
        TipoVariavel tipoVariavel = null;
        for (LAParser.Fator_logicoContext fator_logico : ctx.fator_logico()) {
            if(tipoVariavel == null){
                tipoVariavel = verificaTipo(escopos, fator_logico);
            } else if (verificaTipo(escopos, fator_logico) != tipoVariavel){
                return TipoVariavel.INVALIDO;
            }
        }
        return tipoVariavel;
    }
    
    public static TipoVariavel verificaTipo(Escopos escopos, LAParser.Fator_logicoContext ctx){
        return verificaTipo(escopos, ctx.parcela_logica());
    }
    
    public static TipoVariavel verificaTipo(Escopos escopos, LAParser.Parcela_logicaContext ctx){
        if(ctx.exp_relacional() != null){
            return verificaTipo(escopos, ctx.exp_relacional());
        }
        return TipoVariavel.LOGICO;
    }
    
    public static TipoVariavel verificaTipo(Escopos escopos, LAParser.Exp_relacionalContext ctx){
        if(ctx.op_relacional() != null) {
            return TipoVariavel.LOGICO;
        }
        return verificaTipo(escopos, ctx.exp_aritmetica(0));
    }
    
    public static TipoVariavel verificaTipo(Escopos escopos, LAParser.Exp_aritmeticaContext ctx){
        TipoVariavel tipoVariavel = null;
        for (LAParser.TermoContext termo : ctx.termo()) {
            TipoVariavel tipo = verificaTipo(escopos, termo);
            if(tipoVariavel == null){
                tipoVariavel = tipo;
            } else if (tipo != tipoVariavel && !((tipoVariavel == TipoVariavel.INTEIRO && tipo == TipoVariavel.REAL) || (tipoVariavel == TipoVariavel.REAL && tipo == TipoVariavel.INTEIRO))){
                return TipoVariavel.INVALIDO;
            }
        }
        return tipoVariavel;
    }
    
    public static TipoVariavel verificaTipo(Escopos escopos, LAParser.TermoContext ctx){
        TipoVariavel tipoVariavel = null;
        for (LAParser.FatorContext fator : ctx.fator()) {
            TipoVariavel tipo = verificaTipo(escopos, fator);
            if(tipoVariavel == null){
                tipoVariavel = tipo;
            } else if (tipo != tipoVariavel && !((tipoVariavel == TipoVariavel.INTEIRO && tipo == TipoVariavel.REAL) || (tipoVariavel == TipoVariavel.REAL && tipo == TipoVariavel.INTEIRO))){
                return TipoVariavel.INVALIDO;
            }
        }
        return tipoVariavel;
    }
    
    public static TipoVariavel verificaTipo(Escopos escopos, LAParser.FatorContext ctx){
        TipoVariavel tipoVariavel = verificaTipo(escopos, ctx.parcela(0));
        for (LAParser.ParcelaContext parcela : ctx.parcela()) {
            if(tipoVariavel == null){
                tipoVariavel = verificaTipo(escopos, parcela);
            } else if (verificaTipo(escopos, parcela) != tipoVariavel){
                return TipoVariavel.INVALIDO;
            }
        }
        return tipoVariavel;
    }
    
    public static TipoVariavel verificaTipo(Escopos escopos, LAParser.ParcelaContext ctx){
        if(ctx.parcela_unario() != null){
            return verificaTipo(escopos, ctx.parcela_unario());
        }
        return verificaTipo(ctx.parcela_nao_unario());
    }

    private static TipoVariavel verificaTipo(Escopos escopos, LAParser.Parcela_unarioContext ctx) {
        if(ctx.identificador() != null) {
            return verificaTipo(escopos, ctx.identificador());
        } else if(ctx.IDENT() != null) {
            for(TabelaDeSimbolos tabela : escopos.percorrerEscoposAninhados()) {
                if(tabela.existe(ctx.IDENT().getText())){
                    return tabela.verificarVariavel(ctx.IDENT().getText());
                }
            }
            return TipoVariavel.INVALIDO;
        }else if(ctx.NUM_INT() != null) {
            return TipoVariavel.INTEIRO;
        }else if(ctx.NUM_REAL() != null) {
            return TipoVariavel.REAL;
        }
        return verificaTipo(escopos, ctx.exp);
    }

    private static TipoVariavel verificaTipo(LAParser.Parcela_nao_unarioContext ctx) {
        if(ctx.identificador() != null) {
            return TipoVariavel.INTEIRO;
        }
        return TipoVariavel.LITERAL;
    }
    
    public static TipoVariavel verificaTipo(Escopos escopos, LAParser.IdentificadorContext ctx) {
        TabelaDeSimbolos subtabela = null;
        TipoVariavel tipoVariavel = TipoVariavel.INVALIDO;
        if(!ctx.subIdent.isEmpty() ){
            for(TabelaDeSimbolos tabela : escopos.percorrerEscoposAninhados()) {
                if(tabela.existe(ctx.ident1.getText())){
                    subtabela = tabela.verificarSubtabela(ctx.ident1.getText());
                    if(subtabela != null){
                        tipoVariavel = subtabela.verificarVariavel(ctx.subIdent.get(0).getText());
                    }
                }
            }
        } else {
            for(TabelaDeSimbolos tabela : escopos.percorrerEscoposAninhados()) {
                if(tabela.existe(ctx.ident1.getText())){
                    tipoVariavel = tabela.verificarVariavel(ctx.ident1.getText());
                }
            }
        }
        return tipoVariavel;
    }
}