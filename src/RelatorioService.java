public class RelatorioService {

    public void gerar(Pedido p) {

        IO.println("Cliente: " + p.cliente.nome);
        IO.println("Email: " + p.cliente.email);
        IO.println("Endereço: " + p.cliente.endereco);

        for (Produto produto : p.produtosPedido) {
            IO.println(produto.nome() + " | R$" + produto.preco() + " | " + produto.quantidade() + "x | Subtotal: R$" + produto.getTotal());
        }
        IO.println("Forma de pagamento: " + p.tipo);
        IO.println("Subtotal: R$" + p.total);
        IO.println("Frete: R$" + p.frete);
        IO.println("Total com frete: R$" + (p.total + p.frete));
        IO.println("Dados do pedido foram enviados para o email: " + p.cliente.email);


        if (p.total > 1000) {
            IO.println("Cliente VIP");
        }

        IO.println("Status: " + p.status);
    }
}