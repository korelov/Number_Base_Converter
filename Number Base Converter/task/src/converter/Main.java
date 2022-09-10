package converter;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {


    public static String fromDecimal(int number, int base) {
        String hex = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder stringBuilder = new StringBuilder();
        while (number > 0) {
            stringBuilder.append(hex.charAt(number % base));
            number = number / base;
        }
        return stringBuilder.reverse().toString();
    }

    public static String fromBinaryOcta(int number, int base) {
        int result = 0;
        int n = 0;
        while (number > 0) {
            result += number % 10 * Math.pow(base, n);
            number = number / 10;
            n++;
        }
        return Integer.toString(result);
    }

    public static String fromHex(String number, int base) {
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        number = number.toUpperCase();
        int result = 0;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            int d = digits.indexOf(c);
            result = base * result + d;
        }
        return Integer.toString(result);
    }

    public static void fromDecimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number in decimal system: ");
        int number = scanner.nextInt();
        System.out.print("Enter target base: ");
        int base = scanner.nextInt();
        System.out.println("Conversion result: " + fromDecimal(number, base));
    }

    public static void toDecimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source number: ");
        String number = scanner.nextLine();
        System.out.print("Enter source base: ");
        int base = scanner.nextInt();
        switch (base) {
            case 2:
            case 8:
                System.out.println("Conversion to decimal result: " + fromBinaryOcta(Integer.parseInt(number), base));
                break;
            case 36:
                System.out.println("Conversion to decimal result: " + fromHex(number, base));
                break;
        }
    }

//    public static void choseConvert() {
//        Scanner scanner = new Scanner(System.in);
//        String chose = "";
//        do {
//            System.out.print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ");
//            chose = scanner.nextLine();
//            switch (chose) {
//                case "/from":
//                    fromDecimal();
//                    break;
//                case "/to":
//                    toDecimal();
//                    break;
//            }
//        } while (!chose.equals("/exit"));
//    }

    public static void choseConvert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
        String sourceBase1 = scanner.next();
        if(sourceBase1.equals("/exit")){
            System.exit(0);
        }

        int sourceBase=Integer.parseInt(sourceBase1);
        int targetBase = scanner.nextInt();
        scanner.nextLine();

        String number = "";

        do {
            System.out.printf("Enter number in base %d to convert to base %d (To go back type /back) ", sourceBase, targetBase);
            number = scanner.nextLine();
            if (number.equals("/back")) {
                choseConvert();
            }
            if (sourceBase == 10) {
                BigInteger bigInteger = new BigInteger(number);
                System.out.println("Conversion result: " + bigInteger.toString(targetBase));
            } else {
                BigInteger bigInteger = new BigInteger(number, sourceBase);
                System.out.println("Conversion result: " + bigInteger.toString(targetBase));
            }
        } while (!number.equals("/exit"));
    }

    public static void main(String[] args) {
        choseConvert();
    }
}
