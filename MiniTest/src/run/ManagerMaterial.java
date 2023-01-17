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
    public void totalPriceMeat() {
        double priceMeat = 0;
        for (Material material : materials) {
            if(material instanceof Meat) {
                if (material.getExpiryDate() .compareTo(material.getManufacturingDate())<=5) {
                    priceMeat += material.getCost() *(100-30)/100;
                } else{
                    priceMeat += material.getCost() *(100-10)/100;
                }
            }
        } System.out.println("Tổng giá thịt sau giảm: " +priceMeat);
    }

    public void totalPriceCrispyFlour() {
        double priceCrispyFlour =0 ;
        for (Material material : materials) {
            if (material instanceof CrispyFlour) {
                if ((material.getExpiryDate().compareTo(material.getManufacturingDate())<2)) {
                    priceCrispyFlour += material.getCost()*40/100;
                } else if (material.getExpiryDate().compareTo(material.getManufacturingDate())<4){
                    priceCrispyFlour += material.getCost()*20/100;
                } else {
                    priceCrispyFlour += material.getCost()*20/100;
                }
            }
        }
        System.out.println("Tổng giá bột sau giảm: " + priceCrispyFlour);
    }

}
