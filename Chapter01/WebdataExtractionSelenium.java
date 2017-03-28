package chap1.java.science.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdataExtractionSelenium {
	public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://cogenglab.csd.uwo.ca/rushdi.htm");

        WebElement webElement = driver.findElement(By.xpath("//*[@id='content']"));
		System.out.println(webElement.getText());
		
	}
}
