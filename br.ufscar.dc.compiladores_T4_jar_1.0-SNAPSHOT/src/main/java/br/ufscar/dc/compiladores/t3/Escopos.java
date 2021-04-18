package br.ufscar.dc.compiladores.t3;

import java.util.LinkedList;
import java.util.List;

public class Escopos {

    private LinkedList<TabelaDeSimbolos> pilhaDeTabelas;

    // incializa com um escopo já criado
    public Escopos() {
        pilhaDeTabelas = new LinkedList<>();
        criarNovoEscopo();
    }

    public void criarNovoEscopo() {
        pilhaDeTabelas.push(new TabelaDeSimbolos());
    }

    public TabelaDeSimbolos obterEscopoAtual() {
        return pilhaDeTabelas.peek();
    }

    public List<TabelaDeSimbolos> percorrerEscoposAninhados() {
        return pilhaDeTabelas;
    }

    public void abandonarEscopo() {
        pilhaDeTabelas.pop();
    }
}