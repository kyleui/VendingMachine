package com.techelevator.view;

import com.techelevator.VendingMachine;
import org.junit.Test;
import static org.junit.Assert.*;


public class VendingMachineTest {
    VendingMachine vendingMachine = new VendingMachine();
    //purchaseItem tests
    @Test
    public void outOfBoundsInput(){
        String testString = "A26";
        String expected = "Bad input. Bad. Bad!";
        String result = vendingMachine.purchaseItem(testString);
        assertEquals(expected, result);
    }

    @Test
    public void noEntry(){
        String testString = "";
        String expected = "Bad input. Bad. Bad!";
        String result = vendingMachine.purchaseItem(testString);
        assertEquals(expected, result);
    }



}
