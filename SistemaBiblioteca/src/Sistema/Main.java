package Sistema;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = Biblioteca.getInstancia("Biblioteca do Jonathan", "Rua Alameda", "11:00 - 19:00", 1000, "Pública");
        UsuarioEspecial userEspecial = new UsuarioEspecial("Jonathan", "MG-813.834.34", "14375229632", "22/12/2004", "jonathanrezendp@gmail.com", "Rua Marcílio João da Silveira", "998574479", "DevSanttos", "Básico", "Abrhdafa", "12/12/2024", "Nenhuma", 15);
//        Usuario usuario = new Usuario("Jonathan Santos", "MG-813.834.34", "14375229632", "22/12/2004", "jonathanrezendp@gmail.com", "Rua Marcílio João da Silveira", "998574479", "Dev", "Avançado", "jalfj", "114141");
        GerenciadorDeCompra gerenciadorDeCompra = new GerenciadorDeCompra();
        Compra compra = new Compra();
        Emprestimo emprestimo = new Emprestimo("14/12/2024", "Emprestimo realizado com sucesso e sem falhas do sistema");
        GerenciadorDeEmprestimos gerenciadorDeEmprestimos = new GerenciadorDeEmprestimos();

        Fornecedor fornecedor = new Fornecedor("14", "ForneceEficiente", "fa", "f", "f", "fa", 90, "Boa", "hfa");
        Fornecedor fornecedor2 = new Fornecedor("14794173", "ForneceSempre", "fa", "f", "f", "fa", 30, "Ótima", "Nenhuma");

        Livro livro1 = new Livro(1235, "O alienista", "Machado de Assis", 6, "Casa blanca", 1998, 207, "Rio de Janeiro", 25, 10);
        System.out.println("Disponibilidade livro 1: " + livro1.getDisponibilidade() + "\n");

        Livro livro2 = new Livro(15151, "O pequeno príncepe", "Audos", 1, "blanca", 2001, 195, "Rio de Janeiro", 20, 20);
        System.out.println("Disponibilidade livro 2: " + livro2.getDisponibilidade() + "\n");

        Livro livro3 = new Livro(14141, "O Ladrão de casaca", "Audos", 1, "blanca", 2001, 195, "Rio de Janeiro", 20, 30);
        System.out.println("Disponibilidade livro 3: " + livro3.getDisponibilidade() + "\n");




        Equipamento equipamento1 = new Equipamento(4214, "Televisão", "11/12/2015", "Eletronico", "LG", "Bom", true, 1000);
        System.out.println("Disponibilidade do equipamento 1: " + equipamento1.getStatus() + "\n");
        Equipamento equipamento2 = new Equipamento(441, "Notebook", "11/12/2015", "Eletronico", "LG", "Bom", true, 2000);
        System.out.println("Disponibilidade do equipamento 2: " + equipamento2.getStatus() + "\n");
        Equipamento equipamento3 = new Equipamento(8401, "Computador", "11/12/2015", "Eletronico", "LG", "Bom", true, 3000);
        System.out.println("Disponibilidade do equipamento 3: " + equipamento3.getStatus() + "\n");

        System.out.println("Livros da biblioteca: " + biblioteca.getLivros());
        System.out.println("Livros indisponíveis: " + biblioteca.getLivrosIndisponiveis());
        System.out.println("Livros disponíveis: " + biblioteca.getLivrosDisponiveis());


//        adicionando no catálogo do fornecedor
        fornecedor.addLivroCatalogo(livro1);
        fornecedor.addLivroCatalogo(livro2);
        fornecedor.addLivroCatalogo(livro3);
        fornecedor.addEquipamentoCatalogo(equipamento1);
        fornecedor.addEquipamentoCatalogo(equipamento2);
        fornecedor.addEquipamentoCatalogo(equipamento3);

        System.out.println("------------");
        System.out.println("Catálogo de livros do fornecedor: " + fornecedor.getLivrosCatalogo());
        System.out.println("Catálogo de equipamentos do fornecedor: " + fornecedor.getEquipamentosCatalogo());
        System.out.println("------------");

//        adicionando os livros e equipamentos no carrinho de compras
        compra.addLivros(livro1);
        compra.addLivros(livro2);
        compra.addEquipamentos(equipamento1);
        compra.addEquipamentos(equipamento2);

        System.out.println("----------");
        System.out.println("Livros da lista de compras: " + compra.getLivros());
        System.out.println("----------");
        System.out.println("Equipamentos da lista de compras " + compra.getEquipamentos());
        System.out.println("----------");

        System.out.println("Compras já realizadas pelo sistema: " + gerenciadorDeCompra.getHistoricoCompras().size());
        System.out.println("Valor da compra dos Livros: " + gerenciadorDeCompra.calculaSubTotalLivros(compra));
        System.out.println("Valor da compra dos Equipamentos: " + gerenciadorDeCompra.calculaSubTotalEquipamentos(compra));
        System.out.println("Status da compra: " + compra.getStatus() + "\n");

//        realizando a compra chamando o método compra
        gerenciadorDeCompra.realizaPedidoDeCompra(compra, fornecedor, true);

        System.out.println("Livros da biblioteca: " + biblioteca.getLivros() + '\n');
        System.out.println("Equipamentos da biblioteca: " + biblioteca.getEquipamentos() + '\n');
        System.out.println("Livros disponíveis: " + biblioteca.getLivrosDisponiveis());
        System.out.println("Status da compra: " + compra.getStatus() + '\n');

        System.out.println("Compras já realizadas pelo sistema: " + gerenciadorDeCompra.getHistoricoCompras().size());

        emprestimo.addLivros(livro1);
        emprestimo.addLivros(livro2);

        System.out.println(gerenciadorDeEmprestimos.realizaEmprestimo(emprestimo, userEspecial));
        System.out.println("Emprestimos já realizados: " + gerenciadorDeEmprestimos.getEmprestimos());
        //alteramos a disponibilidade, mas ainda temos que adicionar em na classe emprestimo uma lista de livros que já estão emprestados e modificar a lista já existente para o nome de carrinho de compra
        //devemos limpar essa lista toda as vezes que finalizarmos um emprestimo
    }
}
