package gov.dol.bg.test;

import gov.dol.bg.test.pages.DOLHomepage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;


public class User {

	DOLHomepage dolHomepage;

    @Step
    public void onHomePage() {
    	dolHomepage.open();
    }
    
    @Step
	public void open_page(String directoryPath) {
    	dolHomepage.clearCookies();
		
		String url = dolHomepage.defaultUrl + directoryPath;
		
		dolHomepage.openAt(url);
	
	}
    


    
    @Step
    public void clickNavNode(String node) {
    	

    	switch(node) {
    	//Main Nav
		case "Topics": 
			dolHomepage.topicsNavButton.click();
			break;
		case "Agencies": 
			dolHomepage.agenciesNavButton.click();
			break;
		case "Forms": 
			dolHomepage.formsNavButton.click();
			break;
		case "FAQ": 
			dolHomepage.faqNavButton.click();
			break;
		case "About": 
			dolHomepage.aboutNavButton.click();
			break;
		case "Press": 
			dolHomepage.pressNavButton.click();
			break;
		case "Contact": 
			dolHomepage.contactNavButton.click();
			break;	
			
		//Sub nav - Topics
		
		case "COBRA": 
			dolHomepage.clickSubNavButtons(dolHomepage.topicsNavButton, dolHomepage.cobraSubNavButton);
			break;	
			
		case "Disability Resources": 
			dolHomepage.clickSubNavButtons(dolHomepage.topicsNavButton, dolHomepage.disabilityResourcesSubNavButton);
			break;	
		
		case "Retirement Plans": 
			dolHomepage.clickSubNavButtons(dolHomepage.topicsNavButton, dolHomepage.retirementPlansSubNavButton);
			break;			
    	
    	//sub Nav - Agencies
    	
    	case "ILAB": 
    		dolHomepage.clickSubNavButtons(dolHomepage.agenciesNavButton, dolHomepage.ilabSubNavButton);
    		break;	
		
    	case "EBSA": 
    		dolHomepage.clickSubNavButtons(dolHomepage.agenciesNavButton, dolHomepage.ebsaSubNavButton);
    		break;	
    		
    	//Sub nav - Press
    		
    	case "Newsroom": 
    		dolHomepage.clickSubNavButtons(dolHomepage.pressNavButton, dolHomepage.newsroomSubNavButton);
    		break;	
    			
    	case "News Release": 
    		dolHomepage.clickSubNavButtons(dolHomepage.pressNavButton, dolHomepage.newsreleaseSubNavButton);
    		break;	
    		
    	case "News Letter": 
    		dolHomepage.clickSubNavButtons(dolHomepage.pressNavButton, dolHomepage.newsletterPlansSubNavButton);
    		break;	
    		
    	default:
			System.err.println("INVALID BUTTON CLICKED");
			break;
    	}	
    }
    
    @Step
	public void shouldSeePage(String expectedPageName) {
		
		
		switch(expectedPageName) {
		//case "dol.gov main navbar":
		
		case "Topics": 
		case "Forms":
			Assert.assertEquals(expectedPageName, dolHomepage.pullPageTitle());
			break;
		case "Agencies":
			Assert.assertEquals("Agencies & Programs", dolHomepage.pullPageTitle());
			break;
		case "About":
			Assert.assertEquals("Who We Are & What We Do", dolHomepage.pullPageTitle());
			break;
		case "Press":			
			Assert.assertEquals("Newsroom", dolHomepage.pullPageTitle());
			break;
		case "Contact":
			Assert.assertEquals("Contacting the Department of Labor", dolHomepage.pullPageTitle());
			break;
		case "FAQ":
			break;
		
		//case subNav Topics
		case "COBRA":
			Assert.assertEquals("Health Plans & Benefits: Continuation of Health Coverage - COBRA", dolHomepage.pullPageTitle());
			break;
		case "Disability Resources":
			Assert.assertEquals("Disability Resources", dolHomepage.pullPageTitle());
			break;
		case "Retirement Plans":
			Assert.assertEquals("Retirement Plans-Benefits & Savings", dolHomepage.pullPageTitle());
			break;
			
		//case subNav Agencies
		case "ILAB":
			Assert.assertEquals("Bureau Of International Labor Affairs", dolHomepage.pullPageTitle());
			break;
		case "EBSA":
			Assert.assertEquals("Employee Benefits Security Administration", dolHomepage.pullPageTitle());
			break;
		
		//case subNav Press
		case "Newsroom":
			Assert.assertEquals("Newsroom", dolHomepage.pullPageTitle());
			break;
		case "News Release":
			Assert.assertEquals("News Releases", dolHomepage.pullPageTitle());
			break;
		case "News Letter":
			Assert.assertEquals("DOL Newsletter", dolHomepage.pullPageTitle());
			break;
			
		default:
			System.err.println("INVALID PAGE SENT");
			break;
		} 
	}

}