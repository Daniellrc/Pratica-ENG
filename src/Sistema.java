void main(String[] args) {

        Pedido p = new Pedido();

        p.setClienteNome("Maria");
        p.setClienteEmail("maria@email.com");
        p.setClienteEndereco("SC");

        p.adicionarItem("Notebook", 3000, 1);
        p.adicionarItem("Mouse", 100, 2);

        p.finalizar();

        BancoDeDados.salvarLog("Sistema finalizado");

        RelatorioService r = new RelatorioService();
        r.gerar(p);

        IO.println("Frete: " + p.getFrete());
        IO.println("Status: " + p.getStatus());
}