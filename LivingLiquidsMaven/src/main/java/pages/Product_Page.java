package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Page {
@FindBy(xpath="//h1[text()='BACARDI BREEZER BLACKBERRY']")
private WebElement headingOfProduct;
@FindBy (xpath="(//div[@id=\"content-wrapper\"]//header//a//img)[1]")
private WebElement livingLiquidzmainicon;
@FindBy (xpath="//input[@name='q']")
private WebElement searchBox;
@FindBy (xpath="//i[@class='typeahead__search-icon']")
private WebElement searchButton;
private WebDriver driver;

public Product_Page(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
}

public String getTitleOfPage() {
	return(driver.getTitle());
}

}
