package net.project.reportgenerator.Exceptions;
/* 
@author Sergey Ryadchikov
 */

public class ValidationException extends NumberFormatException{
    public ValidationException(String s) {
        super(s);
    }
}
