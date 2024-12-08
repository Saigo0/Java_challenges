package Sistema;

public abstract class Usuario extends Pessoa {
    public static int cod = 1;
    private int id;
    private String senha = "";
    private String dataCadastro = "";
    private String status = "";

    public Usuario(String nome, String RG, String CPF, String dataNascimento, String email, String endereco, String telefone){
        super(nome, RG, CPF, dataNascimento, email, endereco,telefone);
        this.setId(id);
        this.setSenha(senha);
        this.setDataCadastro(dataCadastro);
        this.setStatus(status);
    }


    private void setId(int id){
        this.id = Usuario.cod++;
    }

    public int getId(){
        return this.id;
    }

    public boolean setSenha(String senha){
        if(!senha.isBlank()){
            this.senha = senha;
            return true;
        } else
            return false;
    }

    public String getSenha(){
        return this.senha;
    }

    public boolean setDataCadastro(String dataCadastro){
        if(!dataCadastro.isBlank()){
            this.dataCadastro = dataCadastro;
            return true;
        } else
            return false;
    }

    public String getDataCadastro(){
        return this.dataCadastro;
    }
    public boolean setStatus(String status){
        if (!status.isBlank()){
            this.status = status;
            return true;
        } else
            return false;
    }

    public String getStatus(){
        return this.status;
    }

    public String toString(){
        return super.toString() + "\n" +
                "ID: " + this.getId() + "\n" +
                "Senha: " + this.getSenha() + "\n" +
                "Data de cadastro: " + this.getDataCadastro() + "\n" +
                "Status: " + this.getStatus();
    }
}