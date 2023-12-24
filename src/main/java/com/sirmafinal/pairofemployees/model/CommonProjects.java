package com.sirmafinal.pairofemployees.model;

public class CommonProjects {
    private int emp1ID;
    private int emp2ID;
    private int projectId;
    private long duration;

    public CommonProjects(int emp1ID, int emp2ID, int projectId, long duration) {
        this.emp1ID = emp1ID;
        this.emp2ID = emp2ID;
        this.projectId = projectId;
        this.duration = duration;
    }


    public int getEmp1ID() {
        return emp1ID;
    }

    public void setEmp1ID(int emp1) {
        this.emp1ID = emp1;
    }

    public int getEmp2ID() {
        return emp2ID;
    }

    public void setEmp2ID(int emp2) {
        this.emp2ID = emp2;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

}
