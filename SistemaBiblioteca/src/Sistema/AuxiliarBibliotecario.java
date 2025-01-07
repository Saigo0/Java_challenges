package Sistema;

public class AuxiliarBibliotecario extends Funcionario {
    private String areaAtuacao;
    private Bibliotecario supervisor;

    public AuxiliarBibliotecario(String nome, String RG, String CPF, String dataNascimento, String email, String endereco, String telefone, double salario, String nivelEscolaridade, String dataAdmissao, String turno, String areaAtuacao, Bibliotecario supervisor) {
        super(nome, RG, CPF, dataNascimento, email, endereco, telefone, salario, nivelEscolaridade, dataAdmissao, turno);
        this.setAreaAtuacao(areaAtuacao);
        this.setSupervisor(supervisor);
    }

    public boolean setAreaAtuacao(String areaAtuacao) {
        if (!areaAtuacao.isBlank()) {
            this.areaAtuacao = areaAtuacao;
            return true;
        } else
            return false;
    }

    public String getAreaAtuacao() {
        return this.areaAtuacao;
    }

    public boolean setSupervisor(Bibliotecario supervisor) {
        if (supervisor != null) {
            this.supervisor = supervisor;
            return true;
        } else
            return false;
    }

    public Bibliotecario getSupervisor() {
        return this.supervisor;
    }

    public String toString() {
        return super.toString() + "\n" +
                "Área de atuação: " + this.getAreaAtuacao() + "\n" +
                "Supervisor: " + this.getSupervisor() + "\n";
    }
}
