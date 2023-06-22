package org.example;

public class EstadoEstoqueBaixo implements EstadoEstoque {
    EstoqueSingleton estoqueSingleton;
    public EstadoEstoqueBaixo(EstoqueSingleton estoqueSingleton) { this.estoqueSingleton = estoqueSingleton; }
    @Override
    public void adicionarItem(Produto item) {
        if (this.estoqueSingleton.existeProduto(item)) {
            for (Produto itemAtual : this.estoqueSingleton.produtos) {
                if (itemAtual.equals(item)) {
                    itemAtual.setQuantidade(itemAtual.getQuantidade() + item.getQuantidade());
                    break;
                }
            }
        } else {
            this.estoqueSingleton.produtos.add(item);
        }

        if (this.estoqueSingleton.verificarQuantidadeTotal() >= 10) {
            this.estoqueSingleton.alterarEstado(new EstadoEstoqueNormal(this.estoqueSingleton));
        }
    }

    @Override
    public void removerItem(Produto item) {
        if (!this.estoqueSingleton.existeProduto(item)) {
            System.out.println("Produto inexistente no estoque");
            return;
        }

        for (Produto itemAtual : this.estoqueSingleton.produtos) {
            if (itemAtual.equals(item)) {
                if (itemAtual.getQuantidade() < item.getQuantidade()) {
                    System.out.println("Não é possível remover quantidade maior que a disponível");
                } else {
                    itemAtual.setQuantidade(itemAtual.getQuantidade() - item.getQuantidade());

                    if (itemAtual.getQuantidade() == 0) {
                        this.estoqueSingleton.produtos.remove(itemAtual);
                    }

                    if (this.estoqueSingleton.verificarQuantidadeTotal() == 0) {
                        this.estoqueSingleton.alterarEstado(new EstadoEstoqueSemEstoque(this.estoqueSingleton));
                    } else if (this.estoqueSingleton.verificarQuantidadeTotal() <= 3) {
                        this.estoqueSingleton.alterarEstado(new EstadoEstoqueCritico(this.estoqueSingleton));
                    }
                }

                return;
            }
        }
    }

    @Override
    public void exibirEstoque() {
        for (Produto item : this.estoqueSingleton.produtos) {
            System.out.printf("{\n\tProduto: %s,\n\tDescrição: %s,\n\tQuantidade: %d\n}\n", item.getNome(), item.getDescricao(), item.getQuantidade());
        }
    }

    @Override
    public void exibirSituacaoEstoque() {
        System.out.println("Situação do Estoque: Baixo");
    }
}
