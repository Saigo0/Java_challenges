package Sistema;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Emprestimo {
    private static AtomicInteger codGenerator = new AtomicInteger(1);
    private int id;
    private final ArrayList<Livro> livros;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate dataDevolvida;
    private boolean status;
    private String descricao;

    public Emprestimo(String dataEmprestimos, String descricao) {
        this.id = codGenerator.getAndIncrement();
        livros = new ArrayList<Livro>();
        this.setDataEmprestimo(dataEmprestimos);
        this.status = false;
        this.setDescricao(descricao);
    }

    public void addLivros(Livro livro) {
        if (livro != null && !this.livros.contains(livro)) {
            //realizar um for para verificar se os livros add estão na biblioteca e fazer o mesmo com o add de compra
            this.livros.add(livro);
        }
    }

    public void removeLivros(Livro liv) {
        this.livros.remove(liv);
    }

    public ArrayList<Livro> getLivros() {
        return this.livros;
    }

    public boolean setDataEmprestimo(String dataDeRealizacaoEmprestimo) {
        if (dataDeRealizacaoEmprestimo == null || dataDeRealizacaoEmprestimo.isBlank()) {
            return false;
        }

        try {
            this.dataEmprestimo = LocalDate.parse(dataDeRealizacaoEmprestimo);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Erro ao realizar o parse da data informada: " + e.getMessage());
            return false;
        }
    }

    public boolean setDataDevolucao(String dataDevolucao) {
        if (dataDevolucao == null || dataDevolucao.isBlank()) {
            return false;
        }

        try {
            this.dataDevolucao = LocalDate.parse(dataDevolucao);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Erro ao realizar o parse da data informada: " + e.getMessage());
            return false;
        }
    }

    public boolean setDataDevolvida(String dataDevolvida) {
        if (dataDevolvida == null || dataDevolvida.isBlank()) {
            return false;
        }

        try {
            this.dataDevolvida = LocalDate.parse(dataDevolvida);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Erro ao realizar o parse da data informada: " + e.getMessage());
            return false;
        }
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean setDescricao(String descricao) {
        if (!descricao.isBlank()) {
            this.descricao = descricao;
            return true;
        } else return false;
    }

    public int getId() {
        return this.id;
    }

    public LocalDate getDataDevolucao() {
        return this.dataDevolucao;
    }

    public boolean getStatus() {
        return this.status;
    }

    public LocalDate getDataEmprestimo() {
        return this.dataEmprestimo;
    }

    public LocalDate getDataDevolvida() {
        return this.dataDevolvida;
    }

    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\n" +
                "Data do Empréstimo: " + this.dataEmprestimo + "\n" +
                "Descrição: " + this.descricao + "\n" +
                "Status: " + this.status + "\n" +
                "Data de Devolvida pelo cliente: " + this.dataDevolvida + "\n";
    }
}


