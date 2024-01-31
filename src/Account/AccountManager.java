package Account;

import input.Input;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeSet;

public class AccountManager {
    private static final TreeSet<Account> accounts = new TreeSet<>();
    private static Account loggedInAccount = null;

    public static boolean logIn() {
        String email;
        String password;

        do {
            System.out.println("------------Giriş------------");
            System.out.print("E-Posta: ");
            email = Input.nextLine();
            if (email.equals("q") || email.equals("Q")) return false;
            System.out.print("Şifre: ");
            password = Input.nextLine();
            if (password.equals("q") || password.equals("Q")) return false;
        } while (!(isLoggedIn(email, password)));

        return true;
    }

    public static void createAccount() {
        String name;
        String surName;
        String email;
        String password;
        String job;
        int age;

        createAccountLabel:
        while (true) {
            System.out.print("""
                    
                    -------------Hesap Tipi-------------
                    1-Bireysel
                    2-İşletme
                    --------------------------------------
                    Seçiniz:\s""");

            int accountTypeNum = Input.nextInt(1, 3);

            System.out.print("E-Posta: ");
            email = Input.nextLine();

            for (Account account : accounts) {
                if (account.getUser().getEmail().equals(email)) {
                    System.out.println("Bu hesap zaten mevcut!!!");
                    continue createAccountLabel;
                }
            }

            System.out.print("Şİfre: ");
            password = Input.nextLine();
            System.out.print("Ad: ");
            name = Input.nextLine();
            System.out.print("Soyad: ");
            surName = Input.nextLine();
            System.out.print("Meslek: ");
            job = Input.nextLine();
            System.out.print("Yaş: ");
            age = Input.nextInt();

            switch (accountTypeNum) {
                case 1 -> accounts.add(new Individual(new User(name, surName, email, password, job, getDate(), age)));
                case 2 -> accounts.add(new Enterprise(new User(name, surName, email, password, job, getDate(), age)));
            }

            System.out.println("Yeni hesap oluşturuldu!");
            break;
        }
    }

    public static String getDate() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return date.format(formatter);
    }

    public static boolean isLoggedIn(String email, String password) {
        for (Account account : accounts) {
            if (account.getUser().getEmail().equals(email)) {
                if (account.getUser().getPassword().equals(password)) {
                    account.getUser().setLastLogInDate();
                    loggedInAccount = account;
                    System.out.println("Giriş yaptınız!");
                    return true;
                }
            }
        }
        System.out.println("E-posta veya şifre yanlış!");
        return false;
    }

    public static Account getLoggedInAccount() {

        return loggedInAccount;
    }

    public static Account setNullLoggedIntAccount() {

        loggedInAccount = null;
        return null;
    }
}
