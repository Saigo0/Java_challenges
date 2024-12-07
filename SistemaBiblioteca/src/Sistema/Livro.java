package Sistema;

public class Livro {
    public static int cod = 1;
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
        this.setISBN();
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setEditora(editora);
        this.setAnoEdicao(anoEdicao);
        this.setNumPaginas(numPaginas);
        this.setLocalEdicao(localEdicao);
        this.setPreco(preco);
    }

    private void setISBN(){
        this.ISBN = Livro.cod ++;
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

    public boolean setDisponibilidade(boolean disponibilidade) {
        if (this.disponibilidade) {
            this.disponibilidade = false;
            return true;
        } else {
            this.disponibilidade = true;
            return true;
        }
    }

    public boolean setPreco(double preco){
        if(preco > 0){
            this.preco = preco;
            return true;
        } else
            return false;
    }

    public String toString(){
        return  "ISBN: " + this.getISBN() + "\n" +


    }
}