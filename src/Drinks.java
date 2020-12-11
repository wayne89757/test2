import java.time.LocalDate;

abstract public class Drinks {
    protected String name;
    protected LocalDate manufactureDate;
    protected int expirationDate;

    Drinks(String name, LocalDate manufactureDate, int expirationDate) {
        this.name = name;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
    }

    public boolean isExpired(){
        return LocalDate.now().minusDays(this.expirationDate).isAfter(this.manufactureDate);
    }

    public abstract String toString();

    public String getName(){
        return this.name;
    }
}
