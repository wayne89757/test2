import java.time.LocalDate;

public class Juice extends Drinks {

    Juice(Juice e){
        super(e.getName(), e.manufactureDate, e.expirationDate);
    }

    Juice(String name, LocalDate manufactureDate){
        super(name, manufactureDate, 2);
    }

    @Override
    public String toString() {
        return "NAME: " + this.name + '\n' +
                "Manufacture Date: " + this.manufactureDate.toString() + '\n' +
                "Expiration Date: " + this.expirationDate + "days\n";
    }

}
