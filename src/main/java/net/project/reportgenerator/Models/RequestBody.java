package net.project.reportgenerator.Models;
/* 
@author Sergey Ryadchikov
 */

import org.json.JSONObject;

public class RequestBody {
    private JSONObject requestBody = new JSONObject();

    public JSONObject getRequestBody() {
        return requestBody;
    }

    public void fillingRequestBody(String key, String value) {
        requestBody.accumulate(key, value);
    }
}
