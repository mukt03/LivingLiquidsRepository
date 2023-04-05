package LivingLiquidztestNg;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
import pages.LogInPage;
import utils.Utility;

public class VerifySignIn extends Base{
	WebDriver driver;
	Home_Page homePage;
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
		System.out.println("before class");
		homePage=new Home_Page(driver);
		
		
		loginPage=new LogInPage(driver);
		
	}
	@BeforeMethod
	public void signInapp() {
		System.out.println("before method");
		//homePage.clickSignIn();
	}
	@Test
	public void verifySignInTitlePage() {
		testID="L05";

		homePage.clickSignIn();

		String loginPageActualTitle=driver.getTitle();
		System.out.println(loginPageActualTitle);
		String loginPageExpectedTitle="Log in";
		asser=new SoftAssert();
		asser.assertEquals(loginPageActualTitle, loginPageExpectedTitle,"Login Page title not verified");
		asser.assertAll();
		
	}
	@Test
	public void verifySigninError() throws EncryptedDocumentException, IOException {
		testID="L06";

		homePage=new Home_Page(driver);
		homePage.clickSignIn();
		loginPage=new LogInPage(driver);
		String data=Utility.getExcelData("ProjectInputdata", 1, 2);
		loginPage.passPhoneNumber(data);
		loginPage.clickSendOTP();
		data=Utility.getExcelData("ProjectInputdata", 1, 3);
		loginPage.passOTP(data);
		loginPage.clickOnProceed();
		String actualErrormsg=loginPage.textOferrorofInvalidOTP();
		String expectedErrormsg="Invalid OTP";
		asser=new SoftAssert();
		asser.assertEquals(actualErrormsg, expectedErrormsg, "error msg is not correct");
		asser.assertAll();
	}
	@AfterMethod
	public void backTomainPage(ITestResult result) throws IOException {
		if(ITestResult.FAILURE== result.getStatus()) {
			Utility.captureScreenshot(driver, testID);
		}
		System.out.println("after method");
		//loginPage.clickOnLivingLiquidz();
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
