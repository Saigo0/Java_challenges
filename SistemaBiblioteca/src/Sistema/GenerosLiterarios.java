package Sistema;

public enum GenerosLiterarios {
    RELIGIOSO(1),
    CONTO(2),
    ROMANCE(3),
    DIDATICO(4),
    INFANTIL(5),
    GIBI(6),
    POESIA(7),
    BIOGRAFIA_AUTOBIOGRAFIA(8);

    private final int VALOR_ASSOCIADO;

    GenerosLiterarios(int valorAssociado) {
        this.VALOR_ASSOCIADO = valorAssociado;
    }

    public int getVALOR_ASSOCIADO() {
        return VALOR_ASSOCIADO;
    }
}
