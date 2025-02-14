package Sistema;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class GerenciadorDeEmprestimos {
    private final Biblioteca biblioteca;
    private final ArrayList<Emprestimo> historicoEmprestimosRealizados;
    private final ArrayList<Emprestimo> historicoEmprestimosDevolvidos;

    public GerenciadorDeEmprestimos() {
        this.biblioteca = Biblioteca.getInstancia();
        this.historicoEmprestimosRealizados = new ArrayList<Emprestimo>();
        this.historicoEmprestimosDevolvidos = new ArrayList<Emprestimo>();
    }

    public boolean realizaEmprestimo(Emprestimo emprestimo, Pessoa pessoa) {
        if (pessoa instanceof UsuarioEspecial usuarioEspecial) {
            return realizaEmprestimoUsuarioEspecial(emprestimo, usuarioEspecial);
        } else {
            return realizaEmprestimoUsuarioSimples(emprestimo, pessoa);
        }
    }

    private boolean realizaEmprestimoUsuarioEspecial(Emprestimo emprestimo, UsuarioEspecial usuarioEspecial) {
        CategoriasUsuarioEspecial nivelBeneficio = usuarioEspecial.getNivelBeneficio();
        if (nivelBeneficio == null || emprestimo.getLivros().isEmpty()) {
            return false;
        }

        if (emprestimo.getLivros().size() > nivelBeneficio.getLIMITE_LIVROS()) {
            System.out.println("Emprestimo negado! O limite de livros foi atingido!");
            return false;
        }

        if (verificaDisponibilidadeLivros(emprestimo, biblioteca)) {
            for (Livro livro : emprestimo.getLivros()) {
                GerenciaLivros.tornarIndisponivel(livro, biblioteca);
            }
            emprestimo.setDataDevolucao(String.valueOf(calculaDataDevolucao(usuarioEspecial, emprestimo)));
            emprestimo.setStatus(true);
            historicoEmprestimosRealizados.add(emprestimo);
            System.out.println("Empréstimo relizado com sucesso para o usuário especial de nome " + usuarioEspecial.getNome() + "!");
            System.out.println("A data de devolução para o emprestimo em questão é: " + emprestimo.getDataDevolucao());
            return true;
        }
        return false;
    }

    private boolean realizaEmprestimoUsuarioSimples(Emprestimo emprestimo, Pessoa pessoa) {
        if (emprestimo.getLivros().isEmpty()) {
            return false;
        }

        if (emprestimo.getLivros().size() > pessoa.getLimiteLivros()) {
            System.out.println("Emprestimo negado! O limite de livros foi atingido!");
            return false;
        }

        if (verificaDisponibilidadeLivros(emprestimo, biblioteca)) {
            for (Livro livro : emprestimo.getLivros()) {
                GerenciaLivros.tornarIndisponivel(livro, biblioteca);
            }
            emprestimo.setDataDevolucao(String.valueOf(calculaDataDevolucao(pessoa, emprestimo)));
            emprestimo.setStatus(true);
            historicoEmprestimosRealizados.add(emprestimo);
            System.out.println("Empréstimo relizado com sucesso para o usuário simples de nome " + pessoa.getNome() + "!");
            System.out.println("A data de devolução para o emprestimo em questão é: " + emprestimo.getDataDevolucao());
            return true;
        }
        return false;
    }

    public boolean devolveEmprestimo(Emprestimo emprestimo, Pessoa pessoa) {
        if (pessoa instanceof UsuarioEspecial usuarioEspecial) {
            //verificar a data de devolução, calcular multa, se possível, tornar os livros disponíveis, mudar o status do emprestimo para false, setar a dataDevolvida
            if (!emprestimo.getStatus()) {
                System.out.println("Erro ao realizar a devolução, posto que o empréstimo se encontra indisponível. (Status false)");
                return false;
            }

            if (emprestimo.getLivros().isEmpty()) {
                System.out.println("Erro ao realizar a devolução, posto que o emprestimo em questão está vazio");
                return false;
            }

            for (Livro livro : emprestimo.getLivros()) {
                GerenciaLivros.tornarDisponivel(livro, biblioteca);
            }

            emprestimo.setDataDevolvida(String.valueOf(LocalDate.now()));

            if (calculaMultaEmprestimo(emprestimo, usuarioEspecial) > 0) {
//                chamar o método de calcular multa
//            if (caso tenha multas, informar ao usuário com um system)
            }

            emprestimo.setStatus(false);
            historicoEmprestimosDevolvidos.add(emprestimo);
            System.out.println("Emprestimo devolvido com sucesso!");
            return true;
        } else {
//            pessoas que não são os userEspeciais
            if (!emprestimo.getStatus()) {
                System.out.println("Erro ao realizar a devolução, posto que o empréstimo se encontra indisponível. (Status false)");
                return false;
            }

            if (emprestimo.getLivros().isEmpty()) {
                System.out.println("Erro ao realizar a devolução, posto que o emprestimo em questão está vazio");
                return false;
            }

            for (Livro livro : emprestimo.getLivros()) {
                GerenciaLivros.tornarDisponivel(livro, biblioteca);
            }

            emprestimo.setDataDevolvida(String.valueOf(LocalDate.now()));

            if (calculaMultaEmprestimo(emprestimo, pessoa) > 0) {
//            if (caso tenha multas, informar ao usuário com um system)
                //chamar o método de calcular multa
            }

            emprestimo.setStatus(false);
            historicoEmprestimosDevolvidos.add(emprestimo);
            System.out.println("Emprestimo devolvido com sucesso!");
            return true;
        }
    }

    private boolean verificaDisponibilidadeLivros(Emprestimo emprestimo, Biblioteca biblioteca) {
        ArrayList<Livro> livrosEmprestimo = emprestimo.getLivros();

        for (Livro livro : livrosEmprestimo) {
            if (!biblioteca.getLivros().contains(livro)) {
                //Tratar, futuramente, com as exeções
                return false;
            }
        }
        return true;
    }

    private LocalDate calculaDataDevolucao(Pessoa pessoa, Emprestimo emprestimo) {
        try {
            LocalDate dataDevolucao = emprestimo.getDataEmprestimo();
            if (pessoa instanceof UsuarioEspecial usuarioEspecial) {
                return dataDevolucao.plusDays(usuarioEspecial.getNivelBeneficio().getPRAZO_EMPRESTIMO());
            } else {
                return dataDevolucao.plusDays(10);
            }
        } catch (DateTimeParseException e) {
            System.out.println("Erro ao realizar o parse da data informada!" + e.getMessage());
            return null;
        }
    }

    private double calculaMultaEmprestimo(Emprestimo emprestimo, Pessoa pessoa) {
        if (emprestimo.getDataDevolucao().isBefore(emprestimo.getDataDevolvida())) {

        } return 0;
    }

    public ArrayList<Emprestimo> getHistoricoEmprestimosRealizados() {
        return this.historicoEmprestimosRealizados;
    }

    public ArrayList<Emprestimo> getHistoricoEmprestimosDevolvidos() {
        return this.historicoEmprestimosDevolvidos;
    }
}

