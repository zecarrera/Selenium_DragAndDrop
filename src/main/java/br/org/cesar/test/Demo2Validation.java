package br.org.cesar.test;

import org.junit.Test;
import org.openqa.selenium.By;

import br.org.cesar.common.Demo2Page;

public class Demo2Validation extends BaseTestcase{
	/**
	 * Example app is from Selenium 2 for beginners book
	 * Simple drag and drop app
	 */

	
	/**
	 *  Drags item to yellow block 
	 */
	@Test
	public void dragToTargetBlock() {
		Demo2Page.assertTargetTextBeforeDrop();
		Demo2Page.dragItemToLocation();
		Demo2Page.assertTargetTextAfterDrop();
	}
	
	/**
	 *  Drags item to specified position
	 *  10, 10 nao é suficiente para chegar ao alvo
	 */
	@Test
	public void dragToSpecifiedPosition() {
		Demo2Page.assertTargetTextBeforeDrop();
		Demo2Page.dragItemToPosition(10, 10);
		Demo2Page.assertTargetTextBeforeDrop();
	}
}
