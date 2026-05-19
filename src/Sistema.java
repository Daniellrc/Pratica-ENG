void main(String[] args) {

        Cliente cliente = new Cliente("Maria", "maria@email.com", "SC");
       
        Pedido p = new Pedido(cliente);

        p.adicionarItem("Notebook", 3000, 1);
        p.adicionarItem("Mouse", 100, 2);

        p.finalizar();

        BancoDeDados.salvarLog("Sistema finalizado");

        RelatorioService r = new RelatorioService();
        r.gerar(p);

        IO.println("Frete: " + p.getFrete());
        IO.println("Status: " + p.getStatus());
}