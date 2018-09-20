package com.country.validator.service.countryvalidatorservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.country.validator.service.countryvalidatorservice.rules.Country;

@RestController
public class CountryValidatorServiceController {
	
	private static Map<String, List<Country>> CountryDB = new HashMap<String, List<Country>>();
	 
    static {
    	
        CountryDB = new HashMap<String, List<Country>>();
 
        List<Country> lst = new ArrayList<Country>();
        Country std = new Country("Akila Sandakelum", "Grade XIII");
        lst.add(std);
        std = new Country("Kasun Ilangasinghe", "Grade XII");
        lst.add(std);
        std = new Country("Hashan Senvirathne", "Graduated");
        lst.add(std);
 
        CountryDB.put("abcschool", lst);
 
        lst = new ArrayList<Country>();
        std = new Country("Thuan Preena", "Class XIII");
        lst.add(std);
        std = new Country("Rumesh Paranavithana", "Alumini");
        lst.add(std);
        std = new Country("Ragavan Thiru", "Class X");
        lst.add(std);
 
        CountryDB.put("xyzschool", lst);
        
        lst = new ArrayList<Country>();
        std = new Country("Ajmal Firdhouse", "Class XIII");
        lst.add(std);
        std = new Country("Malaka Mahanama", "Alumini");
        lst.add(std);
        std = new Country("Ramindu Deshapriya", "Class XI");
        lst.add(std);
 
        CountryDB.put("defschool", lst);
    }
 
    @RequestMapping(value = "Countryes/getCountryDetailsForSchool/{schoolname}", method = RequestMethod.GET)
    public List<Country> getCountrys(@PathVariable String schoolname) {
        System.out.println("Getting Country details for " + schoolname);
 
        List<Country> CountryList = CountryDB.get(schoolname);
        if (CountryList == null) {
            CountryList = new ArrayList<Country>();
            Country std = new Country("Not Found", "N/A");
            CountryList.add(std);
        }
        return CountryList;
    }
}
