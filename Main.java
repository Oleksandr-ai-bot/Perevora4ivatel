import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String vvedenyiTekst = vvodStroki();
        int vibir = vibirFunktsii();

        if (vibir == 1) {
            System.out.println("Перевернута вся строка:");
            System.out.println(perevernutVsuStroku(vvedenyiTekst));
        } else {
            System.out.println("Перевернуте кожне слово:");
            System.out.println(perevernutKozhneSlovo(vvedenyiTekst));
        }
    }

    public static String vvodStroki() {
        Scanner scanner = new Scanner(System.in);
        String pole;
        while (true) {
            System.out.println("Введіть строку (мінімум 2 слова по 3 символи):");
            pole = scanner.nextLine();

            while (pole.length() > 0 && pole.charAt(0) == ' ') {
                pole = pole.substring(1);
            }
            while (pole.length() > 0 && pole.charAt(pole.length() - 1) == ' ') {
                pole = pole.substring(0, pole.length() - 1);
            }

            String[] slova = pole.split(" ");

            if (slova.length < 2) {
                System.out.println("Помилка: введіть мінімум 2 слова!");
                continue;
            }

            boolean majeProblemu = false;
            for (String slovo : slova) {
                if (slovo.length() < 3) {
                    majeProblemu = true;
                    break;
                }
            }

            if (majeProblemu) {
                System.out.println("Помилка: кожне слово має містити мінімум 3 символи!");
                continue;
            }

            return pole;
        }
    }

    public static int vibirFunktsii() {
        Scanner scanner = new Scanner(System.in);
        int vibir;
        while (true) {
            System.out.println("Виберіть функцію:");
            System.out.println("1 - Перевернути всю строку");
            System.out.println("2 - Перевернути кожне слово");

            try {
                vibir = Integer.parseInt(scanner.nextLine());
                if (vibir == 1 || vibir == 2) {
                    return vibir;
                } else {
                    System.out.println("Помилка: введіть 1 або 2!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Помилка: введіть число!");
            }
        }
    }

    public static String perevernutVsuStroku(String pole) {
        String rezultat = "";
        for (int i = pole.length() - 1; i >= 0; i--) {
            rezultat = rezultat + pole.charAt(i);
        }
        return rezultat;
    }

    public static String perevernutKozhneSlovo(String pole) {
        String[] slova = pole.split(" ");
        String rezultat = "";

        for (int i = 0; i < slova.length; i++) {
            String perevernuteSlovo = "";
            for (int j = slova[i].length() - 1; j >= 0; j--) {
                perevernuteSlovo = perevernuteSlovo + slova[i].charAt(j);
            }
            rezultat = rezultat + perevernuteSlovo;
            if (i < slova.length - 1) {
                rezultat = rezultat + " ";
            }
        }

        return rezultat;
    }
}