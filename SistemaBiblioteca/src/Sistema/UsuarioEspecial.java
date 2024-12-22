package Sistema;

public class UsuarioEspecial extends UsuarioSimples {
    private String nivelBeneficio;
    private GerenciaPlanos plano;
    private String dataValidade;
    //Pra ser um usuário especial, é pago um valor de inscrição, que varia de acordo com o plano solicitado
    //Podem pegar mais de 10 livros de uma vez, não pagam ou recebem descontos em multas geradas por atrasos, Prazo de devolução estendido

    public UsuarioEspecial(String nome, String RG, String CPF, String dataNascimento, String email, String endereco, String telefone, String nomeUsuario, String nivelAcesso, String senha, String dataCadastro, String preferencias, double valorPago) {
        super(nome, RG, CPF, dataNascimento, email, endereco, telefone, nomeUsuario, nivelAcesso,  senha, dataCadastro, preferencias);
        Biblioteca biblioteca = Biblioteca.getInstancia();
        this.setNivelBeneficio(biblioteca, valorPago);
    }

    private void setNivelBeneficio(Biblioteca biblioteca, double valorPago) {
        this.nivelBeneficio = biblioteca.verificaNivelBeneficio(valorPago);
    }

    public String getNivelBeneficio() {
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