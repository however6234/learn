package com.citi.viktor.core.dao;

import com.citi.viktor.core.entity.Holiday;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//help to add the  repository annotation
@Repository
//help to add the  dao class
public class HolidayDaoImpl implements HolidayDao{
    //define a  static  final string  for  the  csv file path C:\holiday.csv
    private static final String CSV_FILE_PATH = "C:\\holiday.csv";
    public List<Holiday> getHolidays() throws Exception {
        //help  to get all the  holidays  from the  csv file  using the  CSVWriter class
        CSVReader csvReader = new CSVReader(new FileReader(CSV_FILE_PATH));
        List<String[]> allData = csvReader.readAll();
        csvReader.close();
        List<Holiday> holidays = new ArrayList<>();
        for (String[] row : allData) {
            holidays.add(new Holiday(row[0], row[1], row[2], row[3]));
        }
        return holidays;
    }

    public void addHoliday(Holiday holiday)  throws Exception {
        //help  to add the  holiday  to the  csv file  using the  CSVWriter class
        String[] holidayData = {holiday.getCountryCode(), holiday.getCountryDesc(), holiday.getHolidayDate(), holiday.getHolidayName()};
        // check if holiday already exists with the same  country code and holiday name
        if (getHolidayByCountryCodeAndHolidayName(holiday.getCountryCode(), holiday.getHolidayName()) != null) {
            System.out.println("Holiday already exists");
            return;
        }
        CSVWriter csvWriter = new CSVWriter(new FileWriter(CSV_FILE_PATH, true));
        csvWriter.writeNext(holidayData);
        csvWriter.close();
    }

    public void deleteHoliday(String holidayName) throws Exception {
        //help to  delete the  holiday  from the  csv file  using the  CSVWriter class
        CSVReader csvReader = new CSVReader(new FileReader(CSV_FILE_PATH));
        List<String[]> allData = csvReader.readAll();
        csvReader.close();
        CSVWriter csvWriter = new CSVWriter(new FileWriter(CSV_FILE_PATH));
        for (String[] row : allData) {
            if (!row[3].equalsIgnoreCase(holidayName)) {
                csvWriter.writeNext(row);
            }
        }
        csvWriter.close();
    }


    public void updateHoliday(Holiday holiday) throws Exception {
        //help to  update the  holiday  from the  csv file  using the  CSVWriter class by country code and holiday name
        CSVReader csvReader = new CSVReader(new FileReader(CSV_FILE_PATH));
        List<String[]> allData = csvReader.readAll();
        csvReader.close();
        CSVWriter csvWriter = new CSVWriter(new FileWriter(CSV_FILE_PATH));
        for (String[] row : allData) {
            if (!row[0].equalsIgnoreCase(holiday.getCountryCode()) && !row[3].equalsIgnoreCase(holiday.getHolidayName())) {
                csvWriter.writeNext(row);
            } else {
                csvWriter.writeNext(new String[]{holiday.getCountryCode(), holiday.getCountryDesc(), holiday.getHolidayDate(), holiday.getHolidayName()});
            }
        }
        csvWriter.close();
    }


    public List<Holiday> getHolidayByCountryCode(String countryCode) throws Exception {
        //help to  get the  holiday  from the  csv file  using the  CSVWriter class
        CSVReader csvReader = new CSVReader(new FileReader(CSV_FILE_PATH));
        List<String[]> allData = csvReader.readAll();
        csvReader.close();
        List<Holiday> holidays = new ArrayList<>();
        for (String[] row : allData) {
            if (row[0].equalsIgnoreCase(countryCode)) {
                holidays.add(new Holiday(row[0], row[1], row[2], row[3]));
            }
        }
        return holidays;
    }

    public List<Holiday> getHolidayByCountryDesc(String countryDesc) throws Exception {
        //help to  get the  holiday by  countryDesc from the  csv file  using the  CSVWriter class
        CSVReader csvReader = new CSVReader(new FileReader(CSV_FILE_PATH));
        List<String[]> allData = csvReader.readAll();
        csvReader.close();
        List<Holiday> holidays = new ArrayList<>();
        for (String[] row : allData) {
            if (row[1].equalsIgnoreCase(countryDesc)) {
                holidays.add(new Holiday(row[0], row[1], row[2], row[3]));
            }
        }
        return holidays;
    }

    public List<Holiday> getHolidayByHolidayDateRange(String countryCode,String fromHolidayDate, String toHolidayDate) throws Exception {
        //help to get  the  holiday by countryCode and holidayDate range from the  csv file  using the  CSVWriter class, include  the fromHolidayDate and toHolidayDate
        CSVReader csvReader = new CSVReader(new FileReader(CSV_FILE_PATH));
        List<String[]> allData = csvReader.readAll();
        csvReader.close();
        List<Holiday> holidays = new ArrayList<>();
        for (String[] row : allData) {
            if (row[0].equalsIgnoreCase(countryCode) && row[2].compareTo(fromHolidayDate) >= 0 && row[2].compareTo(toHolidayDate) <= 0) {
                holidays.add(new Holiday(row[0], row[1], row[2], row[3]));
            }
        }
        return holidays;
    }

    public List<Holiday> getHolidayByHolidayName(String holidayName) throws Exception {
        //help to  get the  holiday by  holidayName from the  csv file  using the  CSVWriter class
        CSVReader csvReader = new CSVReader(new FileReader(CSV_FILE_PATH));
        List<String[]> allData = csvReader.readAll();
        csvReader.close();
        List<Holiday> holidays = new ArrayList<>();
        for (String[] row : allData) {
            if (row[3].equalsIgnoreCase(holidayName)) {
                holidays.add(new Holiday(row[0], row[1], row[2], row[3]));
            }
        }
        return holidays;
    }

    public Holiday getHolidayByCountryCodeAndHolidayName(String countryCode, String holidayName) throws Exception {
        //help to  get the  holiday  from the  csv file  using the  CSVWriter class
        CSVReader csvReader = new CSVReader(new FileReader(CSV_FILE_PATH));
        List<String[]> allData = csvReader.readAll();
        csvReader.close();
        for (String[] row : allData) {
            if (row[0].equalsIgnoreCase(countryCode) && row[3].equalsIgnoreCase(holidayName)) {
                return new Holiday(row[0], row[1], row[2], row[3]);
            }
        }
        return null;
    }
}
