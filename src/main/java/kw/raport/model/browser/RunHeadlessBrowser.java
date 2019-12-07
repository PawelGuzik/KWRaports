package kw.raport.model.browser;

import java.util.Random;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class RunHeadlessBrowser {
	private WebDriver driver;

	public void runHeadlessBrowser() throws InterruptedException {
		setUpBrowserSettings();
		

	}
	
		/*
		

		

		
		
		*/
	public void callResponseFraoExternalService() {
		
	}

	//  Runs Chrome browser in headless mode
	private void setUpBrowserSettings() {

		ChromeDriverManager.chromedriver().setup();

		ChromeOptions chromeoptions = new ChromeOptions();

		chromeoptions.addArguments("--headless");

		driver = new ChromeDriver(chromeoptions);
		
	}

	// Sends values to the form on
	// https://przegladarka-ekw.ms.gov.pl/eukw_prz/KsiegiWieczyste/wyszukiwanieKW
	public String sendValuesToExternalKWForm( String kodWydziału, String numerKW, String cyfraKontrolna) throws InterruptedException {
		driver.get(
				"https://przegladarka-ekw.ms.gov.pl/eukw_prz/KsiegiWieczyste/wyszukiwanieKW?komunikaty=true&kontakt=true&okienkoSerwisowe=false");
		
		Thread.sleep(3000);
		
		System.out.println("Wczytano stron�: " + driver.getTitle().toString());
		
		driver.findElement(By.id("kodWydzialuInput")).sendKeys(kodWydziału);

		driver.findElement(By.id("numerKsiegiWieczystej")).sendKeys(numerKW);

		driver.findElement(By.id("cyfraKontrolna")).sendKeys(cyfraKontrolna);
		
		driver.findElement(By.xpath("(//span[@class='button close'])[1]")).click();

		driver.findElement(By.id("wyszukaj")).click();
		String firstResult = driver.getPageSource();
		System.out.println("Po klikni�ciu wyszukaj wczytano stron�: " + driver.getTitle().toString()
				+ "\n �r�d�o strony" + firstResult);

		while (!firstResult.contains("przyciskWydrukZwykly")) {
			Thread.sleep(RandomUtils.nextInt(950, 29000));

			System.out.println("Ponowne klikni�cie [wyszukaj]");
			driver.manage().window().maximize();
			driver.findElement(By.id("wyszukaj")).click();
			System.out.println("Po klikni�ciu wyszukajn wczytano stron�: " + driver.getTitle().toString());
			firstResult = driver.getPageSource().toString();
		}
		
		Thread.sleep(3111);
		WebElement element = driver.findElement(By.name("przyciskWydrukZwykly"));

		Actions actions = new Actions(driver);

		driver.manage().window().maximize();

		actions.moveToElement(element).click().perform();

		// driver.findElement(By.name("przyciskWydrukZwykly")).click();

		String result = driver.getPageSource().toString();
		return result;

	}
}
