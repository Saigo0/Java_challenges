package Sistema;

public class Calendario {

    private int dia;

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getDia() {
        return dia;
    }

    public int addDia(int dias) {
        return this.dia += dias;
    }
    public int dimDia(int dias) {
        return this.dia -= dias;
    }
}
