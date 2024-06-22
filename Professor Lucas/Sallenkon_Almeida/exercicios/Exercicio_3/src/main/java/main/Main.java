package main;

import entidade.CarrinhoDeCompra;
import entidade.Produto;

public class Main {
    public static void main(String[] args) {

        Produto p1 = new Produto("sapato oxford", 699.00, 1);
        Produto p2 = new Produto("tenis casual", 249.90, 1);
        Produto p3 = new Produto("camisa polo", 49.90, 2);

        CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
        carrinho.adicionarProduto(p1);
        carrinho.adicionarProduto(p2);
        carrinho.adicionarProduto(p3);

        carrinho.listarProdutos();

    }
}
