package com.citi.viktor.core.entity;

public class Holiday {
    //help to add  fields countryCode,countryDesc, holidayDate, holidayName with their getters and setters
    private String countryCode;
    private String countryDesc;
    private String holidayDate;
    private String holidayName;

    public Holiday() {
    }

    public Holiday(String countryCode, String countryDesc, String holidayDate, String holidayName) {
        this.countryCode = countryCode;
        this.countryDesc = countryDesc;
        this.holidayDate = holidayDate;
        this.holidayName = holidayName;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCountryDesc() {
        return this.countryDesc;
    }

    public String getHolidayDate() {
        return this.holidayDate;
    }

    public String getHolidayName() {
        return this.holidayName;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryDesc(String countryDesc) {
        this.countryDesc = countryDesc;
    }

    public void setHolidayDate(String holidayDate) {
        this.holidayDate = holidayDate;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public String toString() {
        return "Holiday(countryCode=" + this.getCountryCode() + ", countryDesc=" + this.getCountryDesc() + ", holidayDate=" + this.getHolidayDate() + ", holidayName=" + this.getHolidayName() + ")";
    }
}
