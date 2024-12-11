package Sistema;

import java.util.ArrayList;

public class Venda {
    private static int cod = 1;
    private int id;
    private ArrayList<Livro> livros;

    public Venda() {
        this.setId();
        this.livros = new ArrayList<Livro>();
    }

    private void setId() {
        this.id = Venda.cod++;
    }

    public int getId() {
        return this.id;
    }

    public void addLivros(Livro umLivro) {
        this.livros.add(umLivro);
    }

    public void removeLivros(Livro umLivro) {
        this.livros.remove(umLivro);
    }

    public ArrayList<Livro> getLivros() {
        return this.livros;
    }

    public String getTituloLivros() {
        String texto = "";

        for (Livro liv : livros) {
            texto += liv.getTitulo() + ", ";
        }
        return texto;
    }

    public double calculaSubTotal() {
        double subTot = 0;

        for (Livro liv : livros) {
            subTot += liv.getPrecoVenda();
        }

        return subTot;
    }

    public String toString() {
        return "ID da compra: " + this.getId() + "\n" +
                "Livros: " + this.getTituloLivros() + "\n" +
                "Subtotal: " + this.calculaSubTotal();
    }
}
