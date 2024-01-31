package address;

public class HomeAddress implements Address{
    private final String name;
    private final String address;

    public HomeAddress(String name, String address) {
        this.name = name;
        this.address = address;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "(Ev adresi)" + "\n" + address;
    }
}
