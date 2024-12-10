package Sistema;

public class Fornecedor {
    private static int cod = 1;
    private int id;
    private String cnpj;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String categoria;
    private int prazoEntrega;
    private String reputacao;
    private String observacoes;
    private boolean status;

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
        this.setStatus(true);
    }

    private void setId() {
        this.id = Fornecedor.cod++;
    }

    public int getId() {
        return this.id;
    }

    public boolean setCnpj(String cnpj) {
        if(!cnpj.isBlank()){
            this.cnpj = cnpj;
            return true;
        } else
            return false;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    private boolean setNome(String nome) {
        if(!nome.isBlank()){
            this.nome = nome;
            return true;
        } else
            return false;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean setEmail(String email) {
        if(!email.isBlank()){
            this.email = email;
            return true;
        } else
            return false;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean setTelefone(String telefone) {
        if(!telefone.isBlank()){
            this.telefone = telefone;
            return true;
        } else
            return false;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public boolean setEndereco(String endereco) {
        if(!endereco.isBlank()){
            this.endereco = endereco;
            return true;
        } else
            return false;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public boolean setCategoria(String categoria) {
        if(!categoria.isBlank()){
            this.categoria = categoria;
            return true;
        } else
            return false;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public boolean setPrazoEntrega(int prazoEntrega) {
        if(prazoEntrega>0){
            this.prazoEntrega = prazoEntrega;
            return true;
        } else
            return false;
    }

    public int getPrazoEntrega() {
        return this.prazoEntrega;
    }

    public boolean setReputacao(String reputacao) {
        if(!reputacao.isBlank()){
            this.reputacao = reputacao;
            return true;
        } else
            return false;
    }

    public String getReputacao() {
        return this.reputacao;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getObservacoes() {
        return this.observacoes;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public String toString() {
        return  "CNPJ: " + this.getCnpj() + "\n" +
                "Nome: " + this.getNome() + "\n" +
                "Telefone: " + this.getTelefone() + "\n" +
                "Email: " + this.getEmail() + "\n" +
                "Endereço: " + this.getEndereco() + "\n" +
                "Categoria: " + this.getCategoria() + "\n" +
                "Prazo de entrega: " + this.getPrazoEntrega() + "\n" +
                "Reputação: " + this.getReputacao() + "\n" +
                "Observacoes: " + this.getObservacoes() + "\n" +
                "Status: " + this.getStatus() + "\n";
    }

}
