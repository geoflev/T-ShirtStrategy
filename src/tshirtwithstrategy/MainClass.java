package tshirtwithstrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import tshirtwithstrategy.models.Color;
import tshirtwithstrategy.models.Fabric;
import tshirtwithstrategy.models.Size;
import tshirtwithstrategy.models.TShirt;
import tshirtwithstrategy.strategy.BankPaymentImpl;
import tshirtwithstrategy.strategy.CardPaymentImpl;
import tshirtwithstrategy.strategy.CashPaymentImpl;
import tshirtwithstrategy.strategy.IPayment;

public class MainClass {

    public static void main(String[] args) {

        List<TShirt> tShirts = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Color color = Color.values()[i];
            for (int j = 0; j < 7; j++) {
                Size size = Size.values()[j];
                for (int k = 0; k < 7; k++) {
                    Fabric fabric = Fabric.values()[k];
                    tShirts.add(new TShirt(getRandomName(), color, size, fabric, ThreadLocalRandom.current().nextInt(0, 20 + 1)));
                }
            }
        }
//asfjhasdfb
        generateTShirtsAndStrategies(tShirts).forEach(action
                -> {
            System.out.println("------------------------");
            action.entrySet().forEach(entry
                    -> {
                System.out.println(entry.getKey() + " Price: " + entry.getValue());
            });
        });
    }

    public static List<HashMap<String, Float>> generateTShirtsAndStrategies(List<TShirt> tShirts) {

        List<HashMap<String, Float>> hashList = new ArrayList<>();

        for (int i = 0; i < tShirts.size(); i++) {
            hashList.add(generateTShirtAndStategies(tShirts.get(i)));
        }
        return (hashList);
    }

    public static HashMap<String, Float> generateTShirtAndStategies(TShirt tshirt) {

        List<IPayment> payments = Arrays.asList(new IPayment[]{new CardPaymentImpl(), new BankPaymentImpl(), new CashPaymentImpl()});   // new ArrayList<>();
        HashMap<String, Float> allPayments = new HashMap<>();
        Context contextAll = new Context(payments);
        allPayments = contextAll.executePayments(tshirt.getPrice(), tshirt.getColor(), tshirt.getSize(), tshirt.getFabric());
        return (allPayments);

    }

    public static String getRandomName() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return (generatedString);
    }

}
