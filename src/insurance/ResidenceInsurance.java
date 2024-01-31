package insurance;

import Account.Account;

public class ResidenceInsurance extends Insurance{
    private static final double rate = 1.60;

    public ResidenceInsurance (Account account) {
        super(account, "Bina Sigortası", rate);
    }
}
