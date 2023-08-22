package net.project.reportgenerator.Service;
/* 
@author Sergey Ryadchikov
 */


import net.project.reportgenerator.Model.RequestBody;
import com.google.gson.Gson;
public class ConvertToJSON {
    public static String convert(RequestBody requestBody){
        Gson gson = new Gson();
        String json = gson.toJson(requestBody);
        return json;

    }
}
