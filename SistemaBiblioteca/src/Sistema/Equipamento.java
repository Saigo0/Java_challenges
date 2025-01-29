package Sistema;

public class Equipamento extends Produto {
    private int numSerie;
    private String nome;
    private String dataAquisicao;
    private String categoria;
    private String marca;
    private String estado;
    private boolean status;
    private double precoCompra;

    public Equipamento(int numSerie, String nome, String dataAquisicao, String categoria, String marca, String estado, boolean status, double precoCompra) {
        this.setNumSerie(numSerie);
        this.setNome(nome);
        this.setDataAquisicao(dataAquisicao);
        this.setCategoria(categoria);
        this.setMarca(marca);
        this.setEstado(estado);
        this.setStatus(status);
        this.setPrecoCompra(precoCompra);
    }

    public boolean setNumSerie(int numSerie) {
        if (numSerie > 0) {
            this.numSerie = numSerie;
            return true;
        } else
            return false;
    }

    public int getNumSerie() {
        return this.numSerie;
    }

    public boolean setNome(String nome) {
        if (!nome.isBlank()) {
            this.nome = nome;
            return true;
        } else
            return false;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean setDataAquisicao(String dataAquisicao) {
        if (!dataAquisicao.isBlank()) {
            this.dataAquisicao = dataAquisicao;
            return true;
        } else
            return false;
    }

    public String getDataAquisicao() {
        return this.dataAquisicao;
    }

    public boolean setCategoria(String categoria) {
        if (!categoria.isBlank()) {
            this.categoria = categoria;
            return true;
        } else
            return false;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public boolean setMarca(String marca) {
        if (!marca.isBlank()) {
            this.marca = marca;
            return true;
        } else
            return false;
    }

    public String getMarca() {
        return this.marca;
    }

    public boolean setEstado(String estado) {
        if (!estado.isBlank()) {
            this.estado = estado;
            return true;
        } else
            return false;
    }

    public String getEstado() {
        return this.estado;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public boolean setPrecoCompra(double precoCompra) {
        if (precoCompra > 0) {
            this.precoCompra = precoCompra;
            return true;
        } return false;
    }

    public String toString() {
        return "Número de série: " + this.getNumSerie() + "\n" +
                "Nome: " + this.getNome() + "\n" +
                "Data de aquisição: " + this.getDataAquisicao() + "\n" +
                "Categoria: " + this.getCategoria() + "\n" +
                "Marca: " + this.getMarca() + "\n" +
                "Estado: " + this.getEstado() + "\n" +
                "Status: " + this.getStatus() + "\n" +
                "Preço de compra: " + this.getPrecoCompra() + "\n";
    }
}
