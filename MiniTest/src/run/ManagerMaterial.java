package run;

import material.CrispyFlour;
import material.Material;
import material.Meat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerMaterial {
    public ArrayList<Material> materials;

    public ManagerMaterial() {
        materials = new ArrayList<>();
        materials.add(new CrispyFlour("f1", "bột", LocalDate.now().plusMonths(11), 500, 2));
        materials.add(new CrispyFlour("f2", "bột", LocalDate.now().plusMonths(10), 600, 1));
        materials.add(new CrispyFlour("f3", "bột", LocalDate.now().plusMonths(9), 700, 2));
        materials.add(new CrispyFlour("f4", "bột", LocalDate.now().plusMonths(8), 400, 3));
        materials.add(new CrispyFlour("f5", "bột", LocalDate.now().plusMonths(11), 350, 1));
        materials.add(new Meat("m1", "thịt", LocalDate.now().plusDays(2), 2000, 1));
        materials.add(new Meat("m2", "thịt", LocalDate.now().plusDays(6), 1700, 2));
        materials.add(new Meat("m3", "thịt", LocalDate.now().plusDays(1), 2200, 2));
        materials.add(new Meat("m4", "thịt", LocalDate.now().plusDays(1), 2100, 1));
        materials.add(new Meat("m5", "thịt", LocalDate.now().plusDays(1), 1900, 3));
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
            if (material instanceof Meat) {
                priceMeat += material.getRealMoney();
                totalMoneyMeatSale += (material.getAmount() - material.getRealMoney());
            }
        }
        System.out.println("_____________________________________");
        System.out.println("Tổng giá thịt sau giảm: " + priceMeat);
        System.out.println("Tổng tiền thịt được giảm : " + totalMoneyMeatSale);
        System.out.println("_____________________________________");
    }

    public void totalPriceCrispyFlour() {
        double priceCrispyFlour = 0;
        double totalScrispyFlourSale = 0;
        for (Material material : materials) {
            if (material instanceof CrispyFlour) {
                priceCrispyFlour += material.getRealMoney();
                totalScrispyFlourSale += (material.getAmount() - material.getRealMoney());
            }
        }
        System.out.println("_____________________________________");
        System.out.println("Tổng giá bột chiên sau giảm: " + priceCrispyFlour);
        System.out.println("Tổng tiền bột được giảm : " + totalScrispyFlourSale);
        System.out.println("_____________________________________");
    }

    int index;
    Scanner input = new Scanner(System.in);

    //xóa đối tượng
    public void deleteElement() {
        System.out.print("Nhập vị trí muốn xóa: ");
        index = input.nextInt();
        for (int i = 0; i < materials.size(); i++) {
            if (i == index) {
                materials.remove(i);
            } else if (index >= materials.size()) {
                System.out.println("Không tìm thấy vị trí số " + index);
                break;
            }
        }
    }

    //thêm đối tượng
    public void addElement(Material material) {
        System.out.print("Nhập vị trí muốn thêm: ");
        index = input.nextInt();
        for (int i = 0; i < materials.size(); i++) {
            if (i == index) {
                materials.add(i, material);
            } else if (index >= materials.size()) {
                materials.add(material);
                System.out.println("Không thể thêm tại vị trí số " + index);
                break;
            }
        }
    }

    //Sửa đối tượng
    public void editElement(Material material) {
        System.out.print("Nhập vị trí muốn sửa: ");
        index = input.nextInt();
        for (int i = 0; i < materials.size(); i++) {
            if (i == index) {
                materials.set(i, material);
            } else if (index >= materials.size()) {
                System.out.println("Không thể sửa tại vị trí số " + index);
                break;
            }

        }
    }
}
