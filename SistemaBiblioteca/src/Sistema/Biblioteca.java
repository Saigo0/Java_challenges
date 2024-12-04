package Sistema;

import java.util.ArrayList;

public class Biblioteca {
    private String nome;
    private String endereco;
    private String CNPJ;
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Equipamento> equipamentos;
    private ArrayList<Fornecedor> fornecedores;

    public Biblioteca(String nome, String endereco, String CNPJ) {
        this.nome = nome;
        this.endereco = endereco;
        this.CNPJ = CNPJ;
        livros = new ArrayList<Livro>();
        usuarios = new ArrayList<Usuario>();
        funcionarios = new ArrayList<Funcionario>();
        equipamentos = new ArrayList<Equipamento>();
        fornecedores = new ArrayList<Fornecedor>();
    }

    public boolean setNome(String nome) {
        if (!nome.equals(" ")) {
            this.nome = nome;
            return true;
        } else return false;
    }
    public boolean setEndereco(String endereco) {
        if (!endereco.equals(" ")) {
            this.endereco = endereco;
            return true;
        } else return false;
    }
    public boolean setCNPJ(String CNPJ) {
        if (CNPJ.length() == 8) {
            this.CNPJ = CNPJ;
            return true;
        } else return false;
    }
    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getCNPJ() {
        return this.CNPJ;
    }


    public void addLivros(Livro liv) {
        this.livros.add(liv);
    }
    public void addUsuarios(Usuario user) {
        this.usuarios.add(user);
    }
    public void addFuncionarios(Funcionario func) {
        this.funcionarios.add(func);
    }
    public void addEquipamentos(Equipamento equip) {
        this.equipamentos.add(equip);
    }
    public void addFornecedores(Fornecedor fornece) {
        this.fornecedores.add(fornece);
    }

    public ArrayList<Livro> getLivros() {
        return this.livros;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public ArrayList<Fornecedor> getFornecedores() {
        return fornecedores;
    }
}

