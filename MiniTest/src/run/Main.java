package run;


import controller.ManagerMaterial;
import material.CrispyFlour;
import material.Material;
import material.Meat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Material> materials = new ArrayList<>();
    public static ManagerMaterial manager = new ManagerMaterial(materials);
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int checkInput;
        do {
            System.out.println("Menu------------------------");
            System.out.println(
                            "1. Thêm thịt vào danh sách\n" +
                            "2. Thêm bột chiên vào danh sách\n" +
                            "3. hiển thị danh sách vật liệu\n" +
                            "4. Sửa dữ liệu thịt\n" +
                            "5. Sửa dữ liệu bột chiên\n" +
                            "6. Xóa vật liệu trong danh sách\n" +
                            "7. Giá gốc và giá sale thịt\n" +
                            "8. Giá gốc và gia sale bột\n" +
                            "0. Thoát khỏi chương trình\n");

            checkInput = Integer.parseInt(input.nextLine());
            switch (checkInput) {
                case 1 -> manager.addElement(addNewMeet());

                case 2 -> manager.addElement(addNewCrispyFlour());
                case 3 -> manager.display();
                case 4 -> manager.editElement(editNewMeet());
                case 5 -> manager.editElement(editNewCrispyFlour());
                case 6 -> manager.deleteElement();
                case 7 -> {
                    System.out.println("_____________________________________");
                    System.out.println("Tổng tiền thịt được giảm : " + manager.totalPriceMeat());
                    System.out.println("_____________________________________");
                }
                case 8 -> {
                    System.out.println("_____________________________________");
                    System.out.println("Tổng tiền bột được giảm : " + manager.totalPriceCrispyFlour());
                    System.out.println("_____________________________________");
                }
                default -> System.out.println("Vui lòng nhập lại!");
            }
        } while (checkInput != 0);
    }

    public static Material addNewMeet() {
        System.out.print("Nhập id thịt: ");
        String idMeat = input.nextLine();
        System.out.print("Nhập tên thịt: ");
        String nameMeat = input.nextLine();
        LocalDate dayMeat = LocalDate.now();
        System.out.print("Nhập giá thịt: ");
        double priceMeat = Double.parseDouble(input.nextLine());
        System.out.print("Nhập cân nặng thịt: ");
        int weightMeat = Integer.parseInt(input.nextLine());
        return new Meat(idMeat, nameMeat, dayMeat, (int) priceMeat, weightMeat);
    }

    public static Material addNewCrispyFlour() {
        System.out.print("Nhập id bột: ");
        String id = input.nextLine();
        System.out.print("Nhập tên bột: ");
        String name = input.nextLine();
        LocalDate day = LocalDate.now();
        System.out.print("Nhập giá bột: ");
        double price = Double.parseDouble(input.nextLine());
        System.out.print("Nhập số lượng bột: ");
        int quantity = Integer.parseInt(input.nextLine());
        return new CrispyFlour(id, name, day, (int) price, quantity);
    }
    public static Material editNewMeet() {
        System.out.print("Nhập id thịt mới: ");
        String newIdMeat = input.nextLine();
        System.out.print("Nhập tên thịt mới: ");
        String newNameMeat = input.nextLine();
        LocalDate newDayMeat = LocalDate.now();
        System.out.print("Nhập giá thịt mới: ");
        double newPriceMeat = Double.parseDouble(input.nextLine());
        System.out.print("Nhập cân nặng mới: ");
        int newWeightMeat = Integer.parseInt(input.nextLine());
        return new Meat(newIdMeat, newNameMeat, newDayMeat, (int) newPriceMeat, newWeightMeat);
    }
    public static Material editNewCrispyFlour() {
        System.out.print("Nhập id bột mới: ");
        String newId = input.nextLine();
        System.out.print("Nhập tên bột mới: ");
        String newName = input.nextLine();
        LocalDate newDay = LocalDate.now();
        System.out.print("Nhập giá bột mới: ");
        double newPrice = Double.parseDouble(input.nextLine());
        System.out.print("Nhập số lượng bột mới: ");
        int newQuantity = Integer.parseInt(input.nextLine());
        return new CrispyFlour(newId, newName, newDay, (int) newPrice, newQuantity);
    }
}