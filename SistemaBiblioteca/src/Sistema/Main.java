package Sistema;

import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[]args) {
        Biblioteca biblioteca = Biblioteca.getInstancia("Biblioteca do Jonathan", "Rua Alameda", "11:00 - 19:00", 1000, "Pública");

        UsuarioEspecial userEspecial = new UsuarioEspecial("Jonathan", "MG-813.834.34", "14375229632", "22/12/2004", "jonathanrezendp@gmail.com", "Rua Marcílio João da Silveira", "998574479", "DevSanttos", "Básico", "Abrhdafa", "12/12/2024", "Nenhuma", "11/23/2025", 150);
        System.out.println(userEspecial.getNivelBeneficio());
    }
}
