package net.project.reportgenerator.View;
/* 
@author Sergey Ryadchikov
 */

import net.project.reportgenerator.Service.Validators.ValidatorOfDate;

import java.util.Scanner;

public class ViewOfInput {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";


    public static String fromDate(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Начальная дата: " + ANSI_RED + "yyyy-mm-dd" + ANSI_RESET);
        String fromDate = scan.nextLine();
//        scan.close();
        if (ValidatorOfDate.isValid(fromDate)){
            fromDate = fromDate + "T00:00:00Z";
        } else {
            fromDate();
        }
        return fromDate;
    }

    public static String toDate(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Конечная дата: " + ANSI_RED + "yyyy-mm-dd" + ANSI_RESET);
        String toDate = scan.nextLine();
//        scan.close();
        if (ValidatorOfDate.isValid(toDate)){
            toDate = toDate + "T00:00:00Z";
        } else {
            toDate();
        }
        return toDate;
    }


}
