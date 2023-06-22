package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EstoqueSingleton estoque = EstoqueSingleton.getInstance();

        Scanner teclado = new Scanner(System.in);

        int iOpcao = 0;

        do {
            System.out.println("Qual ação você deseja realizar?\n1 - adicionar itens ao estoque\n2 - remover itens do estoque\n3 - exibir itens do estoque\n4 - exibir situação estoque\n0 - encerrar programa");
            iOpcao = Integer.parseInt(teclado.nextLine());

            switch (iOpcao) {
                case 0: break;

                case 1: {
                    System.out.println("Informe os dados do produto:\nNome do produto: ");
                    String sNomeProduto = teclado.nextLine();

                    System.out.println("Descrição do produto: ");
                    String sDescProduto = teclado.nextLine();

                    System.out.println("Quantidade do produto: ");
                    int iQtd = Integer.parseInt(teclado.nextLine());

                    Produto item = new Produto(sNomeProduto, sDescProduto, iQtd);
                    estoque.adicionarItem(item);
                } break;

                case 2: {
                    System.out.println("Informe os dados do produto:\nNome do produto: ");
                    String sNomeProduto = teclado.nextLine();

                    System.out.println("Descrição do produto: ");
                    String sDescProduto = teclado.nextLine();

                    System.out.println("Quantidade do produto: ");
                    int iQtd = Integer.parseInt(teclado.nextLine());

                    Produto item = new Produto(sNomeProduto, sDescProduto, iQtd);
                    estoque.removerItem(item);
                } break;

                case 3: { estoque.exibirEstoque(); } break;

                case 4: { estoque.exibirSituacaoEstoque(); } break;

                default: {
                    System.out.println("Opção inválida");
                }
            }

        } while (iOpcao != 0);
    }
}