package insurance;

import Account.Account;

public class HealthInsurance extends Insurance{
    private static final double rate = 1.32;
    public HealthInsurance(Account account) {
        super(account, "Sağlık Sigortası", rate);
    }
}
