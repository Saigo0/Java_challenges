package Sistema;

public class UsuarioEspecial extends Usuario {
    private String beneficios;
    private String dataValidade;

    public UsuarioEspecial(String nome, String RG, String CPF, String dataNascimento, String email, String endereco, String telefone) {
        super(nome, RG, CPF, dataNascimento, email, endereco, telefone);
        this.setBeneficios(beneficios);
       //this.setDataValidade(dataValidade);
    }

    public boolean setBeneficios(String beneficios) {
        if (!beneficios.isBlank()) {
            this.beneficios = beneficios;
            return true;
        }
        if (beneficios.equals("VIP")) {
            //Aplica o desconto na lista de livros que foram selecionados pelo cliente
        } else {
            if (beneficios.equals("Premium")) {
                //Aplica o desconto na lista de livros que foram selecionados pelo cliente
            } else {
                if (beneficios.equals("Plus")) {
                    //Aplica o desconto na lista de livros que foram selecionados pelo cliente
                }
            } //else retorna alguma coisa para informar o benefício informado não fornece desconto.
        } return false;
    }


    public void setDataValidade(String dataValidade) {

    }


    public String getBeneficios() {
        return this.getBeneficios();
    }

    public String getDataValidade() {
        return this.getDataValidade();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
