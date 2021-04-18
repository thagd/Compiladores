package br.ufscar.dc.compiladores.t3;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
        
public class TabelaDeSimbolos {
    public enum TipoVariavel {
        LITERAL,
        INTEIRO,
        REAL,
        LOGICO,
        INVALIDO,
        REGISTRO,
        TIPOESTENDIDO
    }

    public enum TipoEntrada {
        TIPO,
        FUNCAO,
        PROCEDIMENTO,
        VARIAVEL,
        CONSTANTE,
        PARAMETRO
    }
    
    private final Map<String, EntradaTabelaDeSimbolos> tabela;

    // Inicializa a tabela de símbolos
    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }
    
    // métodos para inserir na tabela de símbolos
    public void inserir(String nome, TipoVariavel tipoVariavel, TipoEntrada tipoEntrada, boolean ponteiro) {
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipoVariavel, tipoEntrada, ponteiro));
    }
    
    public void inserir(String nome, TipoVariavel tipoVariavel, TipoEntrada tipoEntrada, TabelaDeSimbolos subTabela, boolean ponteiro) {
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipoVariavel, tipoEntrada, subTabela, ponteiro));
    }
    
    public void inserir(String nome, TipoVariavel tipoVariavel, TipoEntrada tipoEntrada, TabelaDeSimbolos subTabela, List<TipoVariavel> tiposParametros, boolean ponteiro) {
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipoVariavel, tipoEntrada, subTabela, tiposParametros, ponteiro));
    }
    
    // retorna o conteúdo da subtabela inserida na tabela de símbolos
    public TabelaDeSimbolos verificarSubtabela(String nome){
        return tabela.get(nome).subTabela;
    }
    
    // retorna o conteúdo do tiposParametros inserido na tabela de símbolos
    public List<TipoVariavel> verificarTiposParametros(String nome){
        return tabela.get(nome).tiposParametros;
    }
    
    // verifica o tipo de uma variável inserida na tabela de símbolos
    public TipoVariavel verificarVariavel(String nome) {
        return tabela.get(nome).tipoVariavel;
    }
    
    // verifica se uma string existe na tabela de símbolos
    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }
}