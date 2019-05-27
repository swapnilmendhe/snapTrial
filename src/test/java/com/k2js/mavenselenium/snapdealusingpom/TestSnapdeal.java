package com.k2js.mavenselenium.snapdealusingpom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSnapdeal {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver cd = new ChromeDriver();
		cd.get("https://www.snapdeal.com/");
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		PageObjects po = new PageObjects(cd);
		JavascriptExecutor js = (JavascriptExecutor) cd;

		po.clickOnCompGame().click();
		System.out.println("1.Click On Computer and Gaming");

		po.viewAll().click();
		System.out.println("2.Click On View All of Storage");

		po.checkBox_1tb().click();
		Util.sleepTime(4000);
		po.checkBox_120gb().click();
		System.out.println("3.Capacity Filter for 2 CheckBox applied");

		// Verify CheckBox Applied or not
		boolean cb1 = po.checkBoxValidation1TB().isDisplayed();
		System.out.println("4.CheckBox for 1TB applied Sucessfully:-" + cb1);

		boolean cb2 = po.checkBoxValidation120GB().isDisplayed();
		System.out.println("5.CheckBox for 120GB applied Sucessfully:-" + cb2);
		Util.sleepTime(4000);

		System.out.println(
				"6.Verify 1TB product avaibility after filtering:-" + po.firstElementVerifyAfterFilter().getText());

		Util.sleepTime(4000);

		js.executeScript("scroll(0,1200)");
		Util.sleepTime(2000);
		js.executeScript("scroll(0,-1200)");

		System.out.println(
				"7.Verify 120GB product avaibility after filtering:-" + po.secElementVerifyAfterFilter().getText());

		// Remove applied Capacity Filter
		po.checkBox_1tb().click();
		Util.sleepTime(3000);
		po.checkBox_120gb().click();

		// 1.1 To verify available element after removing capacity Filter
		System.out.println("8.Available element after removing capacity Filter:-" + po.verifyUnsortedEle1().getText());
		System.out.println("9.Available element after removing capacity Filter:-" + po.verifyUnsortedEle2().getText());

		cd.navigate().back();
		Util.sleepTime(2000);
		System.out.println("Back to Home having Title:- " + cd.getTitle());// HomePage
		System.out.println("Execution Completed");

		cd.quit();

	}
}