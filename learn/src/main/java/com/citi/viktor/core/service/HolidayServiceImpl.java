package com.citi.viktor.core.service;

//help to add the service annotation
import com.citi.viktor.core.dao.HolidayDao;
import com.citi.viktor.core.entity.Holiday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//help to add the service annotation
@Service
public class HolidayServiceImpl implements HolidayService{

    @Autowired
    private HolidayDao holidayDao;

    //implement all the  methods by calling holidayDao methods
    public List<Holiday> getHolidays() throws Exception {
        return holidayDao.getHolidays();
    }

    public void addHoliday(Holiday holiday) throws Exception  {
        holidayDao.addHoliday(holiday);
    }

    public void deleteHoliday(String holidayName) throws Exception  {
        holidayDao.deleteHoliday(holidayName);
    }

    public void updateHoliday(Holiday holiday)  throws Exception {
        holidayDao.updateHoliday(holiday);
    }

    public List<Holiday> getHolidayByCountryCode(String countryCode) throws Exception  {
        return holidayDao.getHolidayByCountryCode(countryCode);
    }

    public List<Holiday> getHolidayByCountryDesc(String countryDesc)  throws Exception {
        return holidayDao.getHolidayByCountryDesc(countryDesc);
    }

    public List<Holiday> getHolidayByHolidayDateRange(String countryCode,String fromHolidayDate, String toHolidayDate)  throws Exception {
        return holidayDao.getHolidayByHolidayDateRange(countryCode,fromHolidayDate, toHolidayDate);
    }

    public List<Holiday> getHolidayByHolidayName(String holidayName)  throws Exception {
        return holidayDao.getHolidayByHolidayName(holidayName);
    }

    public Holiday getHolidayByCountryCodeAndHolidayName(String countryCode, String holidayName) throws Exception {
        return holidayDao.getHolidayByCountryCodeAndHolidayName(countryCode, holidayName);
    }
    //implement the method  getNextYearHolidaysByCountryCode
    public List<Holiday> getNextYearHolidaysByCountryCode(String countryCode) throws Exception {
    	LocalDateTime  localDateTime = LocalDateTime.now();
       //help  to  get next  year's first day  fo  by using the  LocalDateTime class
        LocalDateTime firstDateTime = LocalDateTime.now().plusYears(1).withDayOfYear(1);
            //format the  firstDateTime  to  yyyy-MM-dd
        String fromHolidayDate = firstDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int year = localDateTime.getYear();
        int daysCnt = 365;
        if ((year%4==0&&year%100!=0)||year%400==0){
        	daysCnt=366;
        }
        //help to  get the  next year's  last   day  of  the  week
        LocalDateTime lastDateTime = LocalDateTime.now().withDayOfYear(daysCnt);
        //format the  lastDateTime  to  yyyy-MM-dd
        String toHolidayDate = lastDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return holidayDao.getHolidayByHolidayDateRange(countryCode, fromHolidayDate, toHolidayDate);
    }
    public Holiday getNextHolidayByCountryCode(String countryCode) throws Exception {
    	LocalDateTime  localDateTime = LocalDateTime.now();
        //help  to  get the  current  date  by using the  LocalDateTime class
        //format the  localDateTime  to  yyyy-MM-dd
        String fromHolidayDate = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        int year = localDateTime.getYear();
        int daysCnt = 365;
        if ((year%4==0&&year%100!=0)||year%400==0){
        	daysCnt=366;
        }
        LocalDateTime lastDateTime = localDateTime.withDayOfYear(daysCnt);
        //format the  lastDateTime  to  yyyy-MM-dd
        String toHolidayDate = lastDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //help to  get the  next  holiday  by  country code  and  holiday date range
        List<Holiday> holidays = holidayDao.getHolidayByHolidayDateRange(countryCode, fromHolidayDate, toHolidayDate);
        //help to sort the  holidays  by  holiday date  and return the first holiday
        if (holidays != null && holidays.size() > 0) {
            Collections.sort(holidays, new Comparator<Holiday>() {
                public int compare(Holiday o1, Holiday o2) {
                    return o1.getHolidayDate().compareTo(o2.getHolidayDate());
                }
            });
            return holidays.get(0);
        }
        return null;
    }
}
