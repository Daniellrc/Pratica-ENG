public class Cliente {
    public String nome;
    public String email;
    public String endereco;

    public Cliente(String nome, String email, String endereco) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }

    public boolean isDeSantaCatarina() {
        return endereco.contains("SC");
    }
}