package com.techelevator;

import com.techelevator.view.VendingMenu;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String MAIN_MENU_SECRET_OPTION = "*Sales Report";

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

    private VendingMenu menu;

    public VendingMachineCLI(VendingMenu menu) {
        this.menu = menu;
    }


    public static void main(String[] args) {
        VendingMenu menu = new VendingMenu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }


    public void run() {

        VendingMachine vendingMachine = new VendingMachine();
        Log log = new Log();
        vendingMachine.creatingList();
        Scanner userInput = new Scanner(System.in);

        boolean running = true;
        //TODO add in functionality for sub menus
        while (running) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                for (int i = 0; i < vendingMachine.inventoryList.size(); i++) {
                    System.out.println(vendingMachine.inventoryList.get(i).getLocation() + "|" + vendingMachine.inventoryList.get(i).getName() + "|" + new DecimalFormat("0.00").format(vendingMachine.inventoryList.get(i).getPrice()) + "|" + vendingMachine.inventoryList.get(i).getType() + "|" + vendingMachine.inventoryList.get(i).getAmountLeft());
                }
                // display vending machine items
            }

            if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                boolean isInPurchaseMenu = true;

                while (isInPurchaseMenu) {
                    String newChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                    if (newChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                        //TODO show the items that are for sale (Location, item name, price, quantity)
                        for (int i = 0; i < vendingMachine.inventoryList.size(); i++) {
                            Item thisItem = vendingMachine.inventoryList.get(i);
                            String quantMessage;
                            if (thisItem.getAmountLeft() == 0) {
                                quantMessage = "SOLD OUT";
                            } else {
                                quantMessage = String.valueOf(thisItem.getAmountLeft());
                            }
                            System.out.println(thisItem.getLocation() + "|" + thisItem.getName() + "|" + new DecimalFormat("0.00").format(thisItem.getPrice()) + "|" + thisItem.getType() + "|" + quantMessage);

                        }

                        System.out.println("Enter the location of an item");
                        String input = userInput.nextLine();
                        System.out.println(vendingMachine.purchaseItem(input));
                    }
                    if (newChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                        System.out.println("Please deposit money in whole dollars");
                        Scanner usersInput = new Scanner(System.in);
                        String inputMoney = usersInput.nextLine();
                        System.out.println("Current Balance: " + "$" + vendingMachine.dispenserMath.takeMoneyFromUser(inputMoney));
                        log.feedMoneyLog(new DecimalFormat("0.00").format(BigDecimal.valueOf(Double.parseDouble(inputMoney))), vendingMachine.dispenserMath.getCurrentUsersBalance());
                    }
                    if (newChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                        vendingMachine.dispenserMath.getChange(vendingMachine.dispenserMath.getCurrentUsersBalance());
                        isInPurchaseMenu = false;
                        log.cashOutLog(vendingMachine.dispenserMath.getCurrentUsersBalance());
                    }
                }
            }

            if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                running = false;
            }

        }

    }

    public void displayInventory() {

    }

}
