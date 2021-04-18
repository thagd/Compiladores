package br.ufscar.dc.compiladores.t4;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
        
public class TabelaDeSimbolos {
    
    private final Map<String, EntradaTabelaDeSimbolos> tabela;

    // Inicializa a tabela de símbolos
    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }
    
    // métodos para inserir na tabela de símbolos
    public void inserir(String nome) {
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome));
    }
    
    // verifica se uma string existe na tabela de símbolos
    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }
}