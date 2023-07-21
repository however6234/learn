package com.citi.viktor.core.service;

//help to add the service annotation
import com.citi.viktor.core.dao.HolidayDao;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

//help to add the service annotation
@Service
public class HolidayServiceImpl implements HolidayService{

    @Autowired
    private HolidayDao holidayDao;

    //implement all the  methods by calling holidayDao methods
    public List<Holiday> getHolidays() {
        return holidayDao.getHolidays();
    }

    public void addHoliday(Holiday holiday) {
        holidayDao.addHoliday(holiday);
    }

    public void deleteHoliday(String holidayName) {
        holidayDao.deleteHoliday(holidayName);
    }

    public void updateHoliday(Holiday holiday) {
        holidayDao.updateHoliday(holiday);
    }

    public List<Holiday> getHolidayByCountryCode(String countryCode) {
        return holidayDao.getHolidayByCountryCode(countryCode);
    }

    public List<Holiday> getHolidayByCountryDesc(String countryDesc) {
        return holidayDao.getHolidayByCountryDesc(countryDesc);
    }

    public List<Holiday> getHolidayByHolidayDateRange(String fromHolidayDate, String toHolidayDate) {
        return holidayDao.getHolidayByHolidayDateRange(fromHolidayDate, toHolidayDate);
    }

    public List<Holiday> getHolidayByHolidayName(String holidayName) {
        return holidayDao.getHolidayByHolidayName(holidayName);
    }

    public Holiday getHolidayByCountryCodeAndHolidayName(String countryCode, String holidayName) {
        return holidayDao.getHolidayByCountryCodeAndHolidayName(countryCode, holidayName);
    }
    //implement the method  getNextYearHolidaysByCountryCode
    public List<Holiday> getNextYearHolidaysByCountryCode(String countryCode) {
       //help  to  get next  year's first day  fo  by using the  LocalDateTime class
        LocalDateTime firstDateTime = LocalDateTime.now().plusYears(1).withDayOfYear(1);
            //format the  firstDateTime  to  yyyy-MM-dd
        String fromHolidayDate = firstDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //help to  get the  next year's  last   day  of  the  week
        LocalDateTime lastDateTime = localDateTime.withDayOfYear(localDateTime.lengthOfYear());
        //format the  lastDateTime  to  yyyy-MM-dd
        String toHolidayDate = lastDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return holidayDao.getHolidayByHolidayDateRange(countryCode, fromHolidayDate, toHolidayDate);
    }
    public Holiday getNextHolidayByCountryCode(String countryCode){
        //help  to  get the  current  date  by using the  LocalDateTime class
        LocalDateTime localDateTime = LocalDateTime.now();
        //format the  localDateTime  to  yyyy-MM-dd
        String fromHolidayDate = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        LocalDateTime lastDateTime = localDateTime.withDayOfYear(localDateTime.lengthOfYear());
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
