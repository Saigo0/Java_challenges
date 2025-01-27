package Sistema;

import java.util.ArrayList;

public class Main {

    public static void main(String[]args) {
        Biblioteca biblioteca = Biblioteca.getInstancia("Biblioteca do Jonathan", "Rua Alameda", "11:00 - 19:00", 1000, "Pública");
        GerenciadorDeEmprestimos gerenciadorDeEmprestimos = new GerenciadorDeEmprestimos();
        UsuarioEspecial userEspecial = new UsuarioEspecial("Jonathan", "MG-813.834.34", "14375229632", "22/12/2004", "jonathanrezendp@gmail.com", "Rua Marcílio João da Silveira", "998574479", "DevSanttos", "Básico", "Abrhdafa", "12/12/2024", "Nenhuma", 15);
        Usuario usuario = new Usuario("Jonathan Santos", "MG-813.834.34", "14375229632", "22/12/2004", "jonathanrezendp@gmail.com", "Rua Marcílio João da Silveira", "998574479", "Dev", "Avançado", "jalfj", "114141");

        Livro livro1 = new Livro(1235,"O alienista", "Machado de Assis", 6,"Casa blanca", 1998, 207, "Rio de Janeiro", 25, 10);
        System.out.println("Disponibilidade: " + livro1.getDisponibilidade() + "\n");

        Livro livro2 = new Livro(15151, "O pequeno príncepe", "Audos", 1, "blanca", 2001, 195, "Rio de Janeiro", 20, 8.47);
        System.out.println("Disponibilidade: " + livro2.getDisponibilidade() + "\n");

        biblioteca.addLivros(livro1);
        biblioteca.addLivros(livro2);

        System.out.println("Livros presentes na biblioteca: " + biblioteca.getLivros().size() + "\n");
        GerenciaLivros.tornarDisponivel(livro1, biblioteca);
        GerenciaLivros.tornarDisponivel(livro2, biblioteca);
        System.out.println("Quantidade de livros disponíveis: " + biblioteca.getLivrosDisponiveis().size() + "\n");

        System.out.println("----------");
        Emprestimo emp1 = new Emprestimo("teste", "teste");
        Emprestimo emp2 = new Emprestimo("testando", "teste");
        gerenciadorDeEmprestimos.realizaEmprestimo(emp1, usuario);
        System.out.println(gerenciadorDeEmprestimos.getEmprestimos());
        gerenciadorDeEmprestimos.devolveEmprestimo(emp1);
        gerenciadorDeEmprestimos.realizaEmprestimo(emp2, usuario);
        System.out.println(gerenciadorDeEmprestimos.getEmprestimos());
        System.out.println("----------");

        emp1.addLivros(livro1);
        emp1.addLivros(livro2);
    }
}
