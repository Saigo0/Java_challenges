package Sistema;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Emprestimo {
    private static AtomicInteger codGenerator = new AtomicInteger(1);
    private int id;
    private final ArrayList<Livro> livros;
    private String dataEmprestimos;
    private String dataDevolucao;
    private boolean status;
    private String descricao;
    private String dataDevolucaoReal;

    public Emprestimo(String dataEmprestimos, String descricao) {
        this.id = codGenerator.getAndIncrement();
        livros = new ArrayList<Livro>();
        this.setDataEmprestimos(dataEmprestimos);
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

    public boolean setDataEmprestimos(String dataEmprestimos) {
        if (!dataEmprestimos.isBlank()) {
            this.dataEmprestimos = dataEmprestimos;
            return true;
        } else return false;
    }

    public boolean setDataDevolucao(String dataDevolucao) {
        if (!dataDevolucao.isBlank()) {
            this.dataDevolucao = dataDevolucao;
            return true;
        } else return false;
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

    public boolean setDataDevolucaoReal(String dataDevolucaoReal) {
        if (!dataDevolucaoReal.isBlank()) {
            this.dataDevolucaoReal = dataDevolucaoReal;
            return true;
        } else return false;
    }

    public int getId() {
        return this.id;
    }

    public String getDataDevolucao() {
        return this.dataDevolucao;
    }

    public boolean getStatus() {
        return this.status;
    }

    public String getDataEmprestimos() {
        return this.dataEmprestimos;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getDataDevolucaoReal() {
        return this.dataDevolucaoReal;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Data do Empréstimo: " + dataEmprestimos + "\n" +
                "Descrição: " + this.descricao + "\n" +
                "Status: " + this.status + "\n" +
                "Data de Devolução Real: " + this.dataDevolucaoReal + "\n";
    }
}


