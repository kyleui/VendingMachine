package com.techelevator.view;

import com.techelevator.DispenserMath;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class DispenserMathTest {
    DispenserMath dispenserMath = new DispenserMath();
//Tests for takeMoneyFromUser
    @Test
    public void ifInputIsNumbers(){
        String testString = "2.00";
        BigDecimal expected = new BigDecimal("5.0");
        dispenserMath.setCurrentUsersBalance(BigDecimal.valueOf(3.00));
        BigDecimal result = dispenserMath.takeMoneyFromUser(testString);
        assertEquals(expected, result);
    }

    @Test
    public void ifInputIsNegative(){
        String testString = "-2.00";
        BigDecimal expected = new BigDecimal("5.0");
        dispenserMath.setCurrentUsersBalance(BigDecimal.valueOf(7.00));
        BigDecimal result = dispenserMath.takeMoneyFromUser(testString);
        assertEquals(expected, result);
    }

// tests for getChange
    @Test
    public void noMoneyInputShouldReturnZeroQuarters(){
        dispenserMath.setCurrentUsersBalance(BigDecimal.valueOf(0));
        int expected = 0;
        dispenserMath.getChange(dispenserMath.getCurrentUsersBalance());
        int result = dispenserMath.getQuarters();
        assertEquals(expected, result);
    }

    @Test
    public void noMoneyInputShouldReturnZeroDimes(){
        dispenserMath.setCurrentUsersBalance(BigDecimal.valueOf(0));
        int expected = 0;
        dispenserMath.getChange(dispenserMath.getCurrentUsersBalance());
        int result = dispenserMath.getDimes();
        assertEquals(expected, result);
    }
    @Test
    public void noMoneyInputShouldReturnZeroNickles(){
        dispenserMath.setCurrentUsersBalance(BigDecimal.valueOf(0));
        int expected = 0;
        dispenserMath.getChange(dispenserMath.getCurrentUsersBalance());
        int result = dispenserMath.getNickels();
        assertEquals(expected, result);
    }

    @Test
    public void noMoneyInputShouldReturnZeroPennies(){
        dispenserMath.setCurrentUsersBalance(BigDecimal.valueOf(0));
        int expected = 0;
        dispenserMath.getChange(dispenserMath.getCurrentUsersBalance());
        int result = dispenserMath.getPennies();
        assertEquals(expected, result);
    }

    @Test
    public void inputShouldReturn4Quarters(){
        dispenserMath.setCurrentUsersBalance(BigDecimal.valueOf(1));
        int expected = 4;
        dispenserMath.getChange(dispenserMath.getCurrentUsersBalance());
        int result = dispenserMath.getQuarters();
        assertEquals(expected, result);
    }

    @Test
    public void inputShouldReturn1Dime(){
        dispenserMath.setCurrentUsersBalance(BigDecimal.valueOf(.15));
        int expected = 1;
        dispenserMath.getChange(dispenserMath.getCurrentUsersBalance());
        int result = dispenserMath.getDimes();
        assertEquals(expected, result);
    }
    @Test
    public void inputShouldReturn1Nickels(){
        dispenserMath.setCurrentUsersBalance(BigDecimal.valueOf(0.15));
        int expected = 1;
        dispenserMath.getChange(dispenserMath.getCurrentUsersBalance());
        int result = dispenserMath.getNickels();
        assertEquals(expected, result);
    }

    @Test
    public void inputShouldReturn4Pennies(){
        dispenserMath.setCurrentUsersBalance(BigDecimal.valueOf(0.04));
        int expected = 4;
        dispenserMath.getChange(dispenserMath.getCurrentUsersBalance());
        int result = dispenserMath.getPennies();
        assertEquals(expected, result);
    }

    //Tests on deductMoneyFromPurchase
    @Test
    public void itemPriceIsLessThanCurrentBalance(){
        BigDecimal test = new BigDecimal("2.00");
        dispenserMath.setCurrentUsersBalance(BigDecimal.valueOf(7.00));
        BigDecimal expected = new BigDecimal("5.00");
        BigDecimal result = dispenserMath.deductMoneyFromPurchase(test);
        assertEquals(expected, result);
    }
}
