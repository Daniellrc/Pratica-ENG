import java.util.List;

public class Calculadora {
    public static double calcularTotal(List<Produto> produtos) {
        double total = 0;

        for (Produto p : produtos) {
            total += p.getTotal();
        }
        return total;
    }

    public static double calcularFrete(double total, String endereco) {
        if (endereco.contains("SC")) {
            return total * 0.05;
        } else {
            return total * 0.15;
        }
    }

    public static double aplicarDesconto(double total) {
        if (total > 500) {
            total *= 0.85;
        } else if (total > 200) {
            total *= 0.9;
        }
        return total;
    }

    public static String processarPagamento(String tipo) {
        switch (tipo.toLowerCase()) {
            case "cartao" -> tipo = "Pagamento cartão OK";
            case "boleto" -> tipo = "Boleto gerado";
            case "pix" -> tipo = "PIX enviado";
        }
        return tipo;
    }
}