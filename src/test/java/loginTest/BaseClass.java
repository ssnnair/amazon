package loginTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ActionElement;

public class BaseClass {
	Properties properties;
	public WebDriver driver;
	ActionElement action;

	public void invokebrowser() throws IOException {
		String path = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(path + "\\src\\main\\java\\utils\\resource.properties");
		properties = new Properties();
		properties.load(fis);
		if (properties.getProperty("browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.amazon.com/");
			driver.manage().window().maximize();

		}

	}

	public void quitsession() {
		driver.close();
		driver.quit();

	}

}
