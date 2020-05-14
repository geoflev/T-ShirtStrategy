package tshirtwithstrategy.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class TShirt {

    private final float basePrice = 10;
    private String name;
    private Color color;
    private Size size;
    private Fabric fabric;
    private float price;

    public TShirt() {
    }

    public TShirt(String name, Color color, Size size, Fabric fabric, float price) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.fabric = fabric;
        setPrice(price);
    }

    public static List<TShirt> getTshirtList() {
        List<TShirt> tShirts = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Color tShirtcolor = Color.values()[i];
            for (int j = 0; j < 7; j++) {
                Size tShirtsize = Size.values()[j];
                for (int k = 0; k < 7; k++) {
                    Fabric tShirtfabric = Fabric.values()[k];
                    tShirts.add(new TShirt(getRandomName(), tShirtcolor, tShirtsize,
                    tShirtfabric,ThreadLocalRandom.current().nextInt(0, 20 + 1)));
                }
            }
        }
        return tShirts;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = this.basePrice + price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.color);
        hash = 53 * hash + Objects.hashCode(this.size);
        hash = 53 * hash + Objects.hashCode(this.fabric);
        hash = 53 * hash + Float.floatToIntBits(this.price);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TShirt other = (TShirt) obj;
        if (Float.floatToIntBits(this.price) != Float.floatToIntBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        if (this.fabric != other.fabric) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TShirt{" + "name=" + name + ", color=" + color + ", size=" + size + ", fabric=" + fabric + ", price=" + price + '}';
    }
}
