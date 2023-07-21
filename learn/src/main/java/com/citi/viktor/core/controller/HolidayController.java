package com.citi.viktor.core.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
//help  to  add the  controller annotation as a rest controller and the request mapping annotation as /holiday
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.viktor.core.entity.Holiday;
import com.citi.viktor.core.service.HolidayService;
import com.google.gson.Gson;

//help  to  add the  controller annotation as a rest controller and the request mapping annotation as /holiday
@RestController
@RequestMapping({"/holiday"})
public class HolidayController {

	@Autowired
    private HolidayService holidayService;
    //help to add the api to get the holidays
    @RequestMapping({"/getHolidays"})
    public List<Holiday> getHolidays() {
        try {
			return holidayService.getHolidays();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return Collections.EMPTY_LIST;
    }
    //help to add the api to add the holidays
    @RequestMapping({"/addHoliday"})
    public void addHoliday(Holiday holiday) {
        try {
			holidayService.addHoliday(holiday);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    //help to add the api to delete the holidays
    @RequestMapping({"/deleteHoliday"})
    public void deleteHoliday(String holidayName) {
        try {
			holidayService.deleteHoliday(holidayName);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    //help to add the api to update the holidays
    @RequestMapping({"/updateHoliday"})
    public void updateHoliday(Holiday holiday) {
        try {
			holidayService.updateHoliday(holiday);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    //help to add a api to get all the next year's holidays by country code
    @RequestMapping({"/getNextYearHolidaysByCountryCode"})
    public  String getNextYearHolidaysByCountryCode(String countryCode) {
        Gson gson = new Gson();
        List<Holiday> holidays;
		try {
			holidays = holidayService.getNextYearHolidaysByCountryCode(countryCode);
			return gson.toJson(holidays);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  StringUtils.EMPTY;
    }
    //add a api to check if  the holiday already exists by country code and holiday name
    @RequestMapping({"/checkHolidayExists"})
    public boolean checkHolidayExists(String countryCode, String holidayName) {
        try {
			return holidayService.getHolidayByCountryCodeAndHolidayName(countryCode, holidayName) != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return false;
    }
    //add a api to get the next holiday upper than the current date by country code
    @RequestMapping({"/getNextHolidayByCountryCode"})
    public String getNextHolidayByCountryCode(String countryCode) {
        //format the  holiday result as json string
        Gson gson = new Gson();
		try {
			Holiday holiday = holidayService.getNextHolidayByCountryCode(countryCode);
			return gson.toJson(holiday);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StringUtils.EMPTY;
    }
}
