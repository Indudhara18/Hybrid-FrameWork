package com.HybridFW.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils 
{

	public void customWait( WebDriver driver, WebElement element ) 
	{
		WebDriverWait wait = new WebDriverWait(driver, IAutoConstant.ETO);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void customWait( WebDriver driver, String eTitle ) 
	{
		WebDriverWait wait = new WebDriverWait(driver, IAutoConstant.ETO);
		wait.until(ExpectedConditions.titleContains(eTitle));
	}
	
	public void selectElement( WebElement element , int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void selectElement( WebElement element , String vText)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(vText);
	}
	
	public void handleFrameByIndex( WebDriver driver ,int index )
	{
		driver.switchTo().frame(index);
	}
	
	public void handleFrameByWebElement( WebDriver driver , WebElement element )
	{
		driver.switchTo().frame(element);
	}

	public void mouseOverAction(WebDriver driver , WebElement target)
	{
		new Actions(driver).moveToElement(target).perform();
	}
	
	public void doubleClick(WebDriver driver , WebElement target)
	{
		new Actions(driver).doubleClick().perform();
	}
	
	public void rightClick(WebDriver driver , WebElement target)
	{
		new Actions(driver).contextClick(target).perform();
	}
	
}
