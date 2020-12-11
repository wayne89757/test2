import java.time.LocalDate;

public class Test {
    public static void main(String[] argv){
        West2FriedChickenRestauran wr = new West2FriedChickenRestauran(502);
        try{
            wr.batchPurchase(new Juice("维他柠檬茶", LocalDate.now()), 1, 2);
            wr.batchPurchase(new Beer("小啤酒", LocalDate.now().minusDays(60), 96), 1, 500);
            wr.batchPurchase(new Beer("小啤酒", LocalDate.now(), 96), 1, 1e8);
        }catch (OverdraftBalanceException e){
            System.out.println(e.getMessage());
        }
        wr.sellSetMeal(1); //套餐2, 维他有库存可以卖
        wr.sellSetMeal(0); //套餐1, 唯一的小啤酒过期了, 卖不了
    }
}