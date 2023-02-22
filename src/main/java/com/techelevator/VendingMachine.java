package com.techelevator;

import jdk.jshell.spi.ExecutionControl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    private final int MAX_ITEMS_PER_SLOT = 5;
    List<Item> inventoryList = new ArrayList<>();
    DispenserMath dispenserMath = new DispenserMath();
    Item item = new Item();
    Log log = new Log();
    public List<Item> getInventoryList() {
        return inventoryList;
    }

    public List<Item> creatingList() {
        File vendingMachineItems = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-1\\vendingmachine.csv");
        Scanner scanner;
        try {
            scanner = new Scanner(vendingMachineItems);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        while (scanner.hasNextLine()) {
            String lineFromFile = scanner.nextLine();
            String[] myArray = lineFromFile.split("\\|");
            Item item = new Item();
            item.setLocation(myArray[0]);
            item.setName(myArray[1]);
            item.setPrice(BigDecimal.valueOf(Double.parseDouble(myArray[2])));
            item.setType(myArray[3]);
            inventoryList.add(item);

        }
        return inventoryList;
    }

    public String purchaseItem(String input) {

        for (int i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).getLocation().equalsIgnoreCase(input)) {
                if (inventoryList.get(i).getAmountLeft() <= 0) {
                    return "This item is sold out";
                }
                int compareBigDecimals = inventoryList.get(i).getPrice().compareTo(dispenserMath.getCurrentUsersBalance());
                if (compareBigDecimals <= 0) {
                    inventoryList.get(i).purchaseOneItem();
                    log.purchaseItemLog(dispenserMath.getCurrentUsersBalance(), inventoryList.get(i).getName(), input, new DecimalFormat("0.00").format(inventoryList.get(i).getPrice()));
                    dispenserMath.deductMoneyFromPurchase(inventoryList.get(i).getPrice());
                    System.out.println("Your remaining balance is: $" +dispenserMath.getCurrentUsersBalance());
                    if(inventoryList.get(i).getType().equals("Chip")){
                        System.out.println(inventoryList.get(i).getName());
                        System.out.println("The item price is: $"+ new DecimalFormat("0.00").format(inventoryList.get(i).getPrice()));
                        return "Crunch Crunch, It's Yummy!";
                    } else if(inventoryList.get(i).getType().equals("Candy")){
                        System.out.println(inventoryList.get(i).getName());
                        System.out.println("The item price is: $"+ new DecimalFormat("0.00").format(inventoryList.get(i).getPrice()));
                        return "Munch Munch, Mmm Mmm Good!";
                    }else if(inventoryList.get(i).getType().equals("Drink")){
                        System.out.println(inventoryList.get(i).getName());
                        System.out.println("The item price is: $"+ new DecimalFormat("0.00").format(inventoryList.get(i).getPrice()));
                        return "Glug Glug, Chug Chug!";
                    } else if (inventoryList.get(i).getType().equals("Gum")){
                        System.out.println(inventoryList.get(i).getName());
                        System.out.println("The item price is: $"+ new DecimalFormat("0.00").format(inventoryList.get(i).getPrice()));
                        return "Chew Chew, Pop!";
                    }

                } else {
                    return "Insufficient funds";
                }
            }
        }

        return "Bad input. Bad. Bad!";

    }

}
