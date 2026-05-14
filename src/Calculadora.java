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
            return total *= 0.85;
        } else if (total > 200) {
            return total *= 0.9;
        }
        return total;
    }
}