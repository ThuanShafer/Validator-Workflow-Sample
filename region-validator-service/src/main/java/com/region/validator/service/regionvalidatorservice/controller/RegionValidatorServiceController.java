package com.region.validator.service.regionvalidatorservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.region.validator.service.regionvalidatorservice.rules.Region;

@RestController
public class RegionValidatorServiceController {
	
	private static Map<String, List<Region>> RegionDB = new HashMap<String, List<Region>>();
	 
    static {
    	
        RegionDB = new HashMap<String, List<Region>>();
 
        List<Region> lst = new ArrayList<Region>();
        Region std = new Region("Akila Sandakelum", "Grade XIII");
        lst.add(std);
        std = new Region("Kasun Ilangasinghe", "Grade XII");
        lst.add(std);
        std = new Region("Hashan Senvirathne", "Graduated");
        lst.add(std);
 
        RegionDB.put("abcschool", lst);
 
        lst = new ArrayList<Region>();
        std = new Region("Thuan Preena", "Class XIII");
        lst.add(std);
        std = new Region("Rumesh Paranavithana", "Alumini");
        lst.add(std);
        std = new Region("Ragavan Thiru", "Class X");
        lst.add(std);
 
        RegionDB.put("xyzschool", lst);
        
        lst = new ArrayList<Region>();
        std = new Region("Ajmal Firdhouse", "Class XIII");
        lst.add(std);
        std = new Region("Malaka Mahanama", "Alumini");
        lst.add(std);
        std = new Region("Ramindu Deshapriya", "Class XI");
        lst.add(std);
 
        RegionDB.put("defschool", lst);
    }
 
    @RequestMapping(value = "Regiones/getRegionDetailsForSchool/{schoolname}", method = RequestMethod.GET)
    public List<Region> getRegions(@PathVariable String schoolname) {
        System.out.println("Getting Region details for " + schoolname);
 
        List<Region> RegionList = RegionDB.get(schoolname);
        if (RegionList == null) {
            RegionList = new ArrayList<Region>();
            Region std = new Region("Not Found", "N/A");
            RegionList.add(std);
        }
        return RegionList;
    }
}
