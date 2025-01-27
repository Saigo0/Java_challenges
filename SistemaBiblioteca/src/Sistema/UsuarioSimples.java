package Sistema;

public class UsuarioSimples extends Usuario {
    private String preferencias;

    public UsuarioSimples(String nome, String RG, String CPF, String dataNascimento, String email, String endereco, String telefone, String nomeUsuario, String nivelAcesso, String senha, String dataCadastro, String preferencias) {
        super(nome, RG, CPF, dataNascimento, email, endereco, telefone, nomeUsuario, nivelAcesso, senha, dataCadastro);
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public String getPreferencias() {
        return this.preferencias;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Preferencias: " + this.getPreferencias();
    }
}
