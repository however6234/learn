package com.citi.viktor.core.dao;

import java.io.IOException;
import java.util.List;

import com.citi.viktor.core.entity.Holiday;


public interface HolidayDao {
    //help to add the method to get the holidays ,the method to add the holidays, the method to delete the holidays and themethod to update the holidays
    public List<Holiday> getHolidays() throws Exception;

    public void addHoliday(Holiday holiday) throws Exception;

    public void deleteHoliday(String holidayName) throws Exception;

    public void updateHoliday(Holiday holiday) throws Exception;

    //help to add the method to get the holiday by contryCode   or countryDesc    or  holidayDate range  or holidayName
    public List<Holiday> getHolidayByCountryCode(String countryCode) throws Exception;

    public List<Holiday> getHolidayByCountryDesc(String countryDesc) throws Exception;

    public List<Holiday> getHolidayByHolidayDateRange(String countryCode,String fromHolidayDate, String toHolidayDate) throws Exception;

    public List<Holiday> getHolidayByHolidayName(String holidayName) throws Exception;
    // add a  method to get the holiday by country code and holiday name
    public Holiday getHolidayByCountryCodeAndHolidayName(String countryCode, String holidayName) throws Exception;

}
