package net.project.reportgenerator.API;
/* 
@author Sergey Ryadchikov
 */

import net.project.reportgenerator.Model.RequestBody;

import java.io.IOException;
import java.net.URISyntaxException;

public interface Request {
    public String sendRequest(RequestBody requestBody) throws URISyntaxException, IOException, InterruptedException;
}
