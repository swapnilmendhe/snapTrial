package com.k2js.mavenselenium.snapusingpagefactory;

import java.util.concurrent.TimeUnit;
//using POM pageFactory
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.k2js.mavenselenium.snapdealusingpom.Util;

public class Snapdeal {

	@FindBy(xpath = "((//a[contains(text(),'1 TB')])[1]//..)[1]")
	private WebElement checkbox_1tb;

	@FindBy(xpath = "((//a[contains(text(),'120')])[1]//..)[1]")
	private WebElement checkbox_120gb;

	public static void main(String[] args) {
		ChromeDriver cd = new ChromeDriver();
		cd.get("https://www.snapdeal.com/");
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Snapdeal sp = PageFactory.initElements(cd, Snapdeal.class);

		// Click on Computers & Gaming
		WebElement c_g = cd.findElement(By.linkText("Computers & Gaming"));
		c_g.click();
		cd.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		// Click on Storage->View All
		// WebElement v_all = cd.findElement(By.className("viewText animArrowLink"));
		WebElement view = cd.findElement(By.xpath("//*[@id=\"category4Data\"]/div[1]/div/div/p[16]/a/span"));
		view.click();
		System.out.println(cd.getTitle());

		sp.checkbox_1tb.click();
		Util.sleepTime(5000);
		sp.checkbox_120gb.click();

		boolean tb_1 = cd.findElement(By.xpath("(//a[@data-value='1%20TB'])[1]")).isDisplayed();
		System.out.println("Capacity Filter For 1 TB is applied:- " + tb_1);

		boolean gb_120 = cd.findElement(By.xpath("(//a[@data-value='120%20GB'])[1]")).isDisplayed();
		System.out.println("Capacity Filter For 120 GB is applied:- " + gb_120);

		Util.sleepTime(4000);

		// To verify 1TB sorted Item
		String tb_1n = cd.findElement(By.xpath("//p[contains(text(),'1TB External Hard Drive (Black)')]")).getText();
		System.out.println("1TB Item available is:- " + tb_1n);

		Util.sleepTime(4000);
		// to Scroll page
		JavascriptExecutor js = (JavascriptExecutor) cd;
		js.executeScript("scroll(0,800)");

		// To verify 120GB sorted Item
		String gb_120n = cd.findElement(By.xpath("//p[contains(text(),'120 GB SSD Internal Hard drive')]")).getText();
		System.out.println("120GB Item available is:- " + gb_120n);
		Util.sleepTime(4000);

		js.executeScript("scroll(0,-800)");

		// DeSelect CheckBox of capacity 1TB and 120 GB
		sp.checkbox_1tb.click();
		Util.sleepTime(5000);
		sp.checkbox_120gb.click();

		System.out.println("Capacity filter is removed now");

		// 1.1 To verify available element after removing capacity Filter
		String randomEle_1 = cd.findElement(By.xpath("//p[contains(text(),'32GB USB 3.0 OTG Pendrive Black')]"))
				.getText();
		System.out.println("1 Item available on storage page without applying Capacity filter is:- " + randomEle_1);

		// 1.2 To verify available element after removing capacity Filter
		String randomEle_2 = cd.findElement(By.xpath("//p[contains(text(),'Strontium Nitro Ammo 128GB')]")).getText();
		System.out.println("1 Item available on storage page without applying Capacity filter is:- " + randomEle_2);
		Util.sleepTime(3000);

		cd.navigate().back();
		Util.sleepTime(3000);

		System.out.println("Back to Home having Title:- " + cd.getTitle());
		System.out.println("Execution Completed");
		cd.close();
	}
}
