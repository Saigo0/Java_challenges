package Sistema;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
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
        if (nivelBeneficio == null) {
            throw new IllegalArgumentException("O nível do benefício está nulo!");
        }

        if (emprestimo.getLivros().isEmpty()) {
            System.out.println("A lista de livros associada ao emprestimo está vazia!");
            return false;
        }

        if (emprestimo.getStatus()) {
            System.out.println("Erro ao realizar o emprestimo, tendo em vista que ele já está ativo!");
            return false;
        }

        if (usuarioEspecial.getMultasPendentes()) {
            System.out.println("O respectivo cliente tem multas abertas associadas à conta!");
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

        if (emprestimo.getStatus()) {
            System.out.println("Erro ao realizar o emprestimo, tendo em vista que ele já está ativo!");
            return false;
        }

        if (pessoa.getMultasPendentes()) {
            System.out.println("O respectivo cliente tem multas abertas associadas à conta!");
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
            if (!emprestimo.getStatus()) {
                System.out.println("Erro ao realizar a devolução, posto que o empréstimo se encontra indisponível ou não foi realizado. (Status false)");
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
                usuarioEspecial.setMultasPendentes(true);
                System.out.println("O atraso de " + ChronoUnit.DAYS.between(emprestimo.getDataDevolucao(), emprestimo.getDataDevolvida()) + " dias configurou uma multa que estará associada ao seu cadastro na biblioteca!");
                System.out.println("O valor da multa foi de : " + calculaMultaEmprestimo(emprestimo, usuarioEspecial));
            }
            emprestimo.setStatus(false);
            historicoEmprestimosDevolvidos.add(emprestimo);
            System.out.println("Devolução do empréstimo realizado com sucesso!");
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
                pessoa.setMultasPendentes(true);
                System.out.println("O atraso de " + ChronoUnit.DAYS.between(emprestimo.getDataDevolucao(), emprestimo.getDataDevolvida()) + " dias configurou uma multa que estará associada ao seu cadastro na biblioteca!");
                System.out.println("O valor da multa foi de : " + calculaMultaEmprestimo(emprestimo, pessoa));
            }
            emprestimo.setStatus(false);
            historicoEmprestimosDevolvidos.add(emprestimo);
            System.out.println("Devolução do empréstimo realizado com sucesso!");
            return true;
        }
    }

    private boolean verificaDisponibilidadeLivros(Emprestimo emprestimo, Biblioteca biblioteca) {
        ArrayList<Livro> livrosEmprestimo = emprestimo.getLivros();

        for (Livro livro : livrosEmprestimo) {
            if (!biblioteca.getLivros().contains(livro)) {
                System.out.println("O livro de nome: " + livro.getTitulo() + " não pertence à biblioteca!");
                return false;
            }
            if (!livro.getDisponibilidade()) {
                System.out.println("O livro de nome: " + livro.getTitulo() + " está indisponível!");
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
            long diasAtraso = ChronoUnit.DAYS.between(emprestimo.getDataDevolucao(), emprestimo.getDataDevolvida());
            if (pessoa instanceof UsuarioEspecial usuarioEspecial) {
                return (Biblioteca.getInstancia().getVALOR_MULTA_POR_DIA() * diasAtraso) * usuarioEspecial.getNivelBeneficio().getPORCENTAGEM_MULTA();
            } else {
                return Biblioteca.getInstancia().getVALOR_MULTA_POR_DIA() * diasAtraso;
            }
        }
        return 0;
    }

    public ArrayList<Emprestimo> getHistoricoEmprestimosRealizados() {
        return this.historicoEmprestimosRealizados;
    }

    public ArrayList<Emprestimo> getHistoricoEmprestimosDevolvidos() {
        return this.historicoEmprestimosDevolvidos;
    }
}

