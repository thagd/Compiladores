// Generated from br/ufscar/dc/compiladores/t4/Compras.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.t4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ComprasParser}.
 */
public interface ComprasListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ComprasParser#lista_compras}.
	 * @param ctx the parse tree
	 */
	void enterLista_compras(ComprasParser.Lista_comprasContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComprasParser#lista_compras}.
	 * @param ctx the parse tree
	 */
	void exitLista_compras(ComprasParser.Lista_comprasContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComprasParser#lista_padaria}.
	 * @param ctx the parse tree
	 */
	void enterLista_padaria(ComprasParser.Lista_padariaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComprasParser#lista_padaria}.
	 * @param ctx the parse tree
	 */
	void exitLista_padaria(ComprasParser.Lista_padariaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComprasParser#lista_acougue}.
	 * @param ctx the parse tree
	 */
	void enterLista_acougue(ComprasParser.Lista_acougueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComprasParser#lista_acougue}.
	 * @param ctx the parse tree
	 */
	void exitLista_acougue(ComprasParser.Lista_acougueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComprasParser#lista_hortifruti}.
	 * @param ctx the parse tree
	 */
	void enterLista_hortifruti(ComprasParser.Lista_hortifrutiContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComprasParser#lista_hortifruti}.
	 * @param ctx the parse tree
	 */
	void exitLista_hortifruti(ComprasParser.Lista_hortifrutiContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComprasParser#lista_higiene}.
	 * @param ctx the parse tree
	 */
	void enterLista_higiene(ComprasParser.Lista_higieneContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComprasParser#lista_higiene}.
	 * @param ctx the parse tree
	 */
	void exitLista_higiene(ComprasParser.Lista_higieneContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComprasParser#lista_limpeza}.
	 * @param ctx the parse tree
	 */
	void enterLista_limpeza(ComprasParser.Lista_limpezaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComprasParser#lista_limpeza}.
	 * @param ctx the parse tree
	 */
	void exitLista_limpeza(ComprasParser.Lista_limpezaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComprasParser#lista_bebidas}.
	 * @param ctx the parse tree
	 */
	void enterLista_bebidas(ComprasParser.Lista_bebidasContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComprasParser#lista_bebidas}.
	 * @param ctx the parse tree
	 */
	void exitLista_bebidas(ComprasParser.Lista_bebidasContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComprasParser#lista_alimentacao}.
	 * @param ctx the parse tree
	 */
	void enterLista_alimentacao(ComprasParser.Lista_alimentacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComprasParser#lista_alimentacao}.
	 * @param ctx the parse tree
	 */
	void exitLista_alimentacao(ComprasParser.Lista_alimentacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComprasParser#total_compra}.
	 * @param ctx the parse tree
	 */
	void enterTotal_compra(ComprasParser.Total_compraContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComprasParser#total_compra}.
	 * @param ctx the parse tree
	 */
	void exitTotal_compra(ComprasParser.Total_compraContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComprasParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(ComprasParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComprasParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(ComprasParser.ItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComprasParser#nome}.
	 * @param ctx the parse tree
	 */
	void enterNome(ComprasParser.NomeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComprasParser#nome}.
	 * @param ctx the parse tree
	 */
	void exitNome(ComprasParser.NomeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComprasParser#valor}.
	 * @param ctx the parse tree
	 */
	void enterValor(ComprasParser.ValorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComprasParser#valor}.
	 * @param ctx the parse tree
	 */
	void exitValor(ComprasParser.ValorContext ctx);
}