package br.ufscar.dc.compiladores.t3;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import br.ufscar.dc.compiladores.t3.TabelaDeSimbolos.TipoEntrada;
import br.ufscar.dc.compiladores.t3.TabelaDeSimbolos.TipoVariavel;

public class LASemantico extends LABaseVisitor<Void> {

    Escopos escoposAninhados = new Escopos();

    @Override
    public Void visitPrograma(LAParser.ProgramaContext ctx) {
        // verifica erro de retorne no corpo do programa
        if (ctx.corpo().cmd() != null) {
            ctx.corpo().cmd().forEach(cmd -> {
                if (cmd.cmdRetorne() != null) {
                    LASemanticoUtils.adicionarErroSemantico(cmd.cmdRetorne().getStart(), "comando retorne nao permitido nesse escopo");
                }
            });
        }
        return super.visitPrograma(ctx);
    }
    
    @Override
    public Void visitDeclaracao_global(LAParser.Declaracao_globalContext ctx) {
        List<TipoVariavel> tiposParametros = new ArrayList<>();

        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        // criação de novo escopo para função/procedimento
        escoposAninhados.criarNovoEscopo();
        TabelaDeSimbolos subEscopo = escoposAninhados.obterEscopoAtual();

        // verifica tipos dos parâmetros
        for (LAParser.ParametroContext parametro : ctx.parametros().parametro()) {
            if (parametro.tipo_estendido().tipo_basico_ident().tipo_basico() != null) {
                for (LAParser.IdentificadorContext identificador : parametro.identificador()) {
                    subEscopo.inserir(identificador.getText(), LASemanticoUtils.verificaTipo(parametro.tipo_estendido().tipo_basico_ident().tipo_basico().getText()), TipoEntrada.VARIAVEL, false);
                    tiposParametros.add(LASemanticoUtils.verificaTipo(parametro.tipo_estendido().tipo_basico_ident().tipo_basico().getText()));
                }
            } else {
                TabelaDeSimbolos tiposParametrosExistente = escopoAtual.existe(parametro.tipo_estendido().getText()) ? escopoAtual.verificarSubtabela(parametro.tipo_estendido().getText()) : null;
                for (LAParser.IdentificadorContext identificador : parametro.identificador()) {
                    subEscopo.inserir(identificador.getText(), TipoVariavel.TIPOESTENDIDO, TipoEntrada.VARIAVEL, tiposParametrosExistente, false);
                    tiposParametros.add(TipoVariavel.TIPOESTENDIDO);
                }
            }
        }
        
        if (ctx.tipo_estendido() != null) {
            if (ctx.tipo_estendido().tipo_basico_ident().tipo_basico() != null) {
                escopoAtual.inserir(ctx.IDENT().getText(), LASemanticoUtils.verificaTipo(ctx.tipo_estendido().tipo_basico_ident().tipo_basico().getText()), TipoEntrada.FUNCAO, subEscopo, tiposParametros, false);
            } else {
                escopoAtual.inserir(ctx.IDENT().getText(), TipoVariavel.TIPOESTENDIDO, TipoEntrada.FUNCAO, subEscopo, tiposParametros, false);
            }
        } else {
            escopoAtual.inserir(ctx.IDENT().getText(), TipoVariavel.INVALIDO, TipoEntrada.PROCEDIMENTO, subEscopo, tiposParametros, false);
        }
        
        ctx.declaracao_local().forEach(declaracao_local -> {
            visitDeclaracao_local(declaracao_local);
        });
        
        for (LAParser.CmdContext cmd : ctx.cmd()) {
            // verifica erro de retorne no corpo do procedimento
            if (ctx.tipo_estendido() == null && cmd.cmdRetorne() != null) {
                LASemanticoUtils.adicionarErroSemantico(cmd.getStart(), "comando retorne nao permitido nesse escopo");
            } else {
                super.visitCmd(cmd);
            }
        }
        
        escoposAninhados.abandonarEscopo();
        return null;
    }
    
