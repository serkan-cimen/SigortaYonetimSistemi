package insurance;

import Account.Account;
import input.Input;

public abstract class Insurance {
    Account account;
    String name;
    String startDate;
    String endDate;
    String type;
    double price;
    double rate;

    Insurance(Account account, String type, double rate) {
        this.account = account;
        this.type = type;
        this.rate = rate;
        createInsurance();
    }

    public void createInsurance() {
        System.out.println("--------Yeni Sigorta Oluştur--------");

        System.out.print("Sigorta Adı: ");
        this.name = Input.nextLine();
        System.out.print("SBaşlama Tarihi: ");
        this.startDate = Input.nextLine();
        System.out.print("Bitiş Tarihi: ");
        this.endDate = Input.nextLine();
        System.out.print("Fiyat: ");
        this.price = Input.nextDouble();
    }

    public double calculate() {
        return price * rate * account.getRate();
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Ad: " + name + "Başlama Tarihi: " + startDate + "Bitiş Tarihi: " + endDate + "Toplam Fiyat: " + calculate();
    }
}
