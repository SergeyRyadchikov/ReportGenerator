package net.project.reportgenerator.Model;
/* 
@author Sergey Ryadchikov
 */

public class BranchData implements Comparable<BranchData> {
    private String branch;
    private String devName;
    private int countOfChanges;
    private int countOfThreads;
    private int storyPoints;
    private int spentTime;
    private int reviewIntoExecution;
    private int testingIntoExecution;

    public BranchData(String branch, String devName, int countOfChanges, int countOfThreads,
                      int storyPoints, int spentTime, int reviewIntoExecution, int testingIntoExecution) {
        this.branch = branch;
        this.devName = devName;
        this.countOfChanges = countOfChanges;
        this.countOfThreads = countOfThreads;
        this.storyPoints = storyPoints;
        this.spentTime = spentTime;
        this.reviewIntoExecution = reviewIntoExecution;
        this.testingIntoExecution = testingIntoExecution;
    }

    public String getDevName() {
        return devName;
    }


    public String getBranch() {
        return branch;
    }


    public int getCountOfChanges() {
        return countOfChanges;
    }


    public int getCountOfThreads() {
        return countOfThreads;
    }


    public int getStoryPoints() {
        return storyPoints;
    }


    public int getSpentTime() {
        return spentTime;
    }


    public int getReviewIntoExecution() {
        return reviewIntoExecution;
    }


    public int getTestingIntoExecution() {
        return testingIntoExecution;
    }


    @Override
    public int compareTo(BranchData branchData) {
        int devNameCompare = devName.compareTo(branchData.devName);
        if (devNameCompare != 0) {
            return devNameCompare;
        } else return 0;
    }

    @Override
    public String toString() {
        return "BranchData{" +
                "branch='" + branch + '\'' +
                ", devName='" + devName + '\'' +
                ", countOfChanges=" + countOfChanges +
                ", countOfThreads=" + countOfThreads +
                ", storyPoints=" + storyPoints +
                ", spentTime=" + spentTime +
                ", reviewIntoExecution=" + reviewIntoExecution +
                ", testingIntoExecution=" + testingIntoExecution +
                '}';
    }
}
