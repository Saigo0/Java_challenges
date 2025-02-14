package Sistema;

public enum CategoriasUsuarioEspecial {
    DIAMANTE(12,60, 90.0),
    ELITE(9,45,75.0),
    PRIMIUM(7,35, 50.0),
    PLUS(5,25,25.0),
    BASICO(3,15, 15.0);

    private final int LIMITE_LIVROS;
    private final int PRAZO_EMPRESTIMO;
    private final double VALOR_PAGAMENTO_ANUAL;


    CategoriasUsuarioEspecial(int limiteLivros, int prazoEmprestimo, double valorAnualNivel) {
        this.LIMITE_LIVROS = limiteLivros;
        this.PRAZO_EMPRESTIMO = prazoEmprestimo;
        this.VALOR_PAGAMENTO_ANUAL = valorAnualNivel;
    }

    public int getLIMITE_LIVROS() {
        return this.LIMITE_LIVROS;
    }

    public int getPRAZO_EMPRESTIMO() {
        return this.PRAZO_EMPRESTIMO;
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
