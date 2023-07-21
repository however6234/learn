package com.citi.viktor.core.controller;

//help  to  add the  controller annotation as a rest controller and the request mapping annotation as /holiday
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//help  to  add the  controller annotation as a rest controller and the request mapping annotation as /holiday
@RestController
@RequestMapping({"/holiday"})
public class HolidayController {

    @autoWired
    private HolidayService holidayService;
    //help to add the api to get the holidays
    @RequestMapping({"/getHolidays"})
    public List<Holiday> getHolidays() {
        return holidayService.getHolidays();
    }
    //help to add the api to add the holidays
    @RequestMapping({"/addHoliday"})
    public void addHoliday(Holiday holiday) {
        holidayService.addHoliday(holiday);
    }
    //help to add the api to delete the holidays
    @RequestMapping({"/deleteHoliday"})
    public void deleteHoliday(String holidayName) {
        holidayService.deleteHoliday(holidayName);
    }
    //help to add the api to update the holidays
    @RequestMapping({"/updateHoliday"})
    public void updateHoliday(Holiday holiday) {
        holidayService.updateHoliday(holiday);
    }
    //help to add a api to get all the next year's holidays by country code
    @RequestMapping({"/getNextYearHolidaysByCountryCode"})
    public  String getNextYearHolidaysByCountryCode(String countryCode) {
        Gson gson = new Gson();
        List<Holiday>  holidays = holidayService.getNextYearHolidaysByCountryCode(countryCode);
        return gson.toJson(holidays);
    }
    //add a api to check if  the holiday already exists by country code and holiday name
    @RequestMapping({"/checkHolidayExists"})
    public boolean checkHolidayExists(String countryCode, String holidayName) {
        return holidayService.getHolidayByCountryCodeAndHolidayName(countryCode, holidayName) != null;
    }
    //add a api to get the next holiday upper than the current date by country code
    @RequestMapping({"/getNextHolidayByCountryCode"})
    public String getNextHolidayByCountryCode(String countryCode) {
        //format the  holiday result as json string
        Gson gson = new Gson();
        Holiday holiday  = holidayService.getNextHolidayByCountryCode(countryCode);
        return gson.toJson(holiday);
    }
}
