package Sistema;

import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[]args){

        Calendario rel1 = new Calendario();

        rel1.setDia(0);
        rel1.addDia(s.nextInt());

        System.out.println(rel1.getDia());

        UsuarioSimples user1 = new UsuarioSimples("sdadas", "sdds", "sdsdd", "sdsdd",
                "saddasdsa", "dassdadas", "asdasdasd", "sdsadsa", "sadasds", "asdasdas");

        System.out.println(user1.toString());
    }
}
