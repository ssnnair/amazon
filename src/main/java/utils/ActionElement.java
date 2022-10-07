package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionElement {
	WebDriver driver;

	public ActionElement(WebDriver driver) {
		this.driver = driver;
	}

	public void scrolltillelement(WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	public void selectelement(List<WebElement> element, String name) {
		for (int i = 0; i < element.size(); i++) {

			if (element.get(i).getText().contains(name)) {
				element.get(i).click();
				break;
			}

		}
	}

	public void scrollbyaxis() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500,0)");
	}

	public static String generateDateTime() {
		String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		return timeStamp;
	}

}
