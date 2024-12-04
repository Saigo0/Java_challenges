package Sistema;

import java.util.ArrayList;

public class Emprestimo {
    private static int contadorId = 0;
    private int idEmprestimo;
    private Usuario usuarios;
    private ArrayList<Livro> livros;

    public Emprestimo() {
        this.idEmprestimo = contadorId++;
        livros = new ArrayList<Livro>();
    }

    public int getIdEmprestimo() {
        return this.idEmprestimo;
    }

    public int getContadorId() {
        return contadorId;
    }

    public void addLivros(Livro liv) {
        this.livros.add(liv);
    }

    public ArrayList<Livro> getLivros() {
        return this.livros;
    }
    @Override
    public String toString() {
        String resultado = "Empréstimo ID: " + idEmprestimo + "\n";
        resultado += "Usuário: " + usuarios + "\n";
        resultado += "Livros Emprestados:\n";
        for (Livro livro : livros) {
            resultado += "- " + livro + "\n";
        }
        return resultado;
    }
}

