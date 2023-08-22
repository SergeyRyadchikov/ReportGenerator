package net.project.reportgenerator.Model;
/* 
@author Sergey Ryadchikov
 */

import net.project.reportgenerator.View.ViewOfInput;

public class RequestBody {
    public String[] projects = {"SCPL"};
    public String fromDate;
    public String toDate;

    public RequestBody() {
        this.fromDate = ViewOfInput.fromDate();
        this.toDate = ViewOfInput.toDate();
    }
}
