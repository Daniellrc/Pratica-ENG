public record Produto (String nome, double preco, int quantidade) {
    public double getTotal() {
        return preco * quantidade;
    }
}