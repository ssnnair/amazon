package pageobjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;
import utils.ActionElement;

public class Amazon_homepagePO extends ActionElement {
	WebDriver driver;

	public Amazon_homepagePO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement homesearch;

	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
	private List<WebElement> devicename;

	@FindBy(xpath = "//span[contains(text(),'Model Name')]//ancestor::tr//td[2]//span")
	WebElement selectedproduct;

	@FindBy(xpath = "//descendant::span[contains(text(),' Add to Cart ')][2]//ancestor::span[2]")
	WebElement addtocart;

	@FindBy(css = "div[id='nav-cart-text-container']")
	WebElement cartbutton;

	@FindBy(css = "span[class='a-truncate-cut']")
	WebElement devicedescription;

	@FindBy(css = "input[name='proceedToRetailCheckout']")
	WebElement checkout;

	@FindBy(xpath = "//div[@class='a-box-inner a-padding-extra-large']")
	WebElement signinplaceholder;

	public void selectproductfromsearchlist(String productname) throws InterruptedException {
		Thread.sleep(2000);
		homesearch.click();
		homesearch.sendKeys(productname);
		Thread.sleep(2000);
		homesearch.sendKeys(Keys.RETURN);
	}

	public void Selectdevicefromlist(String name) throws InterruptedException {
		scrolltillelement(devicename.get(3));
		Thread.sleep(2000);
		selectelement(devicename, name);

	}

	public WebElement selectedproduct() {
		return selectedproduct;
	}

	public void addelementincart() throws InterruptedException

	{

		addtocart.click();

	}

	public void cartfuction() {
		scrollbyaxis();
		cartbutton.click();

	}

	public WebElement devicedescription() {
		return devicedescription;
	}

	public void checkoutpage() {

		checkout.click();

	}

	public WebElement signin() {
		return signinplaceholder;

	}

}
