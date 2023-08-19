package net.project.reportgenerator.Model;
/* 
@author Sergey Ryadchikov
 */

import net.project.reportgenerator.View.ViewOfInput;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class RequestBody {
    private final List<String> projects = Arrays.asList("SCPL");
    private String fromDate;
    private String toDate;

    private JSONObject requestBodyToJson = new JSONObject();

    public RequestBody() {
        this.fromDate = ViewOfInput.fromDate();
        this.toDate = ViewOfInput.toDate();
        fillingRequestBody();
    }

    public JSONObject getRequestBodyToJson() {
        return requestBodyToJson;
    }

    public void fillingRequestBody() {
        requestBodyToJson.accumulate("projects", projects);
        requestBodyToJson.accumulate("from_date", fromDate);
        requestBodyToJson.accumulate("to_date", toDate);
    }
}
