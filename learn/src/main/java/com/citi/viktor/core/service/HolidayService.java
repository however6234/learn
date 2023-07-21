package com.citi.viktor.core.service;

public interface HolidayService {
    //help to add a api to get the holidays
public List<Holiday> getHolidays();
//help to add a api to add the holidays
public void addHoliday(Holiday holiday);
//help to add a api to delete the holidays
public void deleteHoliday(String holidayName);
//help to add a api to update the holidays
public void updateHoliday(Holiday holiday);
//help to add a api to get the holiday by contryCode   or countryDesc    or  holidayDate range  or holidayName
public List<Holiday> getHolidayByCountryCode(String countryCode);
//help to  add a  api to get the holiday by countryDesc
public List<Holiday> getHolidayByCountryDesc(String countryDesc);
//help to  add  a  api  to get  the  holiday by holidayDate range
public List<Holiday> getHolidayByHolidayDateRange(String fromHolidayDate, String toHolidayDate);
//help  to add  a api   to get the  holiday by holidayName
public List<Holiday> getHolidayByHolidayName(String holidayName);
//help to add a api to get the holiday by country code and holiday name
public Holiday getHolidayByCountryCodeAndHolidayName(String countryCode, String holidayName);

//add a  method getNextYearHolidaysByCountryCode
public List<Holiday> getNextYearHolidaysByCountryCode(String countryCode);
public Holiday getNextHolidayByCountryCode(String countryCode);
}
