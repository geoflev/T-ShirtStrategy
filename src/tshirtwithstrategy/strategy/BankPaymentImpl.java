package tshirtwithstrategy.strategy;

import tshirtwithstrategy.models.Color;
import tshirtwithstrategy.models.Fabric;
import tshirtwithstrategy.models.Size;

public class BankPaymentImpl implements IPayment {
    @Override
    public float pay(float basePrice, Color color, Size size, Fabric fabric) {
        return((basePrice + calculatePrice(color, size, fabric)) * 1.05f); 
    }
}
