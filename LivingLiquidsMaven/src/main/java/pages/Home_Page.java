package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	@FindBy (xpath="//ul//li[2]//a//span[@class='label']")
	private WebElement signIn;
	@FindBy (xpath="//input[@name='q']")
	private WebElement searchBox;
	@FindBy (xpath="//i[@class='typeahead__search-icon']")
	private WebElement searchButton;
	@FindBy (xpath="//a//img[@alt='Store Locator']")
	private WebElement storeLocator;
	@FindBy (xpath="//a//img[@alt='Gifting']")
	private WebElement gifting;
	@FindBy (xpath="//div[@class='d-flex justify-content-end h-100']//a[@href='/Cart']")
	private WebElement cart;
	@FindBy (xpath="//a[@href='whatsapp://send?phone=+917700000770']")
	private WebElement watsApp;
	@FindBy (xpath="(//div[@id=\"content-wrapper\"]//header//a//img)[1]")
	private WebElement livingLiquidzmainicon;
	@FindBy (xpath="(//li[@data-group='products'])[1]")
	private WebElement firstsearchlistitem;
	//private WebDriver driver;
	public Home_Page (WebDriver driver){
	PageFactory.initElements(driver, this);
	//this.driver=driver;
	}
		public String textSign() {
		return(	signIn.getText());
		}
	
	public void clickSignIn() {
		signIn.click();
	}
	public void PassDataInSearchBox(String searchItem) {
		searchBox.sendKeys(searchItem);
		
	}
	
	public void clickSearchbutton() {
		searchButton.click();
	}
	public void clickCart() {
		cart.click();
	}
	public String textOfStoreLocator() {
		return(storeLocator.getAttribute("alt"));
	}
	public void clickStoreLocator() {
		storeLocator.click();
	}
	public String textOfgifting() {
		return(gifting.getAttribute("alt"));
	}
	public void clickGifting() {
		storeLocator.click();
	}
	public void clickOnLivingLiquidz() {
		livingLiquidzmainicon.click();
	}
	public void clickonfirstSearchitem() {
		firstsearchlistitem.click();
	}
}
