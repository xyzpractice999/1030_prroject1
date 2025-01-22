package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;

import static utils.BrowserUtils.*;

public class TestCase1 {


	@Test
	public void test1() throws Exception, Exception {
		loadConfigurations();
		openBrowser();
		invokeApp();
		performSearch();
		verifySerachIsSuccessfull();
		killBrower();
		killBrower();
	}

	private void loadConfigurations() throws Exception, IOException {
		String path = System.getProperty("user.dir") + "/src/main/resources/config/global.properties";
		prop = new Properties();
		prop.load(new FileInputStream(new File(path)));

	}

	

	private void verifySerachIsSuccessfull() {
		if (driver.findElement(By.xpath("//div[@class='YmvwI'][normalize-space()='All']")).isDisplayed()) {
			System.out.println("Pass - search is successfull");
		} else {
			System.out.println("Fail - search is not successfull");
		}

	}

	private void performSearch() {
		driver.findElement(By.id("APjFqb")).sendKeys("selenium");
		driver.findElement(By.id("APjFqb")).submit();
	}



}
