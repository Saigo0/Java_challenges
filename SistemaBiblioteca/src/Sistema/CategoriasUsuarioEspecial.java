package Sistema;

public enum CategoriasUsuarioEspecial {
    DIAMANTE(12,60, 90.0, 0.1),
    ELITE(9,45,75.0, 0.15),
    PRIMIUM(7,35, 50.0, 0.20),
    PLUS(5,25,25.0, 0.30),
    BASICO(3,15, 15.0, 0.35);

    private final int LIMITE_LIVROS;
    private final int PRAZO_EMPRESTIMO;
    private final double VALOR_PAGAMENTO_ANUAL;
    private final double PORCENTAGEM_MULTA;


    CategoriasUsuarioEspecial(int limiteLivros, int prazoEmprestimo, double valorAnualNivel, double valorMulta) {
        this.LIMITE_LIVROS = limiteLivros;
        this.PRAZO_EMPRESTIMO = prazoEmprestimo;
        this.VALOR_PAGAMENTO_ANUAL = valorAnualNivel;
        this.PORCENTAGEM_MULTA = valorMulta;
    }

    public int getLIMITE_LIVROS() {
        return this.LIMITE_LIVROS;
    }

    public int getPRAZO_EMPRESTIMO() {
        return this.PRAZO_EMPRESTIMO;
    }

    public double getVALOR_PAGAMENTO_ANUAL() {
        return this.VALOR_PAGAMENTO_ANUAL;
    }

    public double getPORCENTAGEM_MULTA() {
        return this.PORCENTAGEM_MULTA;
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
