package tshirtwithstrategy;

import java.util.List;
import tshirtwithstrategy.models.TShirt;
import tshirtwithstrategy.strategy.Strategy;

public class MainClass {

    public static void main(String[] args) {

        Strategy strategy = new Strategy();
        TShirt tShirt = new TShirt();
        List<TShirt> tShirtList = tShirt.getTshirtList();
        
        strategy.generateTShirtsAndStrategies(tShirtList).forEach(action
                -> {
            System.out.println("------------------------");
            action.entrySet().forEach(entry
                    -> {
                System.out.println(entry.getKey() + " Price: " + entry.getValue());
            });
        });
    
    }
}


