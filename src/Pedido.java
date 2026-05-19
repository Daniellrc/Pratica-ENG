import java.util.*;

public class Pedido {

    private final List<Produto> produtos = new ArrayList<>();

    private Cliente cliente;

    private double total;
    private double frete;
    private String status;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.status = "PENDENTE";
    }

    public void adicionarItem(String nome, double preco, int qtd) {
        produtos.add(new Produto(nome, preco, qtd));
    }

    private void atualizarEstoque() {
        for (Produto p : produtos) {
            IO.println("Atualizando estoque de: " + p);
        }
    }

    private void processarPagamento(String tipo) {
        switch (tipo) {
            case "cartao" -> IO.println("Pagamento cartão OK");
            case "boleto" -> IO.println("Boleto gerado");
            case "pix" -> IO.println("PIX enviado");
        }
    }

    private void enviarNotificacao() {
        IO.println("Email enviado para " + cliente.email);
    }

    private void gerarRelatorio() {
        IO.println("Relatorio do pedido:");
        for (Produto p : produtos) {
            IO.println(p);
        }
        IO.println("Total: " + total);
    }

    private void salvarNoBanco() {
        BancoDeDados.salvarPedido(this);
        BancoDeDados.salvarLog("Pedido salvo: " + cliente.nome);
    }

    public void finalizar() {
        total = Calculadora.calcularTotal(produtos);
        total = Calculadora.aplicarDesconto(total);
        frete = Calculadora.calcularFrete(total, cliente.endereco);
        atualizarEstoque();
        processarPagamento("cartao");
        enviarNotificacao();
        gerarRelatorio();
        salvarNoBanco();
        status = "FINALIZADO";
    }

    public String getStatus() {
        return status;
    }

    public double getFrete() {
        return frete;
    }

    public double getTotal() {
        return total;
    }

    public Cliente getCliente(){
        return cliente;
    }
}