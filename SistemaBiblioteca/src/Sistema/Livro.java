package Sistema;

public class Livro {
    public static int cod = 1;
    private int id;
    private int ISBN;
    private String titulo;
    private String autor;
    private String editora;
    private int anoEdicao;
    private int numPaginas;
    private String localEdicao;
    private boolean disponibilidade;
    private double precoVenda;
    private double precoCompra;

    public Livro(String titulo, String autor, String editora, int anoEdicao, int numPaginas, String localEdicao, double precoVenda, double precoCompra) {
        this.setId();
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setEditora(editora);
        this.setAnoEdicao(anoEdicao);
        this.setNumPaginas(numPaginas);
        this.setLocalEdicao(localEdicao);
        this.setPrecoVenda(precoVenda);
        this.setPrecoCompra(precoCompra);
        this.setDisponibilidade(true);
    }

    private void setId() {
        this.id = Livro.cod++;
    }

    private void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public boolean setTitulo(String titulo) {
        if (!titulo.isBlank()) {
            this.titulo = titulo;
            return true;
        } else
            return false;
    }

    public boolean setAutor(String autor) {
        if (!autor.isBlank()) {
            this.autor = autor;
            return true;
        } else
            return false;
    }

    public boolean setEditora(String editora) {
        if (!editora.isBlank()) {
            this.editora = editora;
            return true;
        } else
            return false;
    }

    public boolean setAnoEdicao(int anoEdicao) {
        if (anoEdicao > 0) {
            this.anoEdicao = anoEdicao;
            return true;
        } else
            return false;
    }

    public boolean setNumPaginas(int numPaginas) {
        if (numPaginas > 0) {
            this.numPaginas = numPaginas;
            return true;
        } else
            return false;
    }

    public boolean setLocalEdicao(String localEdicao) {
        if (!localEdicao.isBlank()) {
            this.localEdicao = localEdicao;
            return true;
        } else
            return false;
    }

    public boolean setPrecoVenda(double precoVenda) {
        if (precoVenda > 0) {
            this.precoVenda = precoVenda;
            return true;
        } else
            return false;
    }

    public boolean setPrecoCompra(double precoCompra) {
        if (precoCompra > 0) {
            this.precoCompra = precoCompra;
            return true;
        } else
            return false;
    }

    public int getISBN() {
        return this.ISBN;
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getEditora() {
        return this.editora;
    }

    public int getAnoEdicao() {
        return this.anoEdicao;
    }

    public String getLocalEdicao() {
        return this.localEdicao;
    }

    public int getNumPaginas() {
        return this.numPaginas;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public boolean getDisponibilidade() {
        return this.disponibilidade;
    }

    public double getPrecoVenda() {
        return this.precoVenda;
    }

    public double getPrecoCompra() {
        return this.precoCompra;
    }

    public String toString() {
        return "ID: " + this.getId() + "\n" +
                "ISBN: " + this.getISBN() + "\n" +
                "Título: " + this.getTitulo() + "\n" +
                "Autor: " + this.getAutor() + "\n" +
                "Editora: " + this.getEditora() + "\n" +
                "Ano de edição: " + this.getAnoEdicao() + "\n" +
                "Número de páginas: " + this.getNumPaginas() + "\n" +
                "Local de edição: " + this.getLocalEdicao() + "\n" +
                "Disponibilidade: " + this.getDisponibilidade() + "\n" +
                "Preço de Compra: " + this.getPrecoCompra() + "\n" +
                "Preço de Venda: " + this.getPrecoVenda();
    }
}