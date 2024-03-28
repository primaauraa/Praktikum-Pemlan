package Tugas.Praktikum.Pemlan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Hero hero1 = new Hero();
        System.out.print("\nPERMAINAN ADU HERO\n" + "Masukkan Hero anda!\n" + "Nama player 1 : ");
        String name1 = input.nextLine();
        hero1.setNamaPemain(name1);
        System.out.print("\nMasukkan angka antara 0 hingga 500!\n" + "=================================================\n" + "Health point : ");
        double hp1 = masukan(input, 0, 500);
        hero1.setHealthPoin(hp1);
        System.out.print("Attack point : ");
        double attack1 = masukan(input, 0, 500);
        hero1.setSerang(attack1);
        System.out.print("Defense point : ");
        double defense1 = masukan(input, 0, 500);
        hero1.setBertahan(defense1);

        input.nextLine(); 
        System.out.println();
        System.out.print("\nPERMAINAN ADU HERO\n" + "Masukkan Hero anda!\n" + "Nama player 2 : ");
        String name2 = input.nextLine();
        System.out.print("\nMasukkan angka antara 0 hingga 500!\n" + "=================================================\n" + "Health point : ");
        double hp2 = masukan(input, 0, 500);
        System.out.print("Attack point : ");
        double attack2 = masukan(input, 0, 500);
        System.out.print("Defense point: ");
        double defense2 = masukan(input, 0, 500);

        Hero hero2 = new Hero(name2, hp2, attack2, defense2);

        System.out.println("\nMemulai pertarungan!\n");

        int pertarungan = 1; 
        while (pertarungan <= 5 && hero1.healthPoin() > 0 && hero2.healthPoin() > 0) {
            System.out.println("=========================================================\n" + "=========================================================\n" + "Ronde " + pertarungan + ":\n");
            hero1Attack(hero1, hero2); 
            if (hero2.healthPoin() > 0) { 
                hero2Attack(hero2, hero1); 
            }
            pertarungan++; 
            System.out.println(); 
        }

        System.out.println("Pertarungan selesai!\n");
        if (hero1.healthPoin() <= 0 && hero2.healthPoin() <= 0) {
            System.out.println("Pertarungan berakhir imbang!");
        } else if (hero1.healthPoin() <= 0) {
            System.out.println(hero2.namaPemain() + " adalah pemenang dengan health " + hero2.healthPoin() + "!");
        } else {
            System.out.println(hero1.namaPemain() + " adalah pemenang dengan health " + hero1.healthPoin() + "!");
        }

        input.close();
    }

    public static double masukan(Scanner scanner, double min, double max) {
        double input;
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Input tidak valid! Masukkan nilai numerik.");
                scanner.next();
            }
            input = scanner.nextDouble();
            if (input < min || input > max) {
                System.out.println("Input diluar rentang yang valid! Masukkan nilai antara " + min + " dan " + max + ".");
            }
        } while (input < min || input > max);
        return input;
    }

    public static void hero1Attack(Hero attacker, Hero defender) {
        double sisa = attacker.serang() - defender.bertahan();
        if (sisa > 0) {
            double newHealthPoin = defender.healthPoin() - sisa;
            if (newHealthPoin < 0) newHealthPoin = 0;
            defender.setHealthPoin(newHealthPoin);
        }
        printAttack(attacker, defender, sisa);
    }

    public static void hero2Attack(Hero attacker, Hero defender) {
        double sisa = attacker.serang() - defender.bertahan();
        if (sisa > 0) {
            double newHealthPoin = defender.healthPoin() - sisa;
            if (newHealthPoin < 0) newHealthPoin = 0;
            defender.setHealthPoin(newHealthPoin);
        }
        printAttack(attacker, defender, sisa);
    }

    public static void printAttack(Hero attacker, Hero defender, double sisa) {
        System.out.println();
        System.out.println(attacker.namaPemain() + " menyerang " + defender.namaPemain() + "!");
        System.out.println();
        System.out.println(attacker.namaPemain() + " menyerang dengan kekuatan " + attacker.serang() + "!");
        System.out.println(defender.namaPemain() + " memiliki pertahanan sebesar " + defender.serang() + "!");
        if (sisa > 0) {
            System.out.println(defender.namaPemain() + " menerima " + sisa + " kerusakan!\n" + "Health " + defender.namaPemain() + " saat ini: " + defender.healthPoin() + "\n");
        } else {
            System.out.println(defender.namaPemain() + " tidak menerima kerusakan!" + "Health " + defender.namaPemain() + " masih utuh: " + defender.healthPoin() + "\n");
        }
    }
}

    

