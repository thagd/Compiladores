package br.ufscar.dc.compiladores.t4;

import static java.lang.Float.parseFloat;
import java.util.Map.Entry;

public class ComprasGeradorPDF extends ComprasBaseVisitor<Void> {

    public static StringBuilder pdf = new StringBuilder();
    TabelaDeSimbolos tds = new TabelaDeSimbolos();

    @Override
    public Void visitLista_compras(ComprasParser.Lista_comprasContext ctx) {
        pdf.append("Lista de Compras").append("\n").append("\n");
        
        visitLista_padaria(ctx.lista_padaria());
        visitLista_acougue(ctx.lista_acougue());
        visitLista_hortifruti(ctx.lista_hortifruti());
        visitLista_higiene(ctx.lista_higiene());
        visitLista_limpeza(ctx.lista_limpeza());
        visitLista_bebidas(ctx.lista_bebidas());
        visitLista_alimentacao(ctx.lista_alimentacao());
        visitTotal_compra(ctx.total_compra());
        
        return null; 
    }
    
    @Override
    public Void visitLista_padaria(ComprasParser.Lista_padariaContext ctx) {
        pdf.append("Padaria:").append("\n");
        ctx.item().forEach(item -> {
            visitItem(item);
        });
        pdf.append("\n");
        return null;
    }
    
    @Override
    public Void visitLista_acougue(ComprasParser.Lista_acougueContext ctx) {
        pdf.append("Açougue:").append("\n");
        ctx.item().forEach(item -> {
            visitItem(item);
        });
        pdf.append("\n");
        return null;
    }
    
    @Override
    public Void visitLista_hortifruti(ComprasParser.Lista_hortifrutiContext ctx) {
        pdf.append("Hortifruti:").append("\n");
        ctx.item().forEach(item -> {
            visitItem(item);
        });
        pdf.append("\n");
        return null;
    }
    
    @Override
    public Void visitLista_higiene(ComprasParser.Lista_higieneContext ctx) {
        pdf.append("Higiene:").append("\n");
        ctx.item().forEach(item -> {
            visitItem(item);
        });
        pdf.append("\n");
        return null;
    }
    
    @Override
    public Void visitLista_limpeza(ComprasParser.Lista_limpezaContext ctx) {
        pdf.append("Limpeza:").append("\n");
        ctx.item().forEach(item -> {
            visitItem(item);
        });
        pdf.append("\n");
        return null;
    }
    
    @Override
    public Void visitLista_bebidas(ComprasParser.Lista_bebidasContext ctx) {
        pdf.append("Bebidas:").append("\n");
        ctx.item().forEach(item -> {
            visitItem(item);
        });
        pdf.append("\n");
        return null;
    }
    
    @Override
    public Void visitLista_alimentacao(ComprasParser.Lista_alimentacaoContext ctx) {
        pdf.append("Alimentação:").append("\n");
        ctx.item().forEach(item -> {
            visitItem(item);
        });
        pdf.append("\n");
        return null;
    }
    
    @Override
    public Void visitItem(ComprasParser.ItemContext ctx) {
        pdf.append(ctx.nome().getText() + ", " + ctx.valor().getText()).append("\n");
        return null; 
    }
    
    @Override
    public Void visitTotal_compra(ComprasParser.Total_compraContext ctx) {
        pdf.append("Total da compra: " + ctx.valor().getText()).append("\n");
        return null; 
    }
}