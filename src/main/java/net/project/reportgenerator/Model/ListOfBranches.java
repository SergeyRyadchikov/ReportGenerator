package net.project.reportgenerator.Model;
/* 
@author Sergey Ryadchikov
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListOfBranches {
    private List<BranchData> listDeveloper = new LinkedList<>();

    public void addBranchDataToList(List<String[]> branches) {

        for (String[] branch : branches) {
            listDeveloper.add(new BranchData(
                    branch[1],
                    branch[2],
                    Integer.parseInt(branch[3]),
                    Integer.parseInt(branch[4]),
                    Integer.parseInt(branch[5]),
                    Integer.parseInt(branch[7]),
                    Integer.parseInt(branch[8]),
                    Integer.parseInt(branch[9])
            ));

        }
    }


    public List<BranchData> getSortListDeveloper() {
        Collections.sort(listDeveloper);
        return listDeveloper;
    }
}
