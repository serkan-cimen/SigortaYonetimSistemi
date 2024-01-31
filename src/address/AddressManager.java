package address;

import input.Input;

import java.util.ArrayList;
import java.util.Comparator;

public class AddressManager {
    public static void addAddress(ArrayList<Address> addresses) {
        String name;
        String address;
        int preference;

        System.out.print("""
                1-Ev Adresi
                2-İş Adresi
                Seçim yapınız:\s""");

        preference = Input.nextInt(1, 3);

        System.out.print("Adres Yazınız: ");
        name = Input.nextLine();
        System.out.print("Tam Adres Yazınız: ");
        address = Input.nextLine();

        switch (preference) {
            case 1 -> addresses.add(new HomeAddress(name, address));
            case 2 -> addresses.add(new BusinessAddress(name, address));
        }
        reList(addresses);
    }

    public static void removeAddress(ArrayList<Address> addresses) {
        printAddresses(addresses);
        System.out.print("Seçim yapınız veya geri dönmek için Q tuşuna basın: ");
        int addressIndex = Input.nextInt(1, addresses.size() + 1) - 1;
        addresses.remove(addressIndex);
    }

    public static void printAddresses(ArrayList<Address> addresses) {
        int i = 0;
        System.out.println("------------------------Adres------------------------");
        for (Address address : addresses)
            System.out.println((++i) + "-" + address.toString() +
                    "\n---------------------------------------------------------");
    }

    private static void reList(ArrayList<Address> addresses) {
        addresses.sort(Comparator.comparing((Address address) -> address.getName()));
    }
}
