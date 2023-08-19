package net.project.reportgenerator.View;
/* 
@author Sergey Ryadchikov
 */

import net.project.reportgenerator.Service.Validators.ValidatorOfDate;

import java.util.Scanner;

public class ViewOfInput {


    public static String fromDate(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Начальная дата: ");
        String fromDate = scan.nextLine();
//        scan.close();
        if (ValidatorOfDate.isValid(fromDate)){
            fromDate = fromDate + "T00:00:00Z";
        } else {
            System.out.println("Неверная дата! Введите снова!");
            fromDate();
        }
        return fromDate;
    }

    public static String toDate(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Конечная дата: ");
        String toDate = scan.nextLine();
//        scan.close();
        if (ValidatorOfDate.isValid(toDate)){
            toDate = toDate + "T00:00:00Z";
        } else {
            System.out.println("Неверная дата! Введите снова!");
            toDate();
        }
        return toDate;
    }


}
