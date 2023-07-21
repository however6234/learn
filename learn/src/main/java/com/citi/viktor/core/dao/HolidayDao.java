package com.citi.viktor.core.dao;

public interface HolidayDao {
    //help to add the method to get the holidays ,the method to add the holidays, the method to delete the holidays and themethod to update the holidays
    public List<Holiday> getHolidays();

    public void addHoliday(Holiday holiday);

    public void deleteHoliday(String holidayName);

    public void updateHoliday(Holiday holiday);

    //help to add the method to get the holiday by contryCode   or countryDesc    or  holidayDate range  or holidayName
    public List<Holiday> getHolidayByCountryCode(String countryCode);

    public List<Holiday> getHolidayByCountryDesc(String countryDesc);

    public List<Holiday> getHolidayByHolidayDateRange(String countryCode,String fromHolidayDate, String toHolidayDate);

    public List<Holiday> getHolidayByHolidayName(String holidayName);
    // add a  method to get the holiday by country code and holiday name
    public Holiday getHolidayByCountryCodeAndHolidayName(String countryCode, String holidayName);

}
