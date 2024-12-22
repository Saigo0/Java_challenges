package Sistema;

public class Main {

    public static void main(String[]args) {
        Biblioteca biblioteca = Biblioteca.getInstancia("Biblioteca do Jonathan", "Rua Alameda", "11:00 - 19:00", 1000, "Pública");

        UsuarioEspecial userEspecial = new UsuarioEspecial("Jonathan", "MG-813.834.34", "14375229632", "22/12/2004", "jonathanrezendp@gmail.com", "Rua Marcílio João da Silveira", "998574479", "DevSanttos", "Básico", "Abrhdafa", "12/12/2024", "Nenhuma", 150);
        System.out.println(userEspecial.getNivelBeneficio());


        Livro livro1 = new Livro("O alienista", "Machado de Assis", "Casa blanca", 1998, 207, "Rio de Janeiro", 25, 10);
        Livro livro2 = new Livro("O pequeno príncepe", "Audos", "blanca", 2001, 195, "Rio de Janeiro", 20, 8.47);
        System.out.println("Disponibilidade: " + livro1.getDisponibilidade() + "\n");

        biblioteca.addLivros(livro1);
        biblioteca.addLivros(livro2);
        System.out.println("Livros presentes na biblioteca: " + biblioteca.getLivros().size() + "\n");
        GerenciaLivros.tornarIndisponivel(livro1, biblioteca);
        GerenciaLivros.tornarDisponivel(livro2, biblioteca);
        System.out.println("Quantidade de livros disponíveis: " + biblioteca.getLivrosDisponiveis().size() + "\n");
        System.out.println("Livros disponíveis: " + biblioteca.getLivrosDisponiveis() + "\n");


        Emprestimo emp1 = new Emprestimo("22/12/2024", " ");
        emp1.addLivros(livro1);
        emp1.addLivros(livro2);
        emp1.realizaEmprestimo(userEspecial, biblioteca);
        System.out.println(livro1.getDisponibilidade());
        System.out.println(livro2.getDisponibilidade());

    }
}
