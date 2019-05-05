package com.example.fishx.todolist;

import java.util.Date;

public class plan {
    String planadi;
    Date deadline;
    int id;

    public String getPlanadi(){
        return planadi;
    }

    public Date getDeadline(){
        return deadline;
    }

    public void setPlanadi(String planadi){
        this.planadi=planadi;
    }

    public void setDeadline(Date deadline){
        this.deadline=deadline;
    }

    public int getId(){
        return id;
    }

}
