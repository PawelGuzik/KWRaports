package kw.raport.model.browser;

import java.util.Collections;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import kw.raport.model.browser.utils.Buttons;

public class RunHeadlessBrowser {
	private WebDriver driver;

	public void runHeadlessBrowser() throws InterruptedException {
		setUpBrowserSettings();
	

	}

	public void callResponseFraoExternalService() {
	}

	//  Runs Chrome browser in headless mode
	private void setUpBrowserSettings() {

		ChromeDriverManager.chromedriver().setup();
		
		ChromeOptions chromeoptions = new ChromeOptions();

		
		chromeoptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		
		chromeoptions.addArguments("--disable-blink-features");
		chromeoptions.addArguments("--disable-blink-features=AutomationControlled");
		chromeoptions.addArguments("--incognito", "--disable-blink-features=AutomationControlled");
		chromeoptions.setExperimentalOption("useAutomationExtension", false);
		chromeoptions.addArguments("--user-agent=\"Mozilla/5.0 (Windows Phone 10.0; Android 4.2.1; Microsoft; Lumia 640 XL LTE) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Mobile Safari/537.36 Edge/12.10166\"");
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

		if(firstResult.contains(" nie została odnaleziona.")) {
			return "Księga o podanym numerze nie została odnaleziona w serwisie ekw.ms.gov.pl";
		}
		while (!firstResult.contains("przyciskWydrukZwykly")) {
			Thread.sleep(RandomUtils.nextInt(950, 29000));

			System.out.println("Ponowne klikni�cie [wyszukaj]");
			driver.manage().window().maximize();
			driver.findElement(By.id("wyszukaj")).click();
			System.out.println("Po klikni�ciu wyszukajn wczytano stron�: " + driver.getTitle().toString());
			firstResult = driver.getPageSource().toString();
		}
		
		Thread.sleep(3111);
		
		//button[@name='przyciskWydrukZwykly']
		//WebElement element = driver.findElement(By.name("przyciskWydrukZwykly"));
		WebElement element = driver.findElement(By.xpath(Buttons.ACTKW.getXPath()));

		Actions actions = new Actions(driver);

		driver.manage().window().maximize();

		actions.moveToElement(element).click().perform();

		// driver.findElement(By.name("przyciskWydrukZwykly")).click();

		String result = driver.getPageSource().toString();
		
	//	WebElement elementSec2 = driver.findElement(By.xpath("//input[@value='Dział II']"));
	//	actions.moveToElement(elementSec2).click().perform();
	//	WebElement elementSec3 = driver.findElement(By.xpath(Buttons.SEC1O.getXPath()));
	//	actions.moveToElement(elementSec3).click().perform();
	//	result = driver.getPageSource().toString();
		
		return result;

	}
	//TODO
	//Napisać metody do przetworzenia wszystkich działow na raz
	
	public String goToSection(Buttons button) {
		
		String page;
		Actions actions = new Actions(driver);
		
		WebElement elementSec2 = driver.findElement(By.xpath(button.getXPath()));
		actions.moveToElement(elementSec2).click().perform();
		page =  driver.getPageSource().toString();
		return page;
		
	}
	
	
}
