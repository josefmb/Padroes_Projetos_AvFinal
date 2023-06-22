package org.example;

public interface EstadoEstoque {
    void adicionarItem(Produto item);
    void removerItem(Produto item);
    void exibirEstoque();
    void exibirSituacaoEstoque();
}
