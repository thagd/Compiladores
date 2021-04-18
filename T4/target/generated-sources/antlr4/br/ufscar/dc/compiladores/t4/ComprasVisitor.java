// Generated from br/ufscar/dc/compiladores/t4/Compras.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.t4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ComprasParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ComprasVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ComprasParser#lista_compras}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_compras(ComprasParser.Lista_comprasContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComprasParser#lista_padaria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_padaria(ComprasParser.Lista_padariaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComprasParser#lista_acougue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_acougue(ComprasParser.Lista_acougueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComprasParser#lista_hortifruti}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_hortifruti(ComprasParser.Lista_hortifrutiContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComprasParser#lista_higiene}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_higiene(ComprasParser.Lista_higieneContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComprasParser#lista_limpeza}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_limpeza(ComprasParser.Lista_limpezaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComprasParser#lista_bebidas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_bebidas(ComprasParser.Lista_bebidasContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComprasParser#lista_alimentacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_alimentacao(ComprasParser.Lista_alimentacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComprasParser#total_compra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTotal_compra(ComprasParser.Total_compraContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComprasParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(ComprasParser.ItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComprasParser#nome}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNome(ComprasParser.NomeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComprasParser#valor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor(ComprasParser.ValorContext ctx);
}