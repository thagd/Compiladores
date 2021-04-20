package br.ufscar.dc.compiladores.t4;

import static java.lang.Float.parseFloat;
import java.util.Map.Entry;

public class ComprasGeradorPDF extends ComprasBaseVisitor<Void> {

    public static StringBuilder pdf = new StringBuilder();
    TabelaDeSimbolos tds = new TabelaDeSimbolos();

    @Override
    public Void visitItem(ComprasParser.ItemContext ctx) {
        pdf.append(ctx.nome().getText() + ", " + ctx.valor().getText()).append("\n");
        return null; 
    }
}