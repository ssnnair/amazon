package loginTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Amazon_homepagePO;

public class AmazonTest extends BaseClass {
	Amazon_homepagePO homepage;

	@BeforeTest
	public void init() throws IOException {
		invokebrowser();
		homepage = new Amazon_homepagePO(driver);

	}

	@Test(priority = 1)
	public void searchProduct() throws InterruptedException, IOException {
		homepage.selectproductfromsearchlist("samsung");

	}

	@Test(priority = 2)
	public void selectproductfromlist() throws InterruptedException {
		homepage.Selectdevicefromlist("SAMSUNG Galaxy A53 5G");
		Assert.assertEquals("SAMSUNG Galaxy A53 5G", "SAMSUNG " + homepage.selectedproduct().getText());
	}

	@Test(priority = 3)
	public void setitemtocart() throws InterruptedException {
		homepage.addelementincart();

	}

	@Test(priority = 4)
	public void verifyshoppingcarttime() throws InterruptedException {
		Thread.sleep(4000);
		homepage.cartfuction();
		Assert.assertTrue(homepage.devicedescription().isDisplayed());

	}

	@Test(priority = 5)
	public void checkoutfunction() {
		homepage.checkoutpage();
		Assert.assertTrue(homepage.signin().isDisplayed());

	}

	@AfterTest
	public void teardown() {
		quitsession();

	}
}
