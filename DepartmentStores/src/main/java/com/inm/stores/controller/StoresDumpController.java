package com.inm.stores.controller;

import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.inm.stores.entities.StoresDump;

import com.inm.stores.service.StoresDumpFileService;

@RestController
@RequestMapping("/api/v1/dump/")
@Produces("application/json")
@CrossOrigin
public class StoresDumpController {
	
	@Autowired
    private StoresDumpFileService storesDumpFileService;
    
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = null;
		try {
			fileName = storesDumpFileService.storeFile(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		storesDumpFileService.readAndSaveStoresDumpFile(fileName);

        return "File Uploaded successfully to "+fileName;
    }
    
    @GetMapping("/{location}/{department}/{category}/{subcategory}")
    public List<StoresDump> getStoresByCondition(@PathVariable(value="location") String location, 
    		@PathVariable(value="department") String department, @PathVariable(value="category") String category,
    		@PathVariable(value="subcategory") String subCategory) {
    	return storesDumpFileService.getAllStoresDumpByCriteria(location, department, category, subCategory);
    }
    
}
