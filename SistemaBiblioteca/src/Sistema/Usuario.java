package Sistema;

public abstract class Usuario extends Pessoa {
    public static int cod = 1;
    private int id;
    private String nomeUsuario;
    private String nivelAcesso;
    private String senha = "";
    private String dataCadastro = "";

    public Usuario(String nome, String RG, String CPF, String dataNascimento, String email, String endereco, String telefone, String nomeUsuario, String nivelAcesso, String senha, String dataCadastro) {
        super(nome, RG, CPF, dataNascimento, email, endereco, telefone);
        this.setId();
        this.setNomeUsuario(nomeUsuario);
        this.setNivelAcesso(nivelAcesso);
        this.setSenha(senha);
        this.setDataCadastro(dataCadastro);

    }

    private void setId() {
        this.id = Usuario.cod++;
    }

    public boolean setNomeUsuario(String nomeUsuario) {
        if (!nomeUsuario.isBlank()) {
            this.nomeUsuario = nomeUsuario;
            return true;
        } else return false;
    }

    public boolean setNivelAcesso(String nivelAcesso) {
        if (!nivelAcesso.isBlank()) {
            this.nivelAcesso = nivelAcesso;
            return true;
        } else return false;
    }

    public boolean setSenha(String senha) {
        if (!senha.isBlank()) {
            this.senha = senha;
            return true;
        } else
            return false;
    }

    public boolean setDataCadastro(String dataCadastro) {
        if (!dataCadastro.isBlank()) {
            this.dataCadastro = dataCadastro;
            return true;
        } else
            return false;
    }

    public int getId() {
        return this.id;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public String getNivelAcesso() {
        return this.nivelAcesso;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getDataCadastro() {
        return this.dataCadastro;
    }

    public String toString() {
        return super.toString() + "\n" +
                "ID: " + this.getId() + "\n" +
                "Nome de Usuário: " + this.getNomeUsuario() + "\n" +
                "Nível Acesso: " + this.getNivelAcesso() + "\n" +
                "Senha: " + this.getSenha() + "\n" +
                "Data de cadastro: " + this.getDataCadastro() + "\n";
    }

}