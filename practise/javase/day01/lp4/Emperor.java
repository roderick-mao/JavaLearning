package javase.day01.lp4;

import java.time.Period;

public class Emperor {
     private String name;
     private Period reign;
     private String record;
     private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public void setReign(Period reign) {
        this.reign = reign;
    }

    public Period getReign() {
        return reign;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getRecord() {
        return record;
    }

    @Override
    public String toString() {
        return name+"皇帝在位"+reign.getYears()+"年"+reign.getMonths()+"月"+reign.getDays()+"天,"+"主要政绩："+record+","+description;
    }
}
