package net.project.reportgenerator;


import net.project.reportgenerator.API.ReportForThePeriod;
import net.project.reportgenerator.Model.RequestBody;

import java.io.IOException;
import java.net.URISyntaxException;

public class Application{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    public static void main(String[] args){

        RequestBody requestBody = new RequestBody();
        ReportForThePeriod reportForThePeriod = new ReportForThePeriod();
        try{
            System.out.println(reportForThePeriod.sendRequest(requestBody));
        } catch (URISyntaxException e){
            e.getMessage();
        } catch (IOException e){
            e.getMessage();
        } catch (InterruptedException e) {
            e.getMessage();
        }




    }
}