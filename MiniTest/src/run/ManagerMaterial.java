package run;

import material.CrispyFlour;
import material.Material;
import material.Meat;
import material.Discount;
import java.time.LocalDate;

public class ManagerMaterial {
    Material[] materials;

    public ManagerMaterial() {
        materials = new Material[10];
        materials[0] = new CrispyFlour("f1","bột", LocalDate.now().plusMonths(11),500,2);
        materials[1] = new CrispyFlour("f2","bột", LocalDate.now().plusMonths(10),600,1);
        materials[2] = new CrispyFlour("f3","bột", LocalDate.now().plusMonths(9),700,2);
        materials[3] = new CrispyFlour("f4","bột", LocalDate.now().plusMonths(8),400,3);
        materials[4] = new CrispyFlour("f5","bột", LocalDate.now().plusMonths(11),350,1);
        materials[5] = new Meat("m1","thịt", LocalDate.now().plusDays(2),2000,1);
        materials[6] = new Meat("m2","thịt", LocalDate.now().plusDays(6),1700,2);
        materials[7] = new Meat("m3","thịt", LocalDate.now().plusDays(1),2200,2);
        materials[8] = new Meat("m4","thịt", LocalDate.now().plusDays(1),2100,1);
        materials[9] = new Meat("m5","thịt", LocalDate.now().plusDays(1),1900,3);

    }

    public void display() {
        for (Material material : materials) {
            System.out.println(material);
            }
    }
    public void totalPriceMeat() {
        double priceMeat = 0;
        double totalMoneyMeatSale = 0;
        for (Material material : materials) {
            if(material instanceof Meat) {
                priceMeat += material.getRealMoney();
                totalMoneyMeatSale += (material.getAmount()-material.getRealMoney());
            }
        }
        System.out.println("_____________________________________");
        System.out.println("Tổng giá thịt sau giảm: " +priceMeat);
        System.out.println("Tổng tiền thịt được giảm : " +totalMoneyMeatSale);
    }

    public void totalPriceCrispyFlour() {
        double priceCrispyFlour =0;
        double totalScrispyFlourSale =0;
        for (Material material : materials) {
            if (material instanceof CrispyFlour) {
                priceCrispyFlour += material.getRealMoney();
                totalScrispyFlourSale += (material.getAmount()-material.getRealMoney());
            }
        }
        System.out.println("_____________________________________");
        System.out.println("Tổng giá bột chiên sau giảm: " + priceCrispyFlour);
        System.out.println("Tổng tiền bột được giảm : " + totalScrispyFlourSale);
    }

}
