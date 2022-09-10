package converter;

import java.util.Scanner;

public class Main {
    public static String converter(int number, int base) {
        String hex = "0123456789ABCDEF";
        StringBuilder stringBuilder = new StringBuilder();
        while (number > 0) {
            stringBuilder.append(hex.charAt(number % base));
            number = number / base;
        }
        return stringBuilder.reverse().toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number in decimal system:");
        int number = scanner.nextInt();
        System.out.print("Enter target base:");
        int base = scanner.nextInt();
        System.out.println("Conversion result: " + converter(number, base));
    }
}
