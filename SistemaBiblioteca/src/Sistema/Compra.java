package Sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Compra {
    private static AtomicInteger codGenerator = new AtomicInteger(1);
    private int id;
    private boolean status;
    private ArrayList<Livro> livros;
    private ArrayList<Equipamento> equipamentos;

    public Compra() {
        this.id = codGenerator.getAndIncrement();
        livros = new ArrayList<Livro>();
        equipamentos = new ArrayList<Equipamento>();
        this.setStatus(false);
    }

    public void addLivros(Livro livro) {
        this.livros.add(livro);
    }

    public void removeLivros(Livro liv) {
        this.livros.remove(liv);
    }

    public List<Livro> getLivros() {
        return this.livros;
    }

    public void addEquipamentos(Equipamento equipamento) {
        this.equipamentos.add(equipamento);
    }

    public void removeEquipamentos(Equipamento equip) {
        this.equipamentos.remove(equip);
    }

    public List<Equipamento> getEquipamentos() {
        return this.equipamentos;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n" +
                "status: " + this.status + "\n" +
                "livros: " + this.livros + "\n" +
                "equipamentos: " + this.equipamentos;
    }
}
