package com.urbanik.entity;

import com.urbanik.date.Date;

public class Departure {

    private Date date;
    private Airplane airplane;

    public Departure(Date date, Airplane airplane) {
        this.date = date;
        this.airplane = airplane;
    }
}
