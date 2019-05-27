package com.k2js.mavenselenium.snapdealusingpom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Using POM
public class PageObjects {
	WebDriver driver;

	By com_game = By.linkText("Computers & Gaming");
	By view_all = By.xpath("//*[@id='category4Data']/div[1]/div/div/p[16]/a/span");
	By checkbox_1st = By.xpath("((//a[contains(text(),'1 TB')])[1]//..)[1]");
	By checkbox_2nd = By.xpath("((//a[contains(text(),'120')])[1]//..)[1]");
	By verify_sort_ele1 = By.xpath("//p[contains(text(),'1TB External Hard Drive (Black)')]");
	By verify_sort_ele2 = By.xpath("//p[contains(text(),'120 GB SSD Internal Hard drive')]");
	By verify_unsorted_ele1 = By.xpath("//p[contains(text(),'32GB USB 3.0 OTG Pendrive Black')]");
	By verify_unsorted_ele2 = By.xpath("//p[contains(text(),'Strontium Nitro Ammo 128GB')]");
	By is_checkbox_1tb_apply = By.xpath("(//a[@data-value='1%20TB'])[1]");
	By is_checkbox_120gb_apply = By.xpath("(//a[@data-value='120%20GB'])[1]");

	public PageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement clickOnCompGame() {
		return driver.findElement(com_game);
	}

	public WebElement viewAll() {
		return driver.findElement(view_all);
	}

	public WebElement checkBox_1tb() {
		return driver.findElement(checkbox_1st);
	}

	public WebElement checkBox_120gb() {
		return driver.findElement(checkbox_2nd);
	}

	public WebElement firstElementVerifyAfterFilter() {
		return driver.findElement(verify_sort_ele1);
	}

	public WebElement secElementVerifyAfterFilter() {
		return driver.findElement(verify_sort_ele2);
	}

	public WebElement verifyUnsortedEle1() {
		return driver.findElement(verify_unsorted_ele1);
	}

	public WebElement verifyUnsortedEle2() {
		return driver.findElement(verify_unsorted_ele2);
	}

	public WebElement checkBoxValidation1TB() {
		return driver.findElement(is_checkbox_1tb_apply);
	}

	public WebElement checkBoxValidation120GB() {
		return driver.findElement(is_checkbox_120gb_apply);
	}
}