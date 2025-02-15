package Sistema;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
//        Instânica única da biblioteca
        Biblioteca biblioteca = Biblioteca.getInstancia("Biblioteca do Jonathan", "Rua Alameda", "11:00 - 19:00", 1000, "Pública");

//        Criando algumas instâncias de gerenciamento
        GerenciadorDeEmprestimos gerenciadorDeEmprestimos = new GerenciadorDeEmprestimos();
        GerenciadorDeCompra gerenciadorDeCompra = new GerenciadorDeCompra();

//        Criando instâncias de representações
        Emprestimo emprestimoDoHelio = new Emprestimo("2024-02-14","Emprestimo realizado com sucesso e sem falhas do sistema");
        Emprestimo emprestimoDaAndreia = new Emprestimo("2025-02-14","Emprestimo realizado com sucesso e sem falhas do sistema");
        Emprestimo emprestimoDoJonathan = new Emprestimo("2025-02-14","Emprestimo realizado com sucesso e sem falhas do sistema");
        Compra compra = new Compra();
        System.out.println("Status emprestimo: " + emprestimoDoHelio.getStatus());
        System.out.println("Status emprestimo: " + emprestimoDaAndreia.getStatus());
        System.out.println("Status emprestimo: " + emprestimoDoJonathan.getStatus());
        UsuarioEspecial helio = new UsuarioEspecial("Hélio Oliveira Martins", "MG-563.834.34", "14375229632", "22/12/2004", "jonathanrezendp@gmail.com", "Rua Marcílio João da Silveira", "998574479", "DevSanttos", "Básico", "Abrhdafa", "12/12/2024", "Nenhuma", 90);
        UsuarioEspecial andrea = new UsuarioEspecial("Andrea Maria Rezende", "MG-773.834.34", "66438883877", "22/12/2004", "jonathanrezendp@gmail.com", "Rua Marcílio João da Silveira", "998574479", "DevSanttos", "Básico", "Abrhdafa", "12/12/2024", "Nenhuma", 15);
        Usuario jonathan = new Usuario("Jonathan Rezende", "MG-813.834.34", "1747884773", "22/12/2004", "jonathanrezendp@gmail.com", "Rua Marcílio João da Silveira", "998574479", "Dev", "Avançado", "jalfj", "114141");

        Fornecedor fornecedor = new Fornecedor("14", "ForneceEficiente", "fa", "f", "f", "fa", 90, "Boa", "hfa");

        Livro livro1 = new Livro(1235, "O alienista", "Machado de Assis", 6, "Casa blanca", 1998, 207, "Rio de Janeiro", 25, 10);
        System.out.println("Disponibilidade livro 1: " + livro1.getDisponibilidade() + "\n");

        Livro livro2 = new Livro(15151, "O pequeno príncepe", "Audos", 1, "blanca", 2001, 195, "Rio de Janeiro", 20, 20);
        System.out.println("Disponibilidade livro 2: " + livro2.getDisponibilidade() + "\n");

        Livro livro3 = new Livro(14141, "O Ladrão de casaca", "Audos", 1, "blanca", 2001, 195, "Rio de Janeiro", 20, 30);
        System.out.println("Disponibilidade livro 3: " + livro3.getDisponibilidade() + "\n");

        Equipamento equipamento1 = new Equipamento(4214, "Televisão", "11/12/2015", "Eletronico", "LG", "Bom", true, 1000);
        Equipamento equipamento2 = new Equipamento(441, "Notebook", "11/12/2015", "Eletronico", "LG", "Bom", true, 2000);
        Equipamento equipamento3 = new Equipamento(8401, "Computador", "11/12/2015", "Eletronico", "LG", "Bom", true, 3000);

//        adicionando os produtos no catálogo do fornecedor
        fornecedor.addLivroCatalogo(livro1);
        fornecedor.addLivroCatalogo(livro2);
        fornecedor.addLivroCatalogo(livro3);
        fornecedor.addEquipamentoCatalogo(equipamento1);
        fornecedor.addEquipamentoCatalogo(equipamento2);
        fornecedor.addEquipamentoCatalogo(equipamento3);
        System.out.println("----------" + "\n");
        System.out.println("Catálogo de livros do fornecedor: " + fornecedor.getLivrosCatalogo());
        System.out.println("Catálogo de equipamentos do fornecedor: " + fornecedor.getEquipamentosCatalogo());

//        adicionando os livros e equipamentos no carrinho de compras, uma vez que vamos realizar uma compra do fornecedor em questão
        compra.addLivros(livro1);
        compra.addLivros(livro2);
        compra.addEquipamentos(equipamento1);
        compra.addEquipamentos(equipamento2);
        System.out.println("----------" + "\n");
        System.out.println("Livros da lista de compras: " + compra.getLivros());
        System.out.println("----------");
        System.out.println("Equipamentos da lista de compras " + compra.getEquipamentos());

//        realizando a compra chamando o método compra
        gerenciadorDeCompra.realizaPedidoDeCompra(compra, fornecedor, true);
        System.out.println("----------" + "\n");
        System.out.println("Status da compra: " + compra.getStatus());
        System.out.println("Compras já realizadas pelo sistema: " + gerenciadorDeCompra.getHistoricoCompras().size());

//        Agora que temos compramos livros para a nossa biblioteca, podemos realizar emprestimos
        emprestimoDoHelio.addLivros(livro1);
        emprestimoDoHelio.addLivros(livro2);

//        Hélio solicitou a realização de um empréstimo
        gerenciadorDeEmprestimos.realizaEmprestimo(emprestimoDoHelio, helio);
        gerenciadorDeEmprestimos.devolveEmprestimo(emprestimoDoHelio, helio);
    }
}