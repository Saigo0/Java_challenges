package Sistema;

public class Main {

    public static void main(String[]args) {
        Biblioteca biblioteca = Biblioteca.getInstancia("Biblioteca do Jonathan", "Rua Alameda", "11:00 - 19:00", 1000, "Pública");
        UsuarioEspecial userEspecial = new UsuarioEspecial("Jonathan", "MG-813.834.34", "14375229632", "22/12/2004", "jonathanrezendp@gmail.com", "Rua Marcílio João da Silveira", "998574479", "DevSanttos", "Básico", "Abrhdafa", "12/12/2024", "Nenhuma", 15);
        Usuario usuario = new Usuario("Jonathan Santos", "MG-813.834.34", "14375229632", "22/12/2004", "jonathanrezendp@gmail.com", "Rua Marcílio João da Silveira", "998574479", "Dev", "Avançado", "jalfj", "114141");

        Livro livro1 = new Livro(1235,"O alienista", "Machado de Assis", 6,"Casa blanca", 1998, 207, "Rio de Janeiro", 25, 10);
        System.out.println("Disponibilidade livro 1: " + livro1.getDisponibilidade() + "\n");

        Livro livro2 = new Livro(15151, "O pequeno príncepe", "Audos", 1, "blanca", 2001, 195, "Rio de Janeiro", 20, 20);
        System.out.println("Disponibilidade livro 2: " + livro2.getDisponibilidade() + "\n");

        Livro livro3 = new Livro(14141, "O Ladrão de casaca", "Audos", 1, "blanca", 2001, 195, "Rio de Janeiro", 20, 30);
        System.out.println("Disponibilidade livro 3: " + livro3.getDisponibilidade() + "\n");

        System.out.println("Livros da biblioteca: " + biblioteca.getLivros());
        System.out.println("Livros indisponíveis: " + biblioteca.getLivrosIndisponiveis());
        System.out.println("Livros disponíveis: " + biblioteca.getLivrosDisponiveis());

        Fornecedor fornecedor = new Fornecedor("14", "ForneceEficiente", "fa", "f", "f", "fa", 90, "Boa", "hfa");

        fornecedor.addLivroCatalogo(livro1);
        fornecedor.addLivroCatalogo(livro2);
        fornecedor.addLivroCatalogo(livro3);


        GerenciaCompra compra = new GerenciaCompra();


        compra.addLivros(livro1);
        compra.addLivros(livro2);
        compra.addLivros(livro3);
        System.out.println("Livros da lista de compras: " + compra.getLivros());

        System.out.println(compra.realizaPedidoCompra(compra, livro1, fornecedor));
        System.out.println("Livros da biblioteca: " + biblioteca.getLivros());
        System.out.println("Livros disponíveis: " + biblioteca.getLivrosDisponiveis());


    }
}
