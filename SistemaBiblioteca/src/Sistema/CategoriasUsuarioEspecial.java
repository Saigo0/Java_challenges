package Sistema;

public enum CategoriasUsuarioEspecial {
    DIAMANTE(12, 90.0),
    ELITE(9, 75.0),
    PRIMIUM(7, 50.0),
    PLUS(5, 25.0),
    BASICO(3, 15.0);

    private final int LIMITE_LIVROS;
    private final double VALOR_PAGAMENTO_ANUAL;

    CategoriasUsuarioEspecial(int limiteLivros, double valorAnualNivel) {
        this.LIMITE_LIVROS = limiteLivros;
        this.VALOR_PAGAMENTO_ANUAL = valorAnualNivel;
    }

    public int getLIMITE_LIVROS() {
        return this.LIMITE_LIVROS;
    }

    public double getVALOR_PAGAMENTO_ANUAL() {
        return VALOR_PAGAMENTO_ANUAL;
    }

    public static CategoriasUsuarioEspecial getCategoriaPorValorPago(double valorPago) {
        for (CategoriasUsuarioEspecial categoria : values()) {
            if (categoria.getVALOR_PAGAMENTO_ANUAL() == valorPago) {
                return categoria;
            }
        }
        return null;
    }
}
