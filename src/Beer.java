import java.time.LocalDate;

public class Beer extends Drinks {
    private float alcohol;

    Beer(Beer e){
        super(e.getName(), e.manufactureDate, e.expirationDate);
        this.alcohol = e.alcohol;
    }

    Beer(String name, LocalDate manufactureDate, float alcohol){
        super(name, manufactureDate, 30);
        this.alcohol = alcohol;
    }

    @Override
    public String toString() {
        return "NAME: " + this.name + '\n' +
                "Manufacture Date: " + this.manufactureDate.toString() + '\n' +
                "Expiration Date: " + this.expirationDate + "days\n" +
                "alcohol content: " + alcohol + '\n';
    }

}
