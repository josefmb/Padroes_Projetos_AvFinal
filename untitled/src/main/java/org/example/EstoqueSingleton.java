package org.example;

import java.util.LinkedHashSet;

public class EstoqueSingleton {
    private static EstoqueSingleton instance;
    private EstadoEstoque estado;

    protected LinkedHashSet<Produto> produtos;

    private EstoqueSingleton() {
        estado = new EstadoEstoqueSemEstoque(this);
        produtos = new LinkedHashSet<>();
    }

    public static EstoqueSingleton getInstance() {
        if (instance == null) {
            instance = new EstoqueSingleton();
        }

        return instance;
    }

    public void adicionarItem(Produto item) {
        estado.adicionarItem(item);
    }

    public void removerItem(Produto item) {
        estado.removerItem(item);
    }

    public void alterarEstado(EstadoEstoque novoEstado) {
        estado = novoEstado;
    }

    public void exibirEstoque() {
        estado.exibirEstoque();
    }

    public void exibirSituacaoEstoque() {
        estado.exibirSituacaoEstoque();
    }

    public int verificarQuantidadeTotal() {
        int qtd = 0;

        for (Produto item : this.produtos) {
            qtd += item.getQuantidade();
        }

        return qtd;
    }

    public boolean existeProduto(Produto item) {
        for (Produto itemAtual : this.produtos) {
            if (itemAtual.equals(item)) return true;
        }

        return false;
    }
}