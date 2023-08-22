package net.project.reportgenerator.Service.Validators;
/* 
@author Sergey Ryadchikov
 */


import net.project.reportgenerator.Exceptions.ValidationException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.regex.Pattern;

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
    public static Boolean isValid(String date) {
        if (isValidFormatDate(date) && isValidYear(date) && isValidMonths(date) && isValidDay(date)){
            return true;
        }else return false;
        /*
        if (isValidFormatDate(date)) {
            try {
                int year = Integer.parseInt(date.substring(0, 4));
                if (year <= LocalDate.now().getYear()) {
                    if (date.charAt(4) == '-' && date.charAt(7) == '-') {
                        try {
                            int months = Integer.parseInt(date.substring(5, 7));
                            if (months <= 12 && months > 0) {
                                try {
                                    int day = Integer.parseInt(date.substring(8, 10));
                                    if (Arrays.asList(1, 3, 5, 7, 8, 10, 12).contains(months)) {
                                        if (day > 0 && day <= 31) {
                                            return true;
                                        } else return false;
                                    } else if (Arrays.asList(4, 6, 9, 11).contains(months)) {
                                        if (day > 0 && day <= 30) {
                                            return true;
                                        } else return false;
                                    } else {
                                        if (day > 0 && day <= 29) {
                                            return true;
                                        } else return false;
                                    }
                                } catch (NumberFormatException numException) {
                                    numException.getMessage();
                                    return false;
                                }
                            } else return false;
                        } catch (NumberFormatException numException) {
                            numException.getMessage();
                            return false;
                        }
                    } else return false;
                } else return false;
            } catch (NumberFormatException numException) {
                numException.getMessage();
                return false;
            }
        } else return false;*/
    }


    /*
    Метод валидации даты по заданному формату. Используются методы из встроенной библиотеки java.time.format
    Основное преимущество - умеет определять количество дней в феврале, в зависимости от выбранного года
    Недостаток - е обрабатывает, если указать букву вместо одной из цифр, необходимо дополнительно обратботать.

    public static Boolean isValidFromJava(String date) {
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
*/


    private static Boolean isValidFormatDate(String date) {
        final String FORMAT = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        if (Pattern.matches(FORMAT, date)) {
            return true;
        } else {
            System.out.println("Неверный формат даты!");
            return false;
        }
    }

    private static Boolean isValidYear(String date) {
        int year = getYear(date);
        if (year <= LocalDate.now().getYear() && year > 0) {
            return true;
        } else {
            System.out.println("Неверно указан год!");
            return false;
        }
    }



    private static Boolean isValidMonths(String date) {
            if (getMonths(date) <= 12 && getMonths(date) > 0) {
                return true;
            } else {
                System.out.println("Неверно указан месяц!");
                return false;
            }
        }


    private static boolean isValidDay(String date) {
            int months = getMonths(date);
            int day = getDay(date);
            if (Arrays.asList(1, 3, 5, 7, 8, 10, 12).contains(months)) {
                if (day > 0 && day <= 31) {
                    return true;
                } else {
                    System.out.println("Неверно указан день! В указанном месяце 31 день!");
                    return false;
                }
            } else if (Arrays.asList(4, 6, 9, 11).contains(months)) {
                if (day > 0 && day <= 30) {
                    return true;
                } else {
                    System.out.println("Неверно указан день! В указанном месяце 30 дней!");
                    return false;
                }
            } else {
                if ((getYear(date) % 4) == 0) {
                    if (day > 0 && day <= 29) {
                        return true;
                    } else {
                        System.out.println("Неверно указан день! В указанном месяце 29 дней!");
                        return false;
                    }
                } else {
                    if (day > 0 && day <= 28) {
                        return true;
                    } else{
                        System.out.println("Неверно указан день! В указанном месяце 28 дней!");
                        return false;
                    }
            }
        }
    }

    private static int getYear(String date) {
        try {
            int year = Integer.parseInt(date.substring(0, 4));
            return year;
        } catch (ValidationException vException) {
            throw new ValidationException("Неверно указан год");
        }
    }

    private static int getMonths(String date) {
        try {
            int months = Integer.parseInt(date.substring(5, 7));
            return months;
        } catch (ValidationException vException) {
            throw new ValidationException("Неверно указан месяц");
        }
    }

    private static int getDay(String date) {
        try {
            int day = Integer.parseInt(date.substring(8, 10));
            return day;
        } catch (ValidationException vException) {
            throw new ValidationException("Неверно указан день");
        }
    }
}
