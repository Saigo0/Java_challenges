package Sistema;

public class Usuario {
    private String nome;
    private String email;
    private int idUsuario;

    public Usuario(String nome, String email, int idUsuario) {
        this.nome = nome;
        this.email = email;
        this.idUsuario = idUsuario;
    }

    public boolean setNome(String nome) {
        if (!nome.equals(" ")) {
            this.nome = nome;
            return true;
        } else return false;
    }

    public boolean setEmail(String email) {
        if (!email.equals(" ")) {
            this.email = email;
            return true;
        } else return false;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    @Override
    public String toString() {
        return "Nome: " + this.nome + ", " +
                "Email: " + this.email + ", " +
                "Id do Usuário: " + this.idUsuario;
    }
}


