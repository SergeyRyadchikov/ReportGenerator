package net.project.reportgenerator.API;
/* 
@author Sergey Ryadchikov
 */

import net.project.reportgenerator.Model.RequestBody;
import net.project.reportgenerator.Service.ConvertToJSON;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.apache.http.Consts.UTF_8;

public class ReportForThePeriod implements Request {

    private String protocol = "http://";
    private String domain = "185.63.188.199:8008";
    private String endPoint = "/reports/on-completed-tasks/";

    private String url = protocol + domain + endPoint;


    @Override
    public String sendRequest(RequestBody requestBody) throws URISyntaxException, IOException, InterruptedException {
        String JSON = ConvertToJSON.convert(requestBody.getDataForRequestBody());
        URI uri = new URI(url);
        HttpClient HttpClient = java.net.http.HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(uri).POST(HttpRequest.BodyPublishers.ofString(JSON)).header("Content-type", "text/csv").build();
        var response = HttpClient.send(request, responseInfo -> HttpResponse.BodySubscribers.mapping(HttpResponse.BodySubscribers.ofString(UTF_8), String::getBytes));

        if (response.statusCode() == 200){
            String result = new String(response.body());
            return result;
        } else {
            return ("fail: " + response.statusCode() + "\n" + "message: " + new String(response.body()));
        }
    }
}
