package Sistema;

import java.util.ArrayList;

public class GerenciadorDeEmprestimos {
    private final Biblioteca biblioteca;
    private final ArrayList<Emprestimo> emprestimos;

    public GerenciadorDeEmprestimos() {
        this.biblioteca = Biblioteca.getInstancia();
        this.emprestimos = new ArrayList<Emprestimo>();
    }

    public boolean realizaEmprestimo(Emprestimo emprestimo, Usuario usuario) {
        if (usuario instanceof UsuarioEspecial usuarioEspecial) {
            return realizaEmprestimoUsuarioEspecial(emprestimo, usuarioEspecial);
        } else {
            return realizaEmprestimoUsuarioSimples(emprestimo, usuario);
        }
    }

    private boolean realizaEmprestimoUsuarioEspecial(Emprestimo emprestimo, UsuarioEspecial usuarioEspecial) throws RuntimeException {
        CategoriasUsuarioEspecial nivelBeneficio = usuarioEspecial.getNivelBeneficio();
        if (nivelBeneficio == null || emprestimo.getLivros().isEmpty()) {
            return false;
        }

        if (emprestimo.getLivros().size() > nivelBeneficio.getLIMITE_LIVROS()) {
            //Tratar, futuramente, com as exeções
            return false;
        }
        // add a verificação de que a lista de emprestimo não pode estar em branco
        if (verificaDisponibilidadeLivros(emprestimo, biblioteca)) {
            for (Livro livro : emprestimo.getLivros()) {
                GerenciaLivros.tornarIndisponivel(livro, biblioteca);
            }
            emprestimo.setStatus(true);
            emprestimos.add(emprestimo);
            System.out.println("Empréstimo relizado com sucesso para o usuário especial de nome " + usuarioEspecial.getNome() + "!");
            return true;
        }
        //Tratar, futuramente, com as exeções
        return false;
    }

    private boolean realizaEmprestimoUsuarioSimples(Emprestimo emprestimo, Usuario usuario) {
        final int limiteLivrosUsuarioSimples = 1;
        if (emprestimo.getLivros().size() > limiteLivrosUsuarioSimples) {
            //Tratar, futuramente, com as exeções
            return false;
        }

        if (verificaDisponibilidadeLivros(emprestimo, biblioteca)) {
            for (Livro livro : emprestimo.getLivros()) {
                GerenciaLivros.tornarIndisponivel(livro, biblioteca);
            }
            emprestimo.setStatus(true);
            emprestimos.add(emprestimo);
            System.out.println("Empréstimo relizado com sucesso para o usuário simples de nome " + usuario.getNome() + "!");
            return true;
        }
        //Tratar, futuramente, com as exeções
        return false;
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

    public void devolveEmprestimo(Emprestimo emprestimo) {
        emprestimo.getLivros().forEach(livro -> GerenciaLivros.tornarDisponivel(livro, biblioteca));
        emprestimo.setStatus(false);
        emprestimo.setDataDevolucaoReal("");
        //depois verificar se o emprestimo foi devolvido na data correta e calcular uma multa em cima de tal ponto
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}

