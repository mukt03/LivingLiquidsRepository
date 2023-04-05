package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	
@FindBy(xpath="(//input[@id=\"Mobile\"])[2]")
private WebElement enterPhoneNumber;
@FindBy(xpath="//button[@id=\"send-otp\"]")
private WebElement sendOTPbutton;
@FindBy(xpath="(//input[@id=\"OTP\"])[2]")
private WebElement oTPinputBox;
@FindBy(xpath="(//button[@id=\"wbr-btn-send-otp\"])[2]")
private WebElement proceed;
@FindBy(xpath="//div[@class='text-danger']")
private WebElement inValidOTPText;
@FindBy (xpath="(//div[@id=\"content-wrapper\"]//header//a//img)[1]")
private WebElement livingLiquidzmainicon;
//private WebDriver driver;

public LogInPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	//this.driver=driver;
}
public void passPhoneNumber(String phoneNumber) {
	enterPhoneNumber.sendKeys(phoneNumber);
}
public void clickSendOTP() {
	sendOTPbutton.click();
}
public void passOTP(String OTP) {
	oTPinputBox.sendKeys(OTP);
}
public void clickOnProceed() {
	proceed.click();
}
public String textOferrorofInvalidOTP() {
	return(inValidOTPText.getText());
}
public void clickOnLivingLiquidz() {
	livingLiquidzmainicon.click();
}

}
