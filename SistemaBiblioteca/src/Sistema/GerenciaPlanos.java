package Sistema;

public class GerenciaPlanos {

    private String tipo;
    private double desconto;

    public String getTipo(){
        return this.tipo;
    }

    private boolean setTipo(String tipo){
        if(!tipo.isBlank()){
            this.tipo = tipo;
            return true;
        } else
            return false;
    }



}
