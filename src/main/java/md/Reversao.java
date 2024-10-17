package md;

import java.util.Scanner;

public class Reversao {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe uma string para inverter: ");
        String input = scanner.nextLine();

        String invertida = inverterString(input);

        System.out.println("String invertida: " + invertida);
    }

    public static String inverterString(String str) {
        StringBuilder invertida = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            invertida.append(str.charAt(i));
        }

        return invertida.toString();
    }
}