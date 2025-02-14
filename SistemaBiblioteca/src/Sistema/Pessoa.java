package Sistema;

import java.util.ArrayList;

public abstract class Pessoa {
    private String nome = "";
    private String RG = "";
    private String CPF = "";
    private String dataNascimento = "";
    private String email = "";
    private String endereco = "";
    private String telefone = "";
    private final int LIMITE_LIVROS = 1;

    public Pessoa(String nome, String RG, String CPF, String dataNascimento, String email, String endereco, String telefone) {
        this.setNome(nome);
        this.setRG(RG);
        this.setCPF(CPF);
        this.setDataNascimento(dataNascimento);
    }

    public boolean setNome(String nome) {
        if (!nome.isBlank()) {
            this.nome = nome;
            return true;
        } else return false;
    }

    public boolean setRG(String RG) {
        if (!RG.isBlank()) {
            this.RG = RG;
            return true;
        } else return false;
    }

    public boolean setCPF(String CPF) {
        if (!CPF.isBlank()) {
            this.CPF = CPF;
            return true;
        } else return false;
    }

    public boolean setDataNascimento(String dataNascimento) {
        if (!dataNascimento.isBlank()) {
            this.dataNascimento = dataNascimento;
            return true;
        } else
            return false;
    }

    public boolean setEmail(String email) {
        if (!email.isBlank()) {
            this.email = email;
            return true;
        } else return false;
    }

    public boolean setEndereco(String endereco) {
        if (!endereco.isBlank()) {
            this.endereco = endereco;
            return true;
        } else
            return false;
    }

    public boolean setTelefone(String telefone) {
        if (!telefone.isBlank()) {
            this.telefone = telefone;
            return true;
        } else
            return false;
    }

    public String getNome() {
        return this.nome;
    }

    public String getRG() {
        return this.RG;
    }

    public String getCPF() {
        return this.CPF;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public int getLimiteLivros() {
        return this.LIMITE_LIVROS;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n" +
                "RG: " + this.getRG() + "\n" +
                "CPF: " + this.getCPF() + "\n" +
                "Data de nascimento: " + this.getDataNascimento() + "\n" +
                "Email: " + this.getEmail() + "\n" +
                "Endereço: " + this.getEndereco() + "\n" +
                "Telefone: " + this.getTelefone();
    }
}
