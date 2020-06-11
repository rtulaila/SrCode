package com.gcdp.ui.automation.prescreening;

import org.openqa.selenium.WebElement;

import com.gcdp.ui.automation.Base;

public class PreScreening extends Base {
	public static final String LIST_APPLICATION_URL = "http://svr100c001t012.agr.gc.ca:4503/content/aafc-gcdp/applicationList.html";

	PreScreening() {
		login();
	}

	public void chooseProgram(PreScreeningData preScreeningData) {
		sleep();
		selectFromDropdown("//*[@id=\"guideContainer-rootPanel-home-programId___widget\"]", preScreeningData.getProgramName());
		selectFromDropdown("//*[@id=\"guideContainer-rootPanel-home-organizationId___widget\"]", preScreeningData.getOrganizationName());
		click("//*[@id=\"guideContainer-rootPanel-home-button_continue___widget\"]/span[2]");

		sleep();
		click("/html/body/main/div[1]/div/a");

		fillPreScreen(preScreeningData);
	}
	
	public boolean findApplication(String appName) {
		driver.navigate().to(LIST_APPLICATION_URL);
		sleep();

		boolean appFound = false;
		while(true) {
			WebElement element = findByLink(appName);
			if (element == null) {
				WebElement next = findElement("//*[@id=\"wb-auto-3_next\"]");
				if (next == null) {
					break;
				}
				next.click();
			} else {
				appFound = true;
				break;
			}
		}
		
		return appFound;
	}

	public void fillPreScreen(PreScreeningData preScreeningData) {

		WebElement e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-name___widget\"]");
		e.sendKeys(preScreeningData.getPreScreenName());

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-projectDescription___widget\"]");
		e.sendKeys(preScreeningData.getProjectDescription());

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-psAddress1City___widget\"]");
		e.sendKeys("Ottawa");

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-address1ProvinceId___widget\"]");
		e.sendKeys("Ontario");

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-address1CountryId___widget\"]");
		e.sendKeys("Canada");

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-address1PostalCode___widget\"]");
		e.sendKeys("K1K1K1");

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-estimatedStartDate___widget\"]");
		e.sendKeys("04/01/2020");

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-estimatedEndDate___widget\"]");
		e.sendKeys("12/31/2020");

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-psRequestedAAFCFunding___widget\"]");
		e.sendKeys("12000");

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-totalValueOfTheProject___widget\"]");
		e.sendKeys("120000");

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-projectObjective___widget\"]");
		e.sendKeys("Project Activiites descritption");

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-FundingSource-aafc_amount___widget\"]");
		e.sendKeys("1200");

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-FundingSource-applicant_amount___widget\"]");
		e.sendKeys("1200");

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-FundingSource-industry_amount___widget\"]");
		e.sendKeys("1200");

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-FundingSource-other_amount___widget\"]");
		e.sendKeys("1200");

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-naicsCodeParentId___widget\"]");
		e.sendKeys("Agricultural Production");

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-naicsCodeId___widget\"]");
		e.sendKeys("11115: Corn Farming");

		e = findElement("//*[@id=\"guideContainer-rootPanel-prescreen-submit_1344868758___widget\"]");
		e.click();

		System.out.println("Thank you for your submission !");
	}
}
