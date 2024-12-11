package Sistema;

import java.util.ArrayList;

public abstract class Compra {
    private static int cod = 1;
    private int id;
    private ArrayList<Livro> livros;
    private ArrayList<Equipamento> equipamentos;

    public Compra() {
        this.setId();
        livros = new ArrayList<Livro>();
        equipamentos = new ArrayList<Equipamento>();
    }

    private void setId() {
        this.id = Compra.cod++;
    }

    private int getId() {
        return this.id;
    }

    public void addLivros(Livro liv) {
        this.livros.add(liv);
    }

    public void addEquipamentos(Equipamento equip) {
        this.equipamentos.add(equip);
    }

    public void removeLivros(Livro liv) {
        this.livros.remove(liv);
    }

    public void removeEquipamentos(Equipamento equip) {
        this.equipamentos.remove(equip);
    }

    public ArrayList<Livro> getLivros() {
        return this.livros;
    }

    public ArrayList<Equipamento> getEquipamentos() {
        return this.equipamentos;
    }

    public void calculaSubTotal() {
        //chamar os preços de livros
    }

    @Override
    public String toString() {
        return "";
    }
}
