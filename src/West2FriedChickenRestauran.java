import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class West2FriedChickenRestauran implements FriedChickenRestaurant{
    private double balance;
    //啤酒果汁动态操作多用链表，套餐静态访问用数组
    private LinkedList<Beer> beers;
    private LinkedList<Juice> juices;
    static private ArrayList<SetMeal> meals;

    static{
        meals = new ArrayList<SetMeal>();
        meals.add(new SetMeal("套餐1", 20, "吮指原味鸡", new Beer("小啤酒", LocalDate.now(), 96)));
        meals.add(new SetMeal("套餐2", 20, "麦辣鸡块", new Juice("维他柠檬茶", LocalDate.now())));
    }

    West2FriedChickenRestauran(double balance){
        beers = new LinkedList<Beer>();
        juices = new LinkedList<Juice>();
        this.balance = balance;
    }

    //遍历，移除过期啤酒
    public void use(Beer beer){
        Iterator<Beer> iter = beers.listIterator();
        while(iter.hasNext()){
            Beer storage = iter.next();
            if(beer.getName().equals(storage.getName())){
                if(storage.isExpired()){
                    System.out.println(storage.getName()+"过期了(┬＿┬)");
                    iter.remove();
                }else{
                    iter.remove();
                    return;
                }
            }
        }
        throw new IngredientSortOutException(beer.getName() + "没有了(┬＿┬)");
    }

    public void use(Juice juice){
        Iterator<Juice> iter = juices.listIterator();
        while(iter.hasNext()){
            Juice storage = iter.next();
            if(juice.getName().equals(storage.getName())){
                if(storage.isExpired()){
                    System.out.println(storage.getName()+"过期了(┬＿┬)");
                    iter.remove();
                }else{
                    iter.remove();
                    return;
                }
            }
        }
        throw new IngredientSortOutException(juice.getName() + "没有了(┬＿┬)");
    }
    @Override
    public void sellSetMeal(int setMealCode) {
        SetMeal setMeal = meals.get(setMealCode);
        Drinks drink = setMeal.getDrink();
        if(drink instanceof Beer){
            try{
                use((Beer) drink);
                System.out.println("成功售出"+setMeal.toString());
            }catch (IngredientSortOutException e){
                System.out.println(e.getMessage());
                System.out.println(setMeal.getName() + "售出失败");
            }
        }else{
            try{
                use((Juice) drink);
                System.out.println("成功售出"+setMeal.toString());
            }catch(IngredientSortOutException e){
                System.out.println(e.getMessage());
                System.out.println(setMeal.getName() + "售出失败");
            }
        }
    }

    @Override
    public void batchPurchase(Drinks drink,  int quantity, double price) {
        if(price>this.balance){
            throw new OverdraftBalanceException("余额不足, 缺少"+ (price-this.balance)+"元");
        }else{
            this.balance -= price;
            if(drink instanceof Beer){
                for(int i=0;i<quantity;i++){
                    beers.add(new Beer((Beer)drink));
                }
            }else{
                for(int i=0;i<quantity;i++){
                    juices.add(new Juice((Juice)drink));
                }
            }
            System.out.println("成功购买"+quantity+"个"+drink.getName()+", 余额: " + this.balance);
        }
    }
}
