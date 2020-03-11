package com.testing.UIFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameWebKeyWord {

	WebDriver driver;

	WebElement element;

	public FrameWebKeyWord() {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		// 通过创建driver，启动谷歌浏览器、
		driver = new ChromeDriver();
	}

	/**
	 * 访问url
	 * 
	 * @param url
	 */
	public void visit(String url) {
		driver.get(url);
	}

	/**
	 * 通过BYname定位元素，并输入值
	 * 
	 * @param name
	 * @param value
	 */
	public void searchByName(String name, String value) {
		element = driver.findElement(By.name(name));
		element.sendKeys(value);
	}

	/**
	 * 提交
	 */
	public void submit() {
		element.submit();
	}

	/**
	 * 关闭浏览器
	 */
	public void closeBrower() {
		driver.quit();
	}

	/**
	 * 通过title断言
	 * 
	 * @param title
	 */
	public void assertEqualByTitle(String title) {
		if (driver.getTitle().contains(title)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	/**
	 * 线程强制等待
	 * 
	 * @param millistimes
	 */
	public void sleep(String millistimes) {
		int millis = Integer.parseInt(millistimes) * 1000;
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
