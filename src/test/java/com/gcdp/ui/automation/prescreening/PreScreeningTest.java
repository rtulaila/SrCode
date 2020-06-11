package com.gcdp.ui.automation.prescreening;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gcdp.ui.automation.DataIngestion;
import com.gcdp.ui.automation.prescreening.PreScreening;
import com.gcdp.ui.automation.prescreening.PreScreeningData;


public class PreScreeningTest {
	DataIngestion dataIngstion = new DataIngestion();
	
	@Test
	public void sholdBeAbleToSubmit_PrescreeningApplication() throws Exception {
		List<PreScreeningData> dataToTest = DataIngestion.getPrescreenData();
		
		for (PreScreeningData preScreeningData : dataToTest) {
			PreScreening preScreening = new PreScreening();
			preScreening.chooseProgram(preScreeningData);
			
			boolean appFound = preScreening.findApplication("RT_May05-PreScreening_033");
			Assert.assertTrue(appFound);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		List<PreScreeningData> dataToTest = DataIngestion.getPrescreenData();
		
		for (PreScreeningData preScreeningData : dataToTest) {
			PreScreening preScreening = new PreScreening();
			preScreening.chooseProgram(preScreeningData);
			
			boolean appFound = preScreening.findApplication("RT_May05-PreScreening_033");
			Assert.assertTrue(appFound);
		}
	}

}
