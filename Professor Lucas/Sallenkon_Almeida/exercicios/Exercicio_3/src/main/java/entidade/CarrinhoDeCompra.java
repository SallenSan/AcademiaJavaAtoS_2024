package entidade;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompra {
    private List<Produto> produtos;

    public CarrinhoDeCompra() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void listarProdutos() {
        System.out.println(" Produto || Valor unitário || Quantidade || Sub-total:");
        for (Produto produto : produtos){
            System.out.println(produto);
        }
        System.out.format("Valor total: R$ %.2f%n", valorTotal());
    }
    private double valorTotal(){
        double total = 0;
        for (Produto produto : produtos){
            total += produto.getSubTotal();
        }
        return total;
    }
}
