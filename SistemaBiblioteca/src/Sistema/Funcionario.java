package Sistema;

public class Funcionario extends Pessoa {
    private static int cod = 1;
    private int id;
    private double salario;
    private String nivelEscolaridade;
    private String dataAdmissao;
    private String turno;

    public Funcionario(String nome, String RG, String CPF, String dataNascimento, String email, String endereco, String telefone, double salario, String nivelEscolaridade, String dataAdmissao, String turno){
        super(nome, RG, CPF, dataNascimento, email, endereco, telefone);
        this.setId();
        this.setSalario(salario);
        this.setNivelEscolaridade(nivelEscolaridade);
        this.setDataAdmissao(dataAdmissao);
        this.setTurno(turno);
    }
    
    public void setId(){
        this.id = Funcionario.cod++;
    }

    public int getId(){
        return this.id;
    }

    public boolean setSalario(double salario){
        if(salario > 0){
            this.salario = salario;
            return true;
        } else
            return false;
    }

    public double getSalario(){
        return this.salario;
    }

    public boolean setNivelEscolaridade(String nivelEscolaridade){
        if(!nivelEscolaridade.isBlank()){
            this.nivelEscolaridade = nivelEscolaridade;
            return true;
        } else
            return false;
    }

    public String getNivelEscolaridade(){
        return this.nivelEscolaridade;
    }

    public boolean setDataAdmissao(String dataAdmissao){
        if(!dataAdmissao.isBlank()){
            this.dataAdmissao = dataAdmissao;
            return true;
        } else
            return false;
    }

    public String getDataAdmissao(){
        return this.dataAdmissao;
    }

    public boolean setTurno(String turno){
        if(!turno.isBlank()){
            this.turno = turno;
            return true;
        } else
            return false;
    }

    public String getTurno(){
        return this.turno;
    }

    public String toString(){
        return  super.toString() + "\nID: " + this.getId() + "\n" +
                "Salario: " + this.getSalario() + "\n" +
                "Nível de escolaridade: " + this.getNivelEscolaridade() + "\n" +
                "Data de admissão: " + this.getDataAdmissao() + "\n" +
                "Turno: " + this.getTurno() + "\n";
    }
}
