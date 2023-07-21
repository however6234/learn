package com.citi.viktor.core.service;

import java.util.List;

import com.citi.viktor.core.entity.Holiday;

public interface HolidayService {
    //help to add a api to get the holidays
public List<Holiday> getHolidays() throws Exception ;
//help to add a api to add the holidays
public void addHoliday(Holiday holiday) throws Exception ;
//help to add a api to delete the holidays
public void deleteHoliday(String holidayName) throws Exception ;
//help to add a api to update the holidays
public void updateHoliday(Holiday holiday) throws Exception ;
//help to add a api to get the holiday by contryCode   or countryDesc    or  holidayDate range  or holidayName
public List<Holiday> getHolidayByCountryCode(String countryCode) throws Exception ;
//help to  add a  api to get the holiday by countryDesc
public List<Holiday> getHolidayByCountryDesc(String countryDesc) throws Exception ;
//help to  add  a  api  to get  the  holiday by holidayDate range
public List<Holiday> getHolidayByHolidayDateRange(String countryCode,String fromHolidayDate, String toHolidayDate) throws Exception ;
//help  to add  a api   to get the  holiday by holidayName
public List<Holiday> getHolidayByHolidayName(String holidayName) throws Exception ;
//help to add a api to get the holiday by country code and holiday name
public Holiday getHolidayByCountryCodeAndHolidayName(String countryCode, String holidayName) throws Exception ;

//add a  method getNextYearHolidaysByCountryCode
public List<Holiday> getNextYearHolidaysByCountryCode(String countryCode) throws Exception ;
public Holiday getNextHolidayByCountryCode(String countryCode) throws Exception ;
}
