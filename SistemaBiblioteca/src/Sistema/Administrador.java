package Sistema;

public class Administrador extends Usuario {

    public Administrador(String nome, String RG, String CPF, String dataNascimento, String email, String endereco, String telefone, String nomeUsuario, String nivelAcesso, String senha, String dataCadastro) {
        super(nome, RG, CPF, dataNascimento, email, endereco, telefone, nomeUsuario, nivelAcesso, senha, dataCadastro);
    }

    @Override
    public String toString() {
        return super.toString() + "\n";
    }
}
