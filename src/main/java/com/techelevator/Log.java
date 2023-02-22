package com.techelevator;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Log {


    File IncomeLog = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-1\\src\\main\\resources\\Log.txt");
    boolean append = IncomeLog.exists();

    private String getCurrentTime(){
        String date = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").format(new Date());
        return date;
    }




    public void feedMoneyLog(String input, BigDecimal currentUserBalance){
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(IncomeLog, append))){
            writer.println(getCurrentTime() + " FEED MONEY $" + input + " $" + currentUserBalance);

        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
    }

    public void purchaseItemLog(BigDecimal currentUserBalance, String itemName, String itemLocation, String itemPrice){
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(IncomeLog, append))){
            writer.println(getCurrentTime()+ " " + itemName + " " + itemLocation + " $" + itemPrice + " $" + currentUserBalance);

        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
    }

    public void cashOutLog(BigDecimal changeAmount){
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(IncomeLog, append))){
            writer.println(getCurrentTime() + " GIVE CHANGE" + " $" + changeAmount + " $0.00");

        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
    }
}



