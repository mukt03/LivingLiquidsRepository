package LivingLiquidztestNg;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browserSetUp.Base;
import pages.Home_Page;
import pages.LogInPage;
import pages.Product_Page;
import utils.Utility;

public class VerifySearchbox extends Base{

	WebDriver driver;
	Home_Page homePage;
	Product_Page productPage;
	SoftAssert asser;
	LogInPage loginPage;
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
		productPage=new Product_Page(driver);
		
	}
	@Test
	public void verifySearch() throws InterruptedException, IOException {
		testID="L04";
		String mainPageTitle=driver.getTitle();
		String data=Utility.getExcelData("ProjectInputdata", 1, 4);

		homePage.PassDataInSearchBox(data);
		homePage.clickonfirstSearchitem();
		
		Thread.sleep(2000);
		Utility.captureScreenshot(driver,testID);
		String productPagetitle=driver.getTitle();
		System.out.println(productPagetitle);
		asser=new SoftAssert();
		asser.assertNotEquals(productPagetitle, mainPageTitle, "after search click page not changed");

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
		loginPage=null;
		asser=null;
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc();
	}
	
	
}
