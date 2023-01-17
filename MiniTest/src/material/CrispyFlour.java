package material;

import java.time.LocalDate;

public class CrispyFlour extends Material {
    private int quantity;

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return this.quantity*getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return LocalDate.now().plusYears(1);
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +
                "quantity=" + quantity +
                "cost =" + getCost() +
                '}';
    }

    @Override
    public double getRealMoney() {
        return 0;
    }
}