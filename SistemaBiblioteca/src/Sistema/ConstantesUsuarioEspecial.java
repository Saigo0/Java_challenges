package Sistema;

public final class ConstantesUsuarioEspecial {
    public static final int LIMITE_LIVROS_DIAMANTE = 12;
    public static final int LIMITE_LIVROS_ELITE = 9;
    public static final int LIMITE_LIVROS_PREMIUM = 7;
    public static final int LIMITE_LIVROS_PLUS = 5;
    public static final int LIMITE_LIVROS_BASICO = 3;
    public static final double IMPOSTO_ATRASO_EMPRESTIMO = 0.5;
    private static final String TIPO_DIAMANTE = "Diamante";
    private static final String TIPO_ELITE = "Elite";
    private static final String TIPO_PREMIUM = "Premium";
    private static final String TIPO_PLUS = "Plus";
    private static final String TIPO_BASICO = "Básico";
    private ConstantesUsuarioEspecial() {}

    public enum NiveisPlano {
        DIAMANTE, ELITE, PRIMIUM, PLUS, BASICO;
    }
}
