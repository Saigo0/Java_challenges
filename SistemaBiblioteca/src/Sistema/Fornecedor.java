package Sistema;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {
    private static int cod = 1;
    private int id;
    private String cnpj;
    private String nomeEmpresa;
    private String telefone;
    private String email;
    private String endereco;
    private String categoria;
    private int prazoEntrega;
    private String reputacao;
    private String observacoes;
    private boolean statusProduto;
    private List<Livro> livrosCatalogo;
    private List<Equipamento> equipamentosCatalogo;

    public Fornecedor(String cnpj, String nome, String email, String telefone, String endereco, String categoria, int prazoEntrega, String reputacao, String observacoes) {
        this.setId();
        this.setCnpj(cnpj);
        this.setNome(nome);
        this.setEmail(email);
        this.setTelefone(telefone);
        this.setEndereco(endereco);
        this.setCategoria(categoria);
        this.setPrazoEntrega(prazoEntrega);
        this.setReputacao(reputacao);
        this.setObservacoes(observacoes);
        this.setStatusProduto(true);
        livrosCatalogo = new ArrayList<Livro>();
        equipamentosCatalogo = new ArrayList<Equipamento>();
    }

    public void addLivroCatalogo(Livro livro) {
        this.livrosCatalogo.add(livro);
    }

    public void addEquipamentoCatalogo(Equipamento equipamento) {
        this.equipamentosCatalogo.add(equipamento);
    }

    private void setId() {
        this.id = Fornecedor.cod++;
    }

    public boolean setCnpj(String cnpj) {
        if(!cnpj.isBlank() && cnpj.length() == 11){
            this.cnpj = cnpj;
            return true;
        } else
            return false;
    }

    private boolean setNome(String nome) {
        if(!nome.isBlank()){
            this.nomeEmpresa = nome;
            return true;
        } else
            return false;
    }

    public boolean setEmail(String email) {
        if(!email.isBlank()){
            this.email = email;
            return true;
        } else
            return false;
    }

    public boolean setTelefone(String telefone) {
        if(!telefone.isBlank()){
            this.telefone = telefone;
            return true;
        } else
            return false;
    }

    public boolean setEndereco(String endereco) {
        if(!endereco.isBlank()){
            this.endereco = endereco;
            return true;
        } else
            return false;
    }

    public boolean setCategoria(String categoria) {
        if(!categoria.isBlank()){
            this.categoria = categoria;
            return true;
        } else
            return false;
    }

    public boolean setPrazoEntrega(int prazoEntrega) {
        if(prazoEntrega>0){
            this.prazoEntrega = prazoEntrega;
            return true;
        } else
            return false;
    }

    public void setReputacao(String reputacao) {
        this.reputacao = reputacao;
        //Calcular com base no prazo de entrega
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setStatusProduto(boolean statusProduto) {
        this.statusProduto = statusProduto;
    }

    public int getId() {
        return this.id;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getNomeEmpresa() {
        return this.nomeEmpresa;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public int getPrazoEntrega() {
        return this.prazoEntrega;
    }

    public String getReputacao() {
        return this.reputacao;
    }

    public String getObservacoes() {
        return this.observacoes;
    }

    public boolean getStatusProduto() {
        return this.statusProduto;
    }

    public List<Livro> getLivrosCatalogo() {
        return this.livrosCatalogo;
    }

    public List<Equipamento> getEquipamentosCatalogo() {
        return this.equipamentosCatalogo;
    }

    public String toString() {
        return  "ID: " + this.getId() + "\n" +
                "CNPJ: " + this.getCnpj() + "\n" +
                "Nome: " + this.getNomeEmpresa() + "\n" +
                "Telefone: " + this.getTelefone() + "\n" +
                "Email: " + this.getEmail() + "\n" +
                "Endereço: " + this.getEndereco() + "\n" +
                "Categoria: " + this.getCategoria() + "\n" +
                "Prazo de entrega: " + this.getPrazoEntrega() + "\n" +
                "Reputação: " + this.getReputacao() + "\n" +
                "Observacoes: " + this.getObservacoes() + "\n" +
                "Status: " + this.getStatusProduto() + "\n";
    }

}
