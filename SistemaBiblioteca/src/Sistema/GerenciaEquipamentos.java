package Sistema;

public class GerenciaEquipamentos {
    public GerenciaEquipamentos() {
    }
    public static void tornarStatusDisponivel(Equipamento equipamento, Biblioteca biblioteca) {
        biblioteca.addEquipamentos(equipamento);
        equipamento.setStatus(true);
    }

    public static void tornarStatusIndisponivel(Equipamento equipamento, Biblioteca biblioteca) {
        biblioteca.removeEquipamentos(equipamento);
        equipamento.setStatus(false);
    }
}
