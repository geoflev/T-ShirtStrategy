package tshirtwithstrategy;

import java.util.HashMap;
import java.util.List;
import tshirtwithstrategy.models.Color;
import tshirtwithstrategy.models.Fabric;
import tshirtwithstrategy.models.Size;
import tshirtwithstrategy.strategy.IPayment;

public class Context {

    IPayment payment;
    List<IPayment> payments;

    public Context(IPayment payment) {
        this.payment = payment;
    }

    public Context(List<IPayment> payments) {
        this.payments = payments;
    }

    public float executePayment(float basePrice, Color color, Size size, Fabric fabric) {
        return payment.pay(basePrice, color, size, fabric);
    }

    public HashMap<String, Float> executePayments(float basePrice, Color color, Size size, Fabric fabric) {
        HashMap<String, Float> pays = new HashMap<>();
        for (IPayment payment : payments) {
            pays.put(payment.getClass().getSimpleName(), payment.pay(basePrice, color, size, fabric));
        }
        return pays;
    }
}
