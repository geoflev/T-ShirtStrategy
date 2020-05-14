package tshirtwithstrategy;

import java.util.List;
import tshirtwithstrategy.models.TShirt;
import tshirtwithstrategy.strategy.Strategy;

public class MainClass {

    public static void main(String[] args) {

        List<TShirt> tShirtList = TShirt.getTshirtList();
        printTshirtList(tShirtList);

        
    }

    public static void printTshirtList(List<TShirt> tshirtList) {
        Strategy.generateTShirtsAndStrategies(tshirtList).forEach(action
                -> {
            System.out.println("------------------------");
            action.entrySet().forEach(entry
                    -> {
                System.out.println(entry.getKey() + " Price: " + entry.getValue());
            });
        });

    }
}
