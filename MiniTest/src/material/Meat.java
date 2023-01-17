package material;

import java.time.LocalDate;

public class Meat extends Material {
    private double weight;

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return this.weight*getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return LocalDate.now().plusDays(7);
    }

    @Override
    public String toString() {
        return "Meat{" +
                "weight=" + weight +
                "cost=" + getCost() +
                '}';
    }

    @Override
    public double getRealMoney() {
        return 0;
    }
}
