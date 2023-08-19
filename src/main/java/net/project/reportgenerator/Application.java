package net.project.reportgenerator;


import net.project.reportgenerator.Model.RequestBody;

public class Application{



    public static void main(String[] args) {
//        String a = "2020-02-29";
//        System.out.println(ValidatorOfDate.isValid(a));
        RequestBody requestBody = new RequestBody();
        System.out.println(requestBody.getRequestBodyToJson());



    }
}