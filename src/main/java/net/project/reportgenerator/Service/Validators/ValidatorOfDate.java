package net.project.reportgenerator.Service.Validators;
/* 
@author Sergey Ryadchikov
 */


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Arrays;

public class ValidatorOfDate {

/*  Метод принимает введенную строку и проверяет:
    1. Длина строки 10 символов
    2. Первые 4 символа являются числом, которое не больше текущего года
    3. 5-й и 8-й символ '-'
    4. 6-й и 7-й символы - число, которое не превышает 12
    6. 9-й и 10-й символ - число, которое не превышает
        - 31 для 01, 03, 05, 07, 08, 10 и 12 месяца,
        - 30 для 04, 06, 09 и 11 месяца,
        - 29 для 02 месяца

 */
    public static Boolean isValid(String date){
        if (date.length() == 10){
          try{
              int year = Integer.parseInt(date.substring(0, 4));
              if(year <= LocalDate.now().getYear()){
                  if(date.charAt(4) == '-' && date.charAt(7) == '-'){
                      try{
                          int months = Integer.parseInt(date.substring(5, 7));
                          if(months <= 12 && months > 0){
                              try{
                                  int day = Integer.parseInt(date.substring(8, 10));
                                  if(Arrays.asList(1, 3, 5, 7, 8, 10, 12).contains(months)){
                                      if (day > 0 && day <= 31){
                                          return true;
                                      } else return false;
                                  } else if (Arrays.asList(4, 6, 9, 11).contains(months)){
                                      if (day > 0 && day <= 30){
                                          return true;
                                      } else return false;
                                  } else {
                                      if (day > 0 && day <= 29){
                                          return true;
                                      } else return false;
                                  }
                              } catch (NumberFormatException numException){
                                  numException.getMessage();
                                  return false;
                              }
                          } else return false;
                      } catch (NumberFormatException numException){
                          numException.getMessage();
                          return false;
                      }
                  } else return false;
              } else return false;
          } catch (NumberFormatException numException){
              numException.getMessage();
              return false;
          }
        } else return false;
    }

    /*
    Метод валидации даты по заданному формату. Используются методы из встроенной библиотеки java.time.format
    Основное преимущество - умеет определять количество дней в феврале, в зависимости от выбранного года
     */
    public static boolean isValidFromJava(String date) {
        boolean valid = false;
        try {
            // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
            LocalDate.parse(date,
                    DateTimeFormatter.ofPattern("uuuu-M-d")
                            .withResolverStyle(ResolverStyle.STRICT)
            );
            valid = true;
        } catch (DateTimeParseException e) {
            valid = false;
        }
        return valid;
    }
}
