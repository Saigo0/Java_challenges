package Sistema;

import java.util.ArrayList;

public class GerenciaLivro {
    public static ArrayList<Livro> livrosDisponiveis;
    public static ArrayList<Livro> livrosIndisponiveis;

    public GerenciaLivro() {
        livrosDisponiveis = new ArrayList<Livro>();
        livrosIndisponiveis = new ArrayList<Livro>();
    }

    public static void tornarDisponivel(Livro livro) {
        livrosIndisponiveis.remove(livro);
        livrosDisponiveis.add(livro);
    }
    public static void tornarIndisponivel(Livro livro) {
        livrosDisponiveis.remove(livro);
        livrosIndisponiveis.add(livro);
    }

    public ArrayList<Livro> getLivrosDisponiveis() {
        return livrosDisponiveis;
    }

    public ArrayList<Livro> getLivrosIndisponiveis() {
        return livrosIndisponiveis;
    }
}
