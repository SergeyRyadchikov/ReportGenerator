package net.project.reportgenerator;


import net.project.reportgenerator.API.ReportForThePeriod;
import net.project.reportgenerator.Model.BranchData;
import net.project.reportgenerator.Model.ListOfBranches;
import net.project.reportgenerator.Model.RequestBody;
import net.project.reportgenerator.Service.Parser;

import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    public static void main(String[] args) {

        String responseBody = null;

        RequestBody requestBody = new RequestBody();

        ReportForThePeriod reportForThePeriod = new ReportForThePeriod();

        ListOfBranches listOfBranches = new ListOfBranches();


        try {
            responseBody = reportForThePeriod.sendRequest(requestBody);
        } catch (URISyntaxException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        } catch (InterruptedException e) {
            e.getMessage();
        }


        listOfBranches.addBranchDataToList(Parser.parseOfDataCSV(responseBody));



        //Проверка
        System.out.println(responseBody + "\n"); // выведем все полученные данные

        for (BranchData brData : listOfBranches.getSortListDeveloper()){ // выведем список объектов BranchData
            System.out.println(brData);
        }
    }
}