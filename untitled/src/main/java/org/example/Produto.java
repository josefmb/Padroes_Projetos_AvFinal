package org.example;

public class Produto {
    private String nome;
    private String descricao;
    private int quantidade;

    public Produto(String nome, String descricao, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean equals(Produto item) {
        return this.getNome().equals(item.getNome()) && this.getDescricao().equals(item.getDescricao());
    }
}
