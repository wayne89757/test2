public class SetMeal {
    String name;
    double price;
    String chikenName;
    Drinks drink;
    SetMeal(String name, double price, String chickenName, Drinks drink){
        this.name = name;
        this.price = price;
        this.chikenName = chickenName;
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", chikenName='" + chikenName + '\'' +
                ", drink=" + drink.getName() +
                '}' ;
    }

    public String getName(){
        return this.name;
    }

    public Drinks getDrink(){
        return this.drink;
    }
}
