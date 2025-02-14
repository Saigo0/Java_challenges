package Sistema;

public class UsuarioEspecial extends UsuarioSimples {
    private CategoriasUsuarioEspecial nivelBeneficio;
    private String dataValidade;

    public UsuarioEspecial(String nome, String RG, String CPF, String dataNascimento, String email, String endereco, String telefone, String nomeUsuario, String nivelAcesso, String senha, String dataCadastro, String preferencias, double valorPago) {
        super(nome, RG, CPF, dataNascimento, email, endereco, telefone, nomeUsuario, nivelAcesso, senha, dataCadastro, preferencias);
        Biblioteca biblioteca = Biblioteca.getInstancia();
        this.setNivelBeneficio(valorPago);
    }

    private void setNivelBeneficio(double valorPago) {
        this.nivelBeneficio = CategoriasUsuarioEspecial.getCategoriaPorValorPago(valorPago);
    }

    public CategoriasUsuarioEspecial getNivelBeneficio() {
        return this.nivelBeneficio;
    }

    public String getDataValidade() {
        return this.dataValidade;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Nível de benefício: " + this.getNivelBeneficio() + "\n" +
                "Data de validade do benefício: " + this.getDataValidade() + "\n";
    }
}