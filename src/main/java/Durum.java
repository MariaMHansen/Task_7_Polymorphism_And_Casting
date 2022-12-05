import java.util.Arrays;

public class Durum extends MenuItem{
    private String name;
    private String meat;

    public Durum(String name, String meat) {
        super("durum",65.0);
        this.name = name;
        this.meat = meat;
    }

    public String getName() {
        return name;
    }
    public String getMeat() {
        return meat;
    }


    @Override
    public String toString() {
        return super.toString() + " name: " +getName()+ " meat: "+ getMeat();
    }
}
