package insurance;

import Account.Account;
import input.Input;

import java.util.Comparator;

public class InsuranceManager {
    public static void addInsurance(Account account) {

        System.out.println("""
                1-Araç Sigortası
                2-Sağlık Sigortası
                3-Bina Sigortası
                4-Seyahat Sigortası
                Seçiniz:\s""");

        int preference = Input.nextInt(1, 5);

        switch (preference) {
            case 1 -> account.getInsurances().add(new CarInsurance(account));
            case 2 -> account.getInsurances().add(new HealthInsurance(account));
            case 3 -> account.getInsurances().add(new ResidenceInsurance(account));
            case 4 -> account.getInsurances().add(new TravelInsurance(account));
        }

        account.getInsurances().sort(Comparator.comparing((Insurance o) -> o.getType()));
    }

    public static void printInsurances(Account account) {
        for (Insurance insurance : account.getInsurances()) {
            System.out.println(insurance.toString());
        }
    }
}
