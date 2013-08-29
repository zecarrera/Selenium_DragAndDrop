package br.org.cesar.common;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



/*
 * Executa todas as acoes na pagina Inicial
 */
public class Demo2Page {

	/*
	 * Instancia privada do webDriver que vira da suite de teste
	 */
	private static final WebDriver driver;
	private static final WebDriverWait wait;

	
	/*
	 * Construtor que ira adicionar a instancia do WebDriver para utilizacao dos metodos
	 */
	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}
	
	private static final WebElement sourceItem = driver.findElement(By.id("draggable"));
	
	public Demo2Page() {
	}

	/**
	 * Drag red box to another element
	 */
	public static void dragItemToLocation(WebElement element){
		Actions builder = new Actions(driver);
		//Action dragAndDrop = builder.clickAndHold(redBox).moveToElement(element).release(element).build();
		Action dragAndDrop = builder.dragAndDrop(sourceItem, element).build();
		dragAndDrop.perform();
	}	
	
	/**
	 * Drag red box to another element with specific offset
	 */
	public static void dragItemToPosition(Integer X, Integer Y){
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.dragAndDropBy(sourceItem, X, Y).build();
		dragAndDrop.perform();
	}
	
	/**
	 * Asserts initial text of the target item
	 */
	public static void assertTargetTextBeforeDrop(){
		Assert.assertEquals("Drop here", driver.findElement(By.cssSelector("#droppable > p")).getText());
	}
	
	/**
	 * Asserts final text of the target item
	 */
	public static void assertTargetTextAfterDrop(){
		Assert.assertEquals("Dropped!", driver.findElement(By.cssSelector("#droppable > p")).getText());
	}
}