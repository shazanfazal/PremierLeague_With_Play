package models;

import java.io.Serializable;

public class DateAndTime implements Serializable, Comparable<DateAndTime>{  //this has serializable is because the match class is being save and it has the class as a data type so this is serialized

    private int dayOfTheMonth;
    private int monthOfTheYear;
    private int year;
    private int hourOfTheDay;
    private int minutesOfTheDay;

    //default constructor
    public DateAndTime(){

    }

    //parameterized constructor
    public DateAndTime(int dayOfTheMonth, int monthOfTheYear, int year, int hourOfTheDay, int minutesOfTheDay){
        setDayOfTheMonth(dayOfTheMonth);
        setMonthOfTheYear(monthOfTheYear);
        setYear(year);
        setHourOfTheDay(hourOfTheDay);
        setMinutesOfTheDay(minutesOfTheDay);
    }


    //getters for the instance variable
    public int getDayOfTheMonth(){
        return this.dayOfTheMonth;
    }

    public int getMonthOfTheYear(){
        return this.monthOfTheYear;
    }

    public int getYear(){
        return this.year;
    }

    public int getHourOfTheDay(){
        return this.hourOfTheDay;
    }

    public int getMinutesOfTheDay(){
        return this.minutesOfTheDay;
    }


    //setters for instance variables
    public void setDayOfTheMonth(int dayOfTheMonth){
        if(dayOfTheMonth <= 0 || dayOfTheMonth >= 32){
            throw new IllegalArgumentException(" The Date cant be less than 0 or more than 31");

        }else{
            this.dayOfTheMonth = dayOfTheMonth;
        }
    }

    public void setMonthOfTheYear(int monthOfTheYear){
        if(monthOfTheYear <= 0 || monthOfTheYear >= 13){
            throw new IllegalArgumentException(" The month cant be less than 0 or more than 12");
        }else{
            this.monthOfTheYear = monthOfTheYear;
        }
    }

    public void setYear(int year){
        if(year <= 2012 || year >= 2025){
            throw new IllegalArgumentException(" The year should be greater than 2012");
        }else{
            this.year = year;
        }

    }

    public void setHourOfTheDay(int hourOfTheDay){
        if(hourOfTheDay <= 0 || hourOfTheDay >= 25){
            throw new IllegalArgumentException(" The hour should be in between 1-24");
        }else{
            this.hourOfTheDay = hourOfTheDay;
        }
    }

    public void setMinutesOfTheDay(int minutesOfTheDay){
        if(minutesOfTheDay <= -1 || minutesOfTheDay >= 61){
            throw new IllegalArgumentException(" The Minutes cant be more than 60 or less than 0");
        }else{
            this.minutesOfTheDay = minutesOfTheDay;
        }
    }

    //to compare changing to minutes
    public int getChangeToMinutes(){
        return ((this.year * 365 * 24 * 60) + (this.monthOfTheYear * 30 * 24 * 60) + (this.dayOfTheMonth * 24 * 60) + (this.hourOfTheDay * 60) + this.minutesOfTheDay);
    }



    @Override
    public String toString(){
        return "Date: "+ this.dayOfTheMonth + "-" + this.monthOfTheYear + "-" + this.year + " Time: " + this.hourOfTheDay + ":" + this.minutesOfTheDay;
    }

    @Override
    public int compareTo(DateAndTime otherObj){
        return (this.getChangeToMinutes() - otherObj.getChangeToMinutes());
    }
}
