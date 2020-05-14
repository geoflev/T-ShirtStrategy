package tshirtwithstrategy.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import tshirtwithstrategy.Context;
import tshirtwithstrategy.models.TShirt;

public class Strategy {

    private List<TShirt> tShirts;

    public Strategy() {
    }

    public List<TShirt> gettShirts() {
        return tShirts;
    }

    public void settShirts(List<TShirt> tShirts) {
        this.tShirts = tShirts;
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
