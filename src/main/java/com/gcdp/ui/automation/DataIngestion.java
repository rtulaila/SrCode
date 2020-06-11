package com.gcdp.ui.automation;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.gcdp.ui.automation.prescreening.PreScreeningData;

public class DataIngestion {
	
	public static List<PreScreeningData> getPrescreenData() throws IOException {
		List<PreScreeningData> data = new ArrayList<PreScreeningData>();
		try (
	            Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\tutailat\\eclipse-workspace\\ram-automation\\src\\main\\java\\com\\gcdp\\ui\\automation\\prescreening\\prescreening.csv"));
	            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
	                    .withHeader(
	                    		"program", "organization", "prescreeningName", "projectDescription", 
	                    		"city", "province", "country", "postalCode", "startDate", "endDate", 
	                    		"requestedAAFFunding", "totalValue", "projectObjective", "aafcAmount", 
	                    		"applicationAmount", "industryAmount", "otherAmount", "naisParentCode", 
	                    		"naisId")//add headers in the csv
	                    .withIgnoreHeaderCase()
	                    .withTrim());
	        ) {
				int index = 0;
	            for (CSVRecord csvRecord : csvParser) {
	            	 if (index == 0) {
	            		 index++;
	            		 continue;
	            	 }
	                String program = csvRecord.get("program");
	                String organization = csvRecord.get("organization");
	                String preScreeningName = csvRecord.get("prescreeningName");
	                String projectDescription = csvRecord.get("projectDescription");
	               
	                //get other fields
	                
	                PreScreeningData preScreeningData = new PreScreeningData();
	                preScreeningData.setProgramName(program);
	                preScreeningData.setOrganizationName(organization);
	                preScreeningData.setPreScreenName(preScreeningName);
	                preScreeningData.setProjectDescription(projectDescription); 
	                //set here
	                
	                data.add(preScreeningData);
	            }
	        }
		
		return data;
	}
	
//	public static void main(String[] args) throws Exception {
//		List<PreScreeningData> data = DataIngestion.getPrescreenData();
//		for (PreScreeningData preScreeningData : data) {
//			System.out.println(preScreeningData.getProgramName());
//			System.out.println(preScreeningData.getOrganizationName());
//			System.out.println(preScreeningData.getPreScreenName());
//		}
//	}

}
