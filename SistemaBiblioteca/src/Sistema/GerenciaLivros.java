package Sistema;

public class GerenciaLivros {

    private GerenciaLivros() {}

    public static void tornarDisponivel(Livro livro, Biblioteca biblioteca) {
        biblioteca.livrosIndisponiveis.remove(livro);
        biblioteca.livrosDisponiveis.add(livro);
        livro.setDisponibilidade(true);
    }
    public static void tornarIndisponivel(Livro livro, Biblioteca biblioteca) {
        biblioteca.livrosDisponiveis.remove(livro);
        biblioteca.livrosIndisponiveis.add(livro);
        livro.setDisponibilidade(false);
    }
}
