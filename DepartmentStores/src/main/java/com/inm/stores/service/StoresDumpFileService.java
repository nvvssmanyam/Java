package com.inm.stores.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.inm.stores.entities.FileStorageProperties;
import com.inm.stores.entities.StoresDump;
import com.inm.stores.repos.StoresDumpRepo;

@Service
public class StoresDumpFileService {
	
	@Autowired
	private StoresDumpRepo storesDumpRepo;

	private final Path fileStorageLocation;

	@Autowired
	public StoresDumpFileService(FileStorageProperties fileStorageProperties) throws Exception {
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			throw new Exception("Could not create the directory where the uploaded files will be stored.",ex);
		}
	}

	public String storeFile(MultipartFile file) throws Exception {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
			}

			// Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			return targetLocation.toString();
		} catch (IOException ex) {
			throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
		}
	}
	
	public void readAndSaveStoresDumpFile(String csvFile) {
        String line = "";
        String cvsSplitBy = ",";
        List<StoresDump> storesList = null;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

        	storesList = new ArrayList<>();
        	StoresDump store = null;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] entities = line.split(cvsSplitBy);
                if(!"SKU".equalsIgnoreCase(entities[0])) {                	
                	store = new StoresDump(Integer.parseInt(entities[0]), entities[1], entities[2], entities[3], entities[4], entities[5]);
                	storesList.add(store);
                }
            }
            saveStoresDump(storesList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public Resource loadFileAsResource(String fileName) throws Exception {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new Exception("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new Exception("File not found " + fileName, ex);
		}
	}
	
	public List<StoresDump> saveStoresDump(List<StoresDump> storesList) {
		return (List<StoresDump>) storesDumpRepo.saveAll(storesList);
	}
	
	public List<StoresDump> getAllStoresDumpByCriteria(String location, String department, String category, String subCategory) {
		return storesDumpRepo.findByCategory(location, department, category, subCategory);
	}
}
