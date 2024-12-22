package Sistema;

public class GerenciaPlanos {
    private static GerenciaPlanos Diamante;
    private static GerenciaPlanos Elite;
    private static GerenciaPlanos Premium;
    private static GerenciaPlanos Plus;
    private static GerenciaPlanos Basico;
    private String tipo;
    private double desconto;

    public static void main(String []args){
        Diamante.setTipo("Diamante");
        Elite.setTipo("Elite");
        Premium.setTipo("Premium");
        Plus.setTipo("Tipo");
        Basico.setTipo("Basico");
    }

    public GerenciaPlanos(double pagamento){
        getInstancia(pagamento);
    }

    public String getTipo(){
        return this.tipo;
    }

    public GerenciaPlanos getInstancia(double pgto){
        return switch ((int) pgto) {
            case 120 -> Diamante;
            case 100 -> Elite;
            case 80 -> Premium;
            case 60 -> Plus;
            case 40 -> Basico;
            default -> null;
        };
    }

    private boolean setTipo(String tipo){
        if(!tipo.isBlank()){
            this.tipo = tipo;
            return true;
        } else
            return false;
    }



}
