package com.branch.validator.service.branchvalidatorservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.branch.validator.service.branchvalidatorservice.rules.Branch;

@RestController
public class BranchValidatorServiceController {
	
	private static Map<String, List<Branch>> branchDB = new HashMap<String, List<Branch>>();
	 
    static {
    	
        branchDB = new HashMap<String, List<Branch>>();
 
        List<Branch> lst = new ArrayList<Branch>();
        Branch std = new Branch("Akila Sandakelum", "Grade XIII");
        lst.add(std);
        std = new Branch("Kasun Ilangasinghe", "Grade XII");
        lst.add(std);
        std = new Branch("Hashan Senvirathne", "Graduated");
        lst.add(std);
 
        branchDB.put("abcschool", lst);
 
        lst = new ArrayList<Branch>();
        std = new Branch("Thuan Preena", "Class XIII");
        lst.add(std);
        std = new Branch("Rumesh Paranavithana", "Alumini");
        lst.add(std);
        std = new Branch("Ragavan Thiru", "Class X");
        lst.add(std);
 
        branchDB.put("xyzschool", lst);
        
        lst = new ArrayList<Branch>();
        std = new Branch("Ajmal Firdhouse", "Class XIII");
        lst.add(std);
        std = new Branch("Malaka Mahanama", "Alumini");
        lst.add(std);
        std = new Branch("Ramindu Deshapriya", "Class XI");
        lst.add(std);
 
        branchDB.put("defschool", lst);
    }
 
    @RequestMapping(value = "branches/getBranchDetailsForSchool/{schoolname}", method = RequestMethod.GET)
    public List<Branch> getBranchs(@PathVariable String schoolname) {
        System.out.println("Getting Branch details for " + schoolname);
 
        List<Branch> BranchList = branchDB.get(schoolname);
        if (BranchList == null) {
            BranchList = new ArrayList<Branch>();
            Branch std = new Branch("Not Found", "N/A");
            BranchList.add(std);
        }
        return BranchList;
    }

}