    @Override
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx) {
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        
        if (ctx.tipo_basico() != null) {
            escopoAtual.inserir(ctx.IDENT().getText(), LASemanticoUtils.verificaTipo(ctx.tipo_basico().getText()), TipoEntrada.CONSTANTE, false); 
        } else if (ctx.tipo() != null) {
            escoposAninhados.criarNovoEscopo();
            visitRegistro(ctx.tipo().registro());
            escoposAninhados.abandonarEscopo();
            escoposAninhados.obterEscopoAtual().inserir(ctx.IDENT().getText(), TipoVariavel.REGISTRO, TipoEntrada.TIPO, escoposAninhados.obterEscopoAtual(), false);
        }
        return super.visitDeclaracao_local(ctx);
    }

    @Override
    public Void visitVariavel(LAParser.VariavelContext ctx) {
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();

        TipoVariavel tipoVariavel = TipoVariavel.INVALIDO;
        TabelaDeSimbolos escopoRegistro = null;

        if (ctx.tipo().registro() != null) {
            escoposAninhados.criarNovoEscopo();
            visitRegistro(ctx.tipo().registro());
            escopoRegistro = escoposAninhados.obterEscopoAtual();
            escoposAninhados.abandonarEscopo();
            tipoVariavel = TipoVariavel.REGISTRO;
        } else {
            if (ctx.tipo().tipo_estendido().tipo_basico_ident().tipo_basico() != null) {
                tipoVariavel = LASemanticoUtils.verificaTipo(ctx.tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText());
            } else {
                tipoVariavel = TipoVariavel.TIPOESTENDIDO;
                String tipoIdent = ctx.tipo().tipo_estendido().tipo_basico_ident().IDENT().getText();
                if (escopoAtual.existe(tipoIdent)) {
                    escopoRegistro = escopoAtual.verificarSubtabela(tipoIdent);
                } else {
                    LASemanticoUtils.adicionarErroSemantico(ctx.getStart(), "tipo " + tipoIdent + " nao declarado");
                }
            }
        }
        for (LAParser.IdentificadorContext identificador : ctx.identificador()) {
            boolean jaExiste = false;
            for(TabelaDeSimbolos tabela : escoposAninhados.percorrerEscoposAninhados()){if(tabela.existe(identificador.getText())){jaExiste = true;}};
            if (jaExiste) {
                LASemanticoUtils.adicionarErroSemantico(identificador.getStart(), "identificador " + identificador.getText() + " ja declarado anteriormente");
            } else{
                String nome = identificador.subIdent.size() > 0 ? identificador.subIdent.get(0).getText() : identificador.ident1.getText();
                escopoAtual.inserir(nome, tipoVariavel, TipoEntrada.VARIAVEL, escopoRegistro, false);
            }
        }
        return super.visitVariavel(ctx);
    }
    
    @Override
    public Void visitIdentificador(LAParser.IdentificadorContext ctx) {
        String nomeIdent = ctx.ident1.getText();
        if (escoposAninhados.obterEscopoAtual().existe(nomeIdent)) {
            if (ctx.subIdent.size() > 0) {
                TabelaDeSimbolos subTabela = escoposAninhados.obterEscopoAtual().verificarSubtabela(nomeIdent);
                ctx.subIdent.stream().filter(t -> (subTabela.existe(t.getText()) == false)).forEachOrdered(t -> {
                    LASemanticoUtils.adicionarErroSemantico(t, "identificador " + ctx.getText() + " nao declarado");
                });
            } 
        } else {
            if (ctx.subIdent.size() > 0) {
                LASemanticoUtils.adicionarErroSemantico(ctx.getStart(), "identificador " + nomeIdent + "." + ctx.subIdent.get(0).getText() + " nao declarado");
            } else {
                LASemanticoUtils.adicionarErroSemantico(ctx.getStart(), "identificador " + nomeIdent + " nao declarado");
            }
        }
        return null;
    }

    @Override
    public Void visitCmdAtribuicao(LAParser.CmdAtribuicaoContext ctx) {
        TipoVariavel tipoIdentificador = LASemanticoUtils.verificaTipo(escoposAninhados, ctx.identificador());
        TipoVariavel tipoExpressao = LASemanticoUtils.verificaTipo(escoposAninhados, ctx.expressao());

        if (tipoIdentificador != TipoVariavel.INVALIDO && ((tipoExpressao == TipoVariavel.INVALIDO) || (tipoIdentificador != tipoExpressao && !(tipoIdentificador == TipoVariavel.REAL && tipoExpressao == TipoVariavel.INTEIRO)))) {
            String mensagem;
            if (ctx.ponteiro == null) {
                mensagem = String.format("atribuicao nao compativel para %s", ctx.identificador().getText());
            } else {
                mensagem = String.format("atribuicao nao compativel para ^%s", ctx.identificador().getText());
            }
            LASemanticoUtils.adicionarErroSemantico(ctx.getStart(), mensagem);
        }
        return super.visitCmdAtribuicao(ctx);
    }
    
    @Override
    public Void visitParcela_unario(LAParser.Parcela_unarioContext ctx) {
        if (ctx.ident != null) {
            List<TipoVariavel> tiposParametros;
            for (TabelaDeSimbolos tabela : escoposAninhados.percorrerEscoposAninhados()) {
                if (tabela.existe(ctx.IDENT().getText())) {
                    tiposParametros = tabela.verificarTiposParametros(ctx.IDENT().getText());
                    if (tiposParametros.size() != ctx.expressao().size()) {
                        LASemanticoUtils.adicionarErroSemantico(ctx.getStart(), "incompatibilidade de parametros na chamada de " + ctx.IDENT().getText());
                    } else {
                        for (TabelaDeSimbolos tabelaInterna : escoposAninhados.percorrerEscoposAninhados()) {
                            for (int i = 0; i < tiposParametros.size(); i++) {
                                if (tabelaInterna.existe(ctx.expressao(i).getText())) {
                                    if (tiposParametros.get(i) != LASemanticoUtils.verificaTipo(escoposAninhados, ctx.expressao(i))) {
                                        LASemanticoUtils.adicionarErroSemantico(ctx.getStart(), "incompatibilidade de parametros na chamada de " + ctx.IDENT().getText());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return super.visitParcela_unario(ctx);
    }
}