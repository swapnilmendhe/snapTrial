package com.k2js.mavenselenium.snapdealautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Simple Flow
public class SnapdealAutoSimple {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Git Trial1");
		System.out.println("Git Trial2");
		System.out.println("Git Trial3");
		

		System.out.println("Git Trial4");
		System.out.println("Git Trial5");
		System.out.println("Git Trial6");

		System.out.println("Git Trial7");
		System.out.println("Git Trial8");
		System.out.println("Git Trial9");
		
		ChromeDriver cd = new ChromeDriver();
		// cd.manage().deleteAllCookies();
		cd.get("https://www.snapdeal.com/");
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click on Computers & Gaming
		WebElement c_g = cd.findElement(By.linkText("Computers & Gaming"));
		c_g.click();
		cd.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		// Click on Storage->View All
		// WebElement v_all = cd.findElement(By.className("viewText animArrowLink"));
		WebElement view = cd.findElement(By.xpath("//*[@id=\"category4Data\"]/div[1]/div/div/p[16]/a/span"));
		view.click();
		System.out.println(cd.getTitle());

		// Select CheckBox of capacity 1TB
		WebElement check_box_1tb = cd.findElement(By.xpath("((//a[contains(text(),'1 TB')])[1]//..)[1]"));
		check_box_1tb.click();

		Thread.sleep(5000);

		// Select CheckBox of capacity 120GB
		WebElement check_box_2gb = cd.findElement(By.xpath("((//a[contains(text(),'120')])[1]//..)[1]"));
		check_box_2gb.click();

		Thread.sleep(3000);

		boolean tb_1 = cd.findElement(By.xpath("(//a[@data-value='1%20TB'])[1]")).isDisplayed();
		System.out.println("Capacity Filter For 1 TB is applied:- " + tb_1);

		boolean gb_120 = cd.findElement(By.xpath("(//a[@data-value='120%20GB'])[1]")).isDisplayed();
		System.out.println("Capacity Filter For 120 GB is applied:- " + gb_120);

		Thread.sleep(3000);

		// To verify 1TB sorted Item
		String tb_1n = cd.findElement(By.xpath("//p[contains(text(),'1TB External Hard Drive (Black)')]")).getText();
		System.out.println("1TB Item available is:- " + tb_1n);

		Thread.sleep(4000);
		// to Scroll page
		JavascriptExecutor js = (JavascriptExecutor) cd;
		js.executeScript("scroll(0,800)");

		// To verify 120GB sorted Item
		String gb_120n = cd.findElement(By.xpath("//p[contains(text(),'120 GB SSD Internal Hard drive')]")).getText();
		System.out.println("120GB Item available is:- " + gb_120n);
		Thread.sleep(2000);

		js.executeScript("scroll(0,-800)");
		// DeSelect CheckBox of capacity 1TB
		WebElement dcheck_box_1tb = cd.findElement(By.xpath("((//a[contains(text(),'1 TB')])[1]//..)[1]"));
		dcheck_box_1tb.click();

		Thread.sleep(3000);

		// DeSelect CheckBox of capacity 120GB
		WebElement dcheck_box_2gb = cd.findElement(By.xpath("((//a[contains(text(),'120')])[1]//..)[1]"));
		dcheck_box_2gb.click();

		System.out.println("Capacity filter is removed now");

		// 1.1 To verify available element after removing capacity Filter
		String randomEle_1 = cd.findElement(By.xpath("//p[contains(text(),'32GB USB 3.0 OTG Pendrive Black')]"))
				.getText();
		System.out.println("1 Item available on storage page without applying Capacity filter is:- " + randomEle_1);

		// 1.2 To verify available element after removing capacity Filter
		String randomEle_2 = cd.findElement(By.xpath("//p[contains(text(),'Strontium Nitro Ammo 128GB')]")).getText();
		System.out.println("1 Item available on storage page without applying Capacity filter is:- " + randomEle_2);
		Thread.sleep(2000);

		cd.navigate().back();
		Thread.sleep(2000);

		System.out.println("Back to Home having Title:- " + cd.getTitle());
		System.out.println("Execution Completed");
		cd.close();
	}
}