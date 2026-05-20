public class Sistema {

        public static void main(String[] args) {

                Estoque estoque = new Estoque();
                estoque.adicionarProduto(new Produto("Notebook", 3000, 10));
                estoque.adicionarProduto(new Produto("Mouse", 100, 50));

                estoque.listarProdutos();

                Cliente cliente = new Cliente("Maria", "maria@email.com", "SC");

                Pedido p = new Pedido(cliente, estoque, "Cartao");


                p.adicionarItem("Notebook", 3000, 1);
                p.adicionarItem("Mouse", 100, 2);

                p.finalizar();

                RelatorioService r = new RelatorioService();
                r.gerar(p);

                BancoDeDados.salvarLog("Sistema finalizado");
        }
}