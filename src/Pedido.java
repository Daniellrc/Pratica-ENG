import java.util.*;

public class Pedido {

    public List<String> produtos = new ArrayList<>();
    public List<Double> precos = new ArrayList<>();
    public List<Integer> quantidades = new ArrayList<>();

    public String clienteNome;
    public String clienteEmail;
    public String clienteEndereco;

    public double total;
    public double frete;
    public String status;

    private RelatorioService relatorioService = new RelatorioService();

    public void adicionarItem(String nome, double preco, int qtd) {
        produtos.add(nome);
        precos.add(preco);
        quantidades.add(qtd);
    }

    public void atualizarEstoque() {
        for (String p : produtos) {
            System.out.println("Atualizando estoque de: " + p);
        }
    }

    public void processarPagamento(String tipo) {
        if (tipo.equals("cartao")) {
            System.out.println("Pagamento cartão OK");
        } else if (tipo.equals("boleto")) {
            System.out.println("Boleto gerado");
        } else if (tipo.equals("pix")) {
            System.out.println("PIX enviado");
        }
    }

    public void enviarNotificacao() {
        System.out.println("Email enviado para " + clienteEmail);
    }

    public void gerarRelatorio() {
        System.out.println("Relatorio do pedido:");
        for (String p : produtos) {
            System.out.println(p);
        }
        System.out.println("Total: " + total);
    }

    public void salvarNoBanco() {
        BancoDeDados.salvarPedido(this);
        BancoDeDados.salvarLog("Pedido salvo: " + clienteNome);
    }

    public void finalizar() {
//        Passar lista de produtos como argumento
//        Calculadora.calcularTotal();
//        Calculadora.aplicarDesconto();
//        Calculadora.calcularFrete();

        atualizarEstoque();
        processarPagamento("cartao");
        enviarNotificacao();
        gerarRelatorio();
        salvarNoBanco();
        status = "FINALIZADO";
    }
}