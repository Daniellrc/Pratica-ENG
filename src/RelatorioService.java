public class RelatorioService {

    public void gerar(Pedido p) {
        IO.println("Cliente: " + p.getClienteNome());
        IO.println("Total com frete: " + (p.getTotal() + p.getFrete()));

        if (p.getTotal() > 1000) {
            IO.println("Cliente VIP");
        }
    }
}