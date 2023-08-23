package net.project.reportgenerator.Service;
/* 
@author Sergey Ryadchikov
 */

import java.util.LinkedList;
import java.util.List;

public class Parser {

    public static List<String[]> parseOfDataCSV(String data) {

        List<String[]> listOfBranches = new LinkedList<>();

        String[] listData = data.split("\n");

        for (int i = 1; i < listData.length; i++) {
            String[] branch = listData[i].split(",");
            listOfBranches.add(branch);
        }

        return listOfBranches;
    }

}
