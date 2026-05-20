import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto>  produtos;

    public Estoque(){
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void listarProdutos(){
        System.out.println("Produtos no estoque:");
        for (Produto p: produtos) {
            System.out.println("Nome: " + p.nome() + " | Valor: " + p.preco() + " | Quantidade: " + p.quantidade());
        }
    }
}
