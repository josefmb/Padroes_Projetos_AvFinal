package org.example;

public class EstadoEstoqueSemEstoque implements EstadoEstoque {
    EstoqueSingleton estoqueSingleton;

    public EstadoEstoqueSemEstoque(EstoqueSingleton estoqueSingleton) {
        this.estoqueSingleton = estoqueSingleton;
    }

    @Override
    public void adicionarItem(Produto item) {
        this.estoqueSingleton.produtos.add(item);

        if (this.estoqueSingleton.verificarQuantidadeTotal() >= 10) {
            this.estoqueSingleton.alterarEstado(new EstadoEstoqueNormal(this.estoqueSingleton));
        } else if (this.estoqueSingleton.verificarQuantidadeTotal() >= 3) {
            this.estoqueSingleton.alterarEstado(new EstadoEstoqueBaixo(this.estoqueSingleton));
        } else {
            this.estoqueSingleton.alterarEstado(new EstadoEstoqueCritico(this.estoqueSingleton));
        }
    }

    @Override
    public void removerItem(Produto item) {
        System.out.println("Não é possível remover item do estoque sem estoque.");
    }

    @Override
    public void exibirEstoque() {
        System.out.println("Não há produtos no estoque!");
    }

    @Override
    public void exibirSituacaoEstoque() {
        System.out.println("Situação do Estoque: Sem Estoque");
    }
}
