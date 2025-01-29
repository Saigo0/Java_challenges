package Sistema;

public class GerenciaEquipamentos {
    public GerenciaEquipamentos() {
    }
    public static void tornarStatusDisponivel(Equipamento equipamento, Biblioteca biblioteca) {
        biblioteca.removeEquipamentoInativo(equipamento);
        biblioteca.addEquipamentoAtivo(equipamento);
        equipamento.setStatus(true);
    }

    public static void tornarStatusIndisponivel(Equipamento equipamento, Biblioteca biblioteca) {
        biblioteca.removeEquipamentoAtivo(equipamento);
        biblioteca.addEquipamentoInativo(equipamento);
        equipamento.setStatus(false);
    }
}
