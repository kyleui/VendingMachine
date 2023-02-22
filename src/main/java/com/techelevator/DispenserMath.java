package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class DispenserMath {
private BigDecimal currentUsersBalance = new BigDecimal("0.00");
    private final BigDecimal QUARTER = new BigDecimal("0.25");
    private final BigDecimal DIME = new BigDecimal("0.10");
    private final BigDecimal NICKEL = new BigDecimal("0.05");
    private final BigDecimal PENNY = new BigDecimal("0.01");
    int quarters = 0;
    int dimes = 0;
    int nickels = 0;
    int pennies = 0;

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public int getDimes() {
        return dimes;
    }


    public int getNickels() {
        return nickels;
    }


    public int getPennies() {
        return pennies;
    }


    public BigDecimal getCurrentUsersBalance() {
        return currentUsersBalance;
    }

    public void setCurrentUsersBalance(BigDecimal currentUsersBalance) {
        this.currentUsersBalance = currentUsersBalance;
    }



    public BigDecimal takeMoneyFromUser(String input){

        currentUsersBalance = currentUsersBalance.add(BigDecimal.valueOf(Double.parseDouble(input)));
        return currentUsersBalance;
    }

    public void getChange(BigDecimal currentUsersBalance){


        while (currentUsersBalance.compareTo(BigDecimal.ZERO) == 1) {
            while (currentUsersBalance.compareTo(QUARTER) >= 0) {
                currentUsersBalance = currentUsersBalance.subtract(BigDecimal.valueOf(.25));
                quarters ++;
            }
            while (currentUsersBalance.compareTo(DIME) >= 0) {
                currentUsersBalance = currentUsersBalance.subtract(BigDecimal.valueOf(.10));
                dimes ++;
            }
            while (currentUsersBalance.compareTo(NICKEL) >= 0) {
                currentUsersBalance = currentUsersBalance.subtract(BigDecimal.valueOf(.05));
                nickels ++;
            }
            while (currentUsersBalance.compareTo(PENNY) >= 0) {
                currentUsersBalance =  currentUsersBalance.subtract(BigDecimal.valueOf(.01));
                pennies ++;
            }
        }
        currentUsersBalance = BigDecimal.ZERO;
        System.out.println("Here's your change: " + quarters + " quarters " + dimes + " dimes " + nickels + " nickels " + pennies + " pennies.");
    }

    public BigDecimal deductMoneyFromPurchase(BigDecimal itemPrice){
        Integer conversionCurrentUserBalance = currentUsersBalance.toBigInteger().intValueExact();
        return currentUsersBalance = currentUsersBalance.subtract(itemPrice);
        }


}
