package gla.cs.joose.coursework.invmgt.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Task10 {
	
	long barcode;
	String itemName;
	String itemType_s;
	int qty;
	String supplier;
	String desc;
	
	@Before
	public void setUpItem() {
		barcode = 1234;
		itemName = "laptop";
		itemType_s = "electronic";
		qty = 3;
		supplier = "Lenovo";
		desc = "a laptop";
	}
	
	@Test
	public void testEmptyNameNotAllowed() {
		itemName = "";
		boolean emptyNameAllowed = ItemFactory.addItem(barcode, itemName, itemType_s, qty, supplier, desc);
		assertFalse(emptyNameAllowed);
	}
	
	@Test
	public void testNameSpecialCharsNotAllowed() {
		itemName = "lap'/*top?!";
		boolean specialCharsAllowed = ItemFactory.addItem(barcode, itemName, itemType_s, qty, supplier, desc);
		assertFalse(specialCharsAllowed);
	}

}
