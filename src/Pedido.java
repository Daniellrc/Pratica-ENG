import java.util.*;

public class Pedido {

    protected Cliente cliente;
    protected List<Produto> estoque;
    protected List<Produto> produtosPedido;
    protected double total;
    protected String tipo;
    protected double frete;
    protected String status;

    public Pedido(Cliente cliente, Estoque estoque, String tipo) {
        this.cliente = cliente;
        this.estoque = estoque.getProdutos();
        this.produtosPedido = new ArrayList<>();
        this.tipo=Calculadora.processarPagamento(tipo);
        this.status = "PENDENTE";
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        Produto produtoPedido = new Produto(nome, preco, quantidade);
        produtosPedido.add(produtoPedido);
    }

    public void finalizar() {
        this.total = Calculadora.calcularTotal(produtosPedido);
        this.total = Calculadora.aplicarDesconto(this.total);
        this.frete = Calculadora.calcularFrete(this.total, cliente.endereco);
        this.status = "FINALIZADO";

        BancoDeDados.salvarPedido(this);
        BancoDeDados.salvarLog("Pedido finalizado: " + cliente.nome);
    }
}