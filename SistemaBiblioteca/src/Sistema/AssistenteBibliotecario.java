package Sistema;

import java.util.ArrayList;

public class AssistenteBibliotecario extends Funcionario {
    private ArrayList <String> responsabilidades;

    public AssistenteBibliotecario(String nome, String RG, String CPF, String dataNascimento, String email, String endereco, String telefone, double salario, String nivelEscolaridade, String dataAdmissao, String turno){
        super(nome, RG, CPF, dataNascimento, email, endereco, telefone, salario, nivelEscolaridade, dataAdmissao, turno);
        this.responsabilidades = new ArrayList<String>();
    }

    public void addResponsabilidades(String umaResponsabilidade){
        this.responsabilidades.add(umaResponsabilidade);
    }

    public void removeResponsabilidades(String umaResponsabilidade){
        this.responsabilidades.remove(umaResponsabilidade);
    }

    public ArrayList<String> getResponsabilidades() {
        return responsabilidades;
    }

    public String toString(){
        return super.toString() + "\n" +
                "Responsabilidades: " + this.getResponsabilidades();
    }
}
