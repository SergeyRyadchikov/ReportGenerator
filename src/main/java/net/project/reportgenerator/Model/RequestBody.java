package net.project.reportgenerator.Model;
/* 
@author Sergey Ryadchikov
 */

import net.project.reportgenerator.View.ViewOfInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RequestBody {

    private HashMap<String, Object> dataForRequestBody = new HashMap<>();
    private List<String> projects = new ArrayList<>(Arrays.asList("SCPL"));
    private String fromDate;
    private String toDate;

    public RequestBody() {
        this.fromDate = ViewOfInput.fromDate();
        this.toDate = ViewOfInput.toDate();
    }

    private void fillingMap(){
        dataForRequestBody.put("projects", projects);
        dataForRequestBody.put("from_date", fromDate);
        dataForRequestBody.put("to_date", toDate);
    }

    public HashMap<String, Object> getDataForRequestBody() {
        fillingMap();
        return dataForRequestBody;
    }
}
