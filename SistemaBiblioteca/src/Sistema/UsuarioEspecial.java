package Sistema;

public class UsuarioEspecial extends UsuarioSimples {
    private String nivelBeneficio;
    private String dataValidade;

    public UsuarioEspecial(String nome, String RG, String CPF, String dataNascimento, String email, String endereco, String telefone, String nomeUsuario, String nivelUsuario, String senha, String dataCadastro, String preferencias, String nivelBeneficio, String dataValidade) {
        super(nome, RG, CPF, dataNascimento, email, endereco, telefone, nomeUsuario, nivelUsuario,  senha, dataCadastro, preferencias);
        this.setNivelBeneficio(nivelBeneficio);
        this.setDataValidade(dataValidade);
    }

    public void setNivelBeneficio(String nivelBeneficio) {
        //Chamar o método que verifica qual é o nível do benefício
        this.nivelBeneficio = nivelBeneficio;
    }

    public boolean setDataValidade(String dataValidade) {
        if (!dataValidade.isBlank()) {
            this.dataValidade = dataValidade;
            return true;
        } else
            return false;
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
