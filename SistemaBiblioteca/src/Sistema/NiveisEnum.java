package Sistema;

public enum NiveisEnum {

    DIAMANTE(12) {

    },
    ELITE(9),
    PRIMIUM(7),
    PLUS(5),
    BASICO(3);

    private int limiteLivros;

    NiveisEnum(int limiteLivros) {
        this.limiteLivros = limiteLivros;
    }



    public int getLimiteLivros() {
        return this.limiteLivros;
    }
}
