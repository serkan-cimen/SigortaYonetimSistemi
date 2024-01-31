import Account.Account;
import Account.AccountManager;
import address.AddressManager;
import input.Input;
import insurance.InsuranceManager;

public class Main {
    public static void main(String[] args) {

        run();
    }

    public static void run() {
        program:
        while (true) {
            System.out.print("""
                    ----------Sigorta Menü---------
                    1-Giriş
                    2-Hesap oluştur
                    Q-Çıkış
                    --------------------------------------
                    Seçiniz:\s""");

            String preference = Input.nextLine();

            switch (preference) {
                case "1" -> LogInMenu();
                case "2" -> createAccount();
                case "q" -> {
                    break program;
                }
                default -> System.out.println("Geçerli bir değer girin!");
            }
        }
    }

    public static void LogInMenu() {
        if (AccountManager.logIn()) accountMenu(AccountManager.getLoggedInAccount());
        else run();
    }

    public static void createAccount() {
        AccountManager.createAccount();
        run();
    }

    public static void accountMenu(Account account) {
        accountMenuLabel:
        while (true) {
            System.out.print("""
                    
                    -------------Hesap Menüsü-------------
                    1-Sigorta İşlemleri
                    2-Adres İşlemleri
                    3-Kişinin Bilgilerini Göster
                    Q-Çıkış
                    --------------------------------------
                    Giriş:\s""");

            String preference = Input.nextLine().toLowerCase();

            switch (preference) {
                case "1" -> insuranceMenu(account);
                case "2" -> addressMenu(account);
                case "3" -> account.showInfo();
                case "q" -> {
                    AccountManager.setNullLoggedIntAccount();
                    break accountMenuLabel;
                }
                default -> System.out.println("Geçerli bir değer girin!");
            }
        }
    }

    public static void insuranceMenu(Account account) {
        insuranceMenuLabel:
        while (true) {
            System.out.println("""
                    
                    ------------Sigorta Menüleri------------
                    1-Sigortaları Göster
                    2-Sigorta Ekle
                    Q-Menüye Dön
                    --------------------------------------
                    Giriş:\s""");

            String preference = Input.nextLine().toLowerCase();

            switch (preference) {
                case "1" -> InsuranceManager.printInsurances(account);
                case "2" -> InsuranceManager.addInsurance(account);
                case "q" -> {
                    break insuranceMenuLabel;
                }
                default -> System.out.println("Geçerli bir değer girin!");
            }
        }
    }

    public static void addressMenu(Account account) {
        addressMenuLabel:
        while (true) {
            System.out.print("""
                    -------------Adres Menüleri-------------
                    1-Adresleri Göster
                    2-Adres Ekle
                    3-Adres Sil
                    Q-Menüye Dön
                    --------------------------------------
                    """);

            String preference = Input.nextLine().toLowerCase();

            switch (preference) {
                case "1" -> AddressManager.printAddresses(account.getUser().getAddresses());
                case "2" -> AddressManager.addAddress(account.getUser().getAddresses());
                case "3" -> AddressManager.removeAddress(account.getUser().getAddresses());
                case "q" -> {
                    break addressMenuLabel;
                }
                default -> System.out.println("Geçerli bir değer girin!");
            }
        }
    }
}