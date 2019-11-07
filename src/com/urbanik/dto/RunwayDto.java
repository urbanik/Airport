package com.urbanik.dto;

import java.util.ArrayList;
import java.util.List;

public class RunwayDto {

    private int id;
    private int length;
    private List<AirplaneInSystemDto> history;

    public RunwayDto() {
    }

    public RunwayDto(int id) {
        this.id = id;
        this.length = 0;
        history = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<AirplaneInSystemDto> getHistory() {
        return history;
    }

    public void setHistory(List<AirplaneInSystemDto> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "Runway {" +
                "id = " + id +
                ", length = " + length +
                "} History:";
    }
}
