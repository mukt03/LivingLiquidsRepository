package LivingLiquidztestNg;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browserSetUp.Base;
import pages.Home_Page;
import utils.Utility;

public class VerifyHomepageWebelements extends Base {
	WebDriver driver;
	Home_Page homePage;
	SoftAssert asser;
	String testID;
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) {
		System.out.println("Before Test");
		if (browserName.equals("Chrome")) {
			driver=openChromeBrowser();
			}
			if (browserName.equals("Edge")) {
				driver=openEdgeBrowser();
				}
		driver.get("https://livingliquidz.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
@BeforeClass
public void pomPageLaunch() {
	homePage=new Home_Page(driver);
}
@Test
public void VerifySignIntext() {
	testID="L01";
	String signInActualText=homePage.textSign();
	String signInExpectedText="Sign In";
	asser=new SoftAssert();
	asser.assertEquals(signInActualText, signInExpectedText,"Sign in text is not as expected");
	
//	homePage.clickSignIn();
//	
//	String loginPageActualTitle=driver.getTitle();
//	String loginPageExpectedTitle="Log in";
//	asser.assertEquals(loginPageActualTitle, loginPageExpectedTitle,"Login Page title not verified");
	asser.assertAll();
//	driver.navigate().back();
//	driver.navigate().back();
}
@Test
public void verifyStoreLocatortext() {
	testID="L02";
	String actualtextStoreLocator=homePage.textOfStoreLocator();
	
	String expectedTexttoreLocator="Store Locator";
	asser=new SoftAssert();
	asser.fail();
	asser.assertEquals(actualtextStoreLocator, expectedTexttoreLocator,"Store Locator is showing wrong text");
asser.assertAll();
}
@Test
public void verifyGiftingtext() {
	testID="L03";

	String actualtextgift=homePage.textOfgifting();
	
	String expectedTextgift="Gifting";
	asser.assertEquals(actualtextgift,expectedTextgift,"Gifting is showing wrong text");
asser.assertAll();
}
@AfterMethod
public void captureScreenshotinFailure(ITestResult result) throws IOException {
	if(ITestResult.FAILURE== result.getStatus()) {
		Utility.captureScreenshot(driver, testID);
	}
	
}
@AfterClass
public void objectClear() {
	homePage=null;
	
}
@AfterTest
public void closeBrowser() {
	driver.close();
	driver=null;
	System.gc();
}
}