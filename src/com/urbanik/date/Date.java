package com.urbanik.date;

public class Date {

    private int hours;
    private int day;
    private int month;
    private int year;

    public Date( int hours, int day, int month, int year) {

        this.hours = hours;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void addHour(){

        if(this.hours == 23){
            this.hours = 0;
            this.day++;
        }else if(this.day == 30){
            this.day = 1;
            this.month++;
        }else if(this.month == 12){
            this.month = 1;
            this.year++;
        }else{
            this.hours++;
        }
    }

    @Override
    public String toString() {
        return  this.hours +":00 "+ day +
                "-" + month +
                "-" + year;
    }
}
