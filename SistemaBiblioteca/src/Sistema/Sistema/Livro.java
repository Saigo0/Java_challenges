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
    private double preco;

    public Livro(String titulo, String autor, String editora, int anoEdicao, int numPaginas, String localEdicao, double preco){
        this.setId();
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setEditora(editora);
        this.setAnoEdicao(anoEdicao);
        this.setNumPaginas(numPaginas);
        this.setLocalEdicao(localEdicao);
        this.setPreco(preco);
        this.setDisponibilidade(true);
    }

    private void setId(){
        this.id = Livro.cod ++;
    }

    public int getId(){
        return this.id;
    }

    private void setISBN(int ISBN){
        this.ISBN = ISBN;
    }

    public int getISBN(){
        return this.ISBN;
    }

    public boolean setTitulo(String titulo){
        if (!titulo.isBlank()){
            this.titulo = titulo;
            return true;
        } else
            return false;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public boolean setAutor(String autor){
        if(!autor.isBlank()){
            this.autor = autor;
            return true;
        } else
            return false;
    }

    public String getAutor(){
        return this.autor;
    }

    public boolean setEditora(String editora){
        if(!editora.isBlank()){
            this.editora = editora;
            return true;
        } else
            return false;
    }

    public String getEditora(){
        return this.editora;
    }

    public boolean setAnoEdicao(int anoEdicao){
        if (anoEdicao > 0){
            this.anoEdicao = anoEdicao;
            return true;
        } else
            return false;
    }

    public int getAnoEdicao(){
        return this.anoEdicao;
    }

    public boolean setLocalEdicao(String localEdicao){
        if(!localEdicao.isBlank()){
            this.localEdicao = localEdicao;
            return true;
        } else
            return false;
    }

    public String getLocalEdicao(){
        return this.localEdicao;
    }

    public boolean setNumPaginas(int numPaginas){
        if(numPaginas > 0){
            this.numPaginas = numPaginas;
            return true;
        } else
            return false;
    }

    public int getNumPaginas(){
        return this.numPaginas;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public boolean getDisponibilidade(){
        return this.disponibilidade;
    }

    public boolean setPreco(double preco){
        if(preco > 0){
            this.preco = preco;
            return true;
        } else
            return false;
    }

    public double getPreco(){
        return this.preco;
    }

    public String toString(){
        return  "ID: " + this.getId() + "\n" +
                "Título: " + this.getTitulo() + "\n" +
                "Autor: " + this.getAutor() + "\n" +
                "Editora: " + this.getEditora() + "\n" +
                "Ano de edição: " + this.getAnoEdicao() + "\n" +
                "Número de páginas: " + this.getNumPaginas() + "\n" +
                "Local de edição: " + this.getLocalEdicao() + "\n" +
                "Disponibilidade: " + this.getDisponibilidade() + "\n" +
                "Preço: " + this.getPreco();
    }
}