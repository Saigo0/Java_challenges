package Sistema;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private static Biblioteca instanciaUnica;
    private static int cod = 1;
    private int id;
    private String nome;
    private String endereco;
    private String horarioFuncionamento;
    private int capacidade;
    private String tipo;
    private final ArrayList<Livro> livros;
    public final ArrayList<Livro> livrosDisponiveis;
    public final ArrayList<Livro> livrosIndisponiveis;
    private final ArrayList<Funcionario> funcionarios;
    private final ArrayList<Usuario> usuarios;
    private final ArrayList<Fornecedor> fornecedores;
    private final ArrayList<Equipamento> equipamentos;
    private final ArrayList<Emprestimo> emprestimos;
    private final ArrayList<Administrador> administradores;
    private static final Map<Double, String> niveis = new HashMap<>();
    private final Date now = new Date();

    static {
        niveis.put(150.0, NiveisEnum.DIAMANTE.name());
        niveis.put(100.0, NiveisEnum.ELITE.name());
        niveis.put(50.0, NiveisEnum.PRIMIUM.name() );
        niveis.put(25.0, NiveisEnum.PLUS.name());
        niveis.put(15.0, NiveisEnum.BASICO.name());
    }

    private Biblioteca(String nome, String endereco, String horarioFuncionamento, int capacidade, String tipo) {
        this.setId();
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setHorarioFuncionamento(horarioFuncionamento);
        this.setCapacidade(capacidade);
        this.setTipo(tipo);
        livros = new ArrayList<Livro>();
        livrosDisponiveis = new ArrayList<Livro>();
        livrosIndisponiveis = new ArrayList<Livro>();
        funcionarios = new ArrayList<Funcionario>();
        usuarios = new ArrayList<Usuario>();
        fornecedores = new ArrayList<Fornecedor>();
        equipamentos = new ArrayList<Equipamento>();
        emprestimos = new ArrayList<Emprestimo>();
        administradores = new ArrayList<Administrador>();
    }

    public static Biblioteca getInstancia(String nome, String endereco, String horarioFuncionamento, int capacidade, String tipo) {
        if (instanciaUnica == null) {
            instanciaUnica = new Biblioteca(nome, endereco, horarioFuncionamento, capacidade, tipo);
        }
        return instanciaUnica;
    }

    public static Biblioteca getInstancia() {
        if (instanciaUnica == null) {
            throw new IllegalStateException("A Biblioteca ainda não foi inicializada.");
        }
        return instanciaUnica;
    }

    public String verificaNivelBeneficio(double valorPago) {
        return niveis.getOrDefault(valorPago, "Valor pago não condiz com nenhum valor de assinatura existente");
    }

    private void setId() {
        this.id = Biblioteca.cod++;
    }

    public boolean setNome(String nome) {
        if (!nome.isBlank()) {
            this.nome = nome;
            return true;
        } else return false;
    }

    public boolean setEndereco(String endereco) {
        if (!endereco.isBlank()) {
            this.endereco = endereco;
            return true;
        } else return false;
    }

    public boolean setHorarioFuncionamento(String horarioFuncionamento) {
        if (!horarioFuncionamento.isBlank()) {
            this.horarioFuncionamento = horarioFuncionamento;
            return true;
        } else return false;
    }

    public boolean setCapacidade(int capacidade) {
        if (capacidade > 0) {
            this.capacidade = capacidade;
            return true;
        } else return false;
    }

    public boolean setTipo(String tipo) {
        if (!tipo.isBlank()) {
            this.tipo = tipo;
            return true;
        } else return false;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getHorarioFuncionamento() {
        return this.horarioFuncionamento;
    }

    public int getCapacidade() {
        return this.capacidade;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getId() {
        return this.id;
    }

    public void addLivros(Livro umLivro) {
        this.livros.add(umLivro);
    }

    public void addFuncionarios(Funcionario umFuncionario) {
        this.funcionarios.add(umFuncionario);
    }

    public void addUsuarios(Usuario umUsuario) {
        this.usuarios.add(umUsuario);
    }

    public void addFornecedores(Fornecedor umFornecedor) {
        this.fornecedores.add(umFornecedor);
    }

    public void addEquipamentos(Equipamento umEquipamento) {
        this.equipamentos.add(umEquipamento);
    }

    public void addEmprestimos(Emprestimo umEmprestimo) {
        this.emprestimos.add(umEmprestimo);
    }

    public void addAdministradores(Administrador umAdministrador) {
        this.administradores.add(umAdministrador);
    }

    public void removeLivros(Livro umLivro) {
        this.livros.remove(umLivro);
    }

    public void removeFuncionarios(Funcionario umFuncionario) {
        this.funcionarios.remove(umFuncionario);
    }

    public void removeUsuarios(Usuario umUsuario) {
        this.usuarios.remove(umUsuario);
    }

    public void removeFornecedores(Fornecedor umFornecedor) {
        this.fornecedores.remove(umFornecedor);
    }

    public void removeEquipamentos(Equipamento umEquipamento) {
        this.equipamentos.remove(umEquipamento);
    }

    public void removeEmprestimos(Emprestimo umEmprestimo) {
        this.emprestimos.remove(umEmprestimo);
    }

    public void removeAdministradores(Administrador umAdministrador) {
        this.administradores.remove(umAdministrador);
    }

    public ArrayList<Livro> getLivros() {
        return this.livros;
    }

    public ArrayList<Livro> getLivrosDisponiveis() {
        return livrosDisponiveis;
    }

    public ArrayList<Livro> getLivrosIndisponiveis() {
        return livrosIndisponiveis;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public ArrayList<Fornecedor> getFornecedores() {
        return this.fornecedores;
    }

    public ArrayList<Equipamento> getEquipamentos() {
        return this.equipamentos;
    }

    public ArrayList<Administrador> getAdministradores() {
        return this.administradores;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return this.emprestimos;
    }

    public String imprimeLivros() {
        String texto = "";
        for (Livro liv : livros) {
            texto += liv.toString();
        }
        return texto;
    }

    public String imprimeFuncionarios() {
        String texto = "";
        for (Funcionario funci : funcionarios) {
            texto += funci.toString();
        }
        return texto;
    }

    public String imprimeUsuarios() {
        String texto = "";
        for (Usuario user : usuarios) {
            texto += user.toString();
        }
        return texto;
    }

    public String imprimeFornecedor() {
        String texto = "";
        for (Fornecedor fornc : fornecedores) {
            texto += fornc.toString();
        }
        return texto;
    }

    public String imprimeEquipamentos() {
        String texto = "";
        for (Equipamento equip : equipamentos) {
            texto += equip.toString();
        }
        return texto;
    }

    public String imprimeEmprestimos() {
        String texto = "";
        for (Emprestimo emprest : emprestimos) {
            texto += emprest.toString();
        }
        return texto;
    }

    public String imprimeAdministradores() {
        String texto = "";
        for (Administrador admin : administradores) {
            texto += admin.toString();
        }
        return texto;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + "\n" +
                "Nome: " + this.getNome() + "\n" +
                "Endereço: " + this.getEndereco() + "\n" +
                "Horário de funcionamento: " + this.getHorarioFuncionamento() + "\n" +
                "Capacidade: " + this.getCapacidade() + "\n" +
                "Tipo: " + this.getTipo();
    }
}