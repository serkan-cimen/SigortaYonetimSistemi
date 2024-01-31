package input;

import java.util.Scanner;

public class Input {
    private static final Scanner scan = new Scanner(System.in);

    public static int nextInt() {
        int num;
        while (true) {
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                scan.nextLine();
                return num;
            } else {
                System.out.print("Bir sayı giriniz!");
                scan.nextLine();
            }
        }
    }

    public static int nextInt(int origin, int bound) {
        int num;
        while (true) {
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                if (num >= origin && num < bound) {
                    scan.nextLine();
                    return num;
                } else {
                    System.out.println("Arasındaki sayıyı girin" + origin + "ve" + bound + "!!!");
                    scan.nextLine();
                }
            } else {
                System.out.print("Bir sayı giriniz!:");
                scan.nextLine();
            }
        }
    }

    public static double nextDouble() {
        double num;
        while (true) {
            if (scan.hasNextDouble()) {
                num = scan.nextDouble();
                scan.nextLine();
                return num;
            } else {
                System.out.print("Çift sayı girin!: ");
                scan.nextLine();
            }
        }
    }

    public static String nextLine() {
        return scan.nextLine();
    }
}
