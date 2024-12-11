package Sistema;

import java.util.ArrayList;

public class Bibliotecario extends Funcionario {
    private String registroCRB;
    private ArrayList<String> especializacoes;

    public Bibliotecario(String nome, String RG, String CPF, String dataNascimento, String email, String endereco, String telefone, double salario, String nivelEscolaridade, String dataAdmissao, String turno, String registroCRB) {
        super(nome, RG, CPF, dataNascimento, email, endereco, telefone, salario, nivelEscolaridade, dataAdmissao, turno);
        this.setRegistroCRB(registroCRB);
        this.especializacoes = new ArrayList<String>();
    }

    public boolean setRegistroCRB(String registroCRB) {
        if (!registroCRB.isBlank()) {
            this.registroCRB = registroCRB;
            return true;
        } else
            return false;
    }

    public String getRegistroCRB() {
        return this.registroCRB;
    }

    public void addEspecializacoes(String umaEspecializacao) {
        this.especializacoes.add(umaEspecializacao);
    }

    public void removeEspecializacoes(String umaEspecializacao) {
        this.especializacoes.remove(umaEspecializacao);
    }

    public ArrayList<String> getEspecializacoes() {
        return this.especializacoes;
    }

    public String toString() {
        return super.toString() + "\n" +
                "Registro CRB:" + this.getRegistroCRB() + "\n" +
                "Especializações: " + this.getEspecializacoes();
    }
}
