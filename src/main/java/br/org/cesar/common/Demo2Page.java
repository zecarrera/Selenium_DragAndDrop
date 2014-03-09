package br.org.cesar.common;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

	
	static WebElement sourceItem = driver.findElement(By.id("draggable"));
	static By targetBox = By.id("droppable");
	static By targetBoxText = By.cssSelector("#droppable > p");

	
	public Demo2Page() {
	}

	/**
	 * Drag red box to another element
	 */
	public static void dragItemToLocation(){
		WebElement element = driver.findElement(targetBox);
		Actions builder = new Actions(driver);
//		Action dragAndDrop = builder.clickAndHold(sourceItem).
//				moveToElement(element).
//				release(element).
//				build();
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
		assertThat("T�tulo da p�gina Incorreto", driver.findElement(targetBoxText).getText(), is("Drop here")); 
	}
	
	/**
	 * Asserts final text of the target item
	 */
	public static void assertTargetTextAfterDrop(){
		assertThat("T�tulo da p�gina Incorreto", driver.findElement(targetBoxText).getText(), is("Dropped!")); 

	}
}