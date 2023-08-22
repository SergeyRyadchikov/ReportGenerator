package net.project.reportgenerator.Model;
/* 
@author Sergey Ryadchikov
 */

public class BranchData implements Comparable<BranchData> {
    private String devName;
    private String branch;
    private int countOfChanges;
    private int countOfThreads;
    private int storyPoints;
    private int spentTime;
    private int reviewIntoExecution;
    private int testingIntoExecution;

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getCountOfChanges() {
        return countOfChanges;
    }

    public void setCountOfChanges(int countOfChanges) {
        this.countOfChanges = countOfChanges;
    }

    public int getCountOfThreads() {
        return countOfThreads;
    }

    public void setCountOfThreads(int countOfThreads) {
        this.countOfThreads = countOfThreads;
    }

    public int getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(int storyPoints) {
        this.storyPoints = storyPoints;
    }

    public int getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(int spentTime) {
        this.spentTime = spentTime;
    }

    public int getReviewIntoExecution() {
        return reviewIntoExecution;
    }

    public void setReviewIntoExecution(int reviewIntoExecution) {
        this.reviewIntoExecution = reviewIntoExecution;
    }

    public int getTestingIntoExecution() {
        return testingIntoExecution;
    }

    public void setTestingIntoExecution(int testingIntoExecution) {
        this.testingIntoExecution = testingIntoExecution;
    }

    @Override
    public int compareTo(BranchData branchData) {
        int devNameCompare = devName.compareTo(branchData.devName);
        if (devNameCompare != 0){
            return devNameCompare;
        } else return 0;
    }
}
