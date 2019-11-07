package com.urbanik.date;

public class Date implements Comparable<Date>{

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

    public int getHours() {
        return hours;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
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

    @Override
    public int compareTo(Date o) {


        if(this.getHours() < o.getHours()){ // AK JE VACSIA HODNOTA, TEDA NIZSIA PRIORITA

            return -1;

        } else{ // AK JE MENSIA HODNOTA, TEDA VYSSIA PRIORITA

            return 1;

        }
    }
}
