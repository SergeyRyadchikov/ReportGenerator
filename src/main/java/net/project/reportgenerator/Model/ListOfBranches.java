package net.project.reportgenerator.Model;
/* 
@author Sergey Ryadchikov
 */

import java.util.Comparator;
import java.util.LinkedList;

public class ListOfBranches implements Comparator<BranchData> {
    private LinkedList<BranchData> listDeveloper = new LinkedList<>();


    @Override
    public int compare(BranchData o1, BranchData o2) {
        return 0;
    }
}
