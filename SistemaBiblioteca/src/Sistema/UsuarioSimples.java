package Sistema;

public class UsuarioSimples extends Usuario {
    private String preferencias;

    public UsuarioSimples(String preferencias, String nome, String RG, String CPF, String dataNascimento, String email, String endereco, String telefone) {
        super(nome, RG, CPF, dataNascimento, email, endereco, telefone);
        this.setPreferencias(preferencias);
    }

    //public String verificaPreferencias() {}

    public boolean setPreferencias(String preferencias) {
        if(!preferencias.isBlank()){
            this.preferencias = preferencias;
            return true;
        } else
            return false;
    }

    public String getPreferencias() {
        return this.preferencias;
    }
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Preferencias: " + this.getPreferencias();
    }
}
