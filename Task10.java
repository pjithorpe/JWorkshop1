package gla.cs.joose.coursework.invmgt.model;

import static org.junit.Assert.*;

import org.junit.After;
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
	public void testEmptyNameNotAllowedCase1() {
		itemName = "";
		boolean emptyNameAllowed = ItemFactory.addItem(barcode, itemName, itemType_s, qty, supplier, desc);
		assertEquals(false, emptyNameAllowed);
	}
	
	@Test
	public void testNameSpecialCharsNotAllowedCase2() {
		itemName = "lap'/*top?!";
		boolean specialCharsAllowed = ItemFactory.addItem(barcode, itemName, itemType_s, qty, supplier, desc);
		assertEquals(false, specialCharsAllowed);
	}
	
	//Two items should not be allowed to have the same name and same supplier
	@Test
	public void testRepeatedNameNotAllowedCase3() {
		barcode = 6767;
		ItemFactory.addItem(barcode, itemName, itemType_s, qty, supplier, desc);
		
		barcode = 3333;
		boolean repeatedItemAllowed = ItemFactory.addItem(barcode, itemName, itemType_s, qty, supplier, desc);
		assertEquals(false, repeatedItemAllowed);
	}
	
	@Test(expected=Error.class)
	public void testEmptyBarcodeNotAllowedCase4() {
		boolean emptyBarcodeAllowed = ItemFactory.addItem(null, itemName, itemType_s, qty, supplier, desc);
		fail("Exception not thrown.");
	}
	
	@Test
	public void testRepeatedBarcodeNotAllowedCase5() {
		barcode = 88;
		ItemFactory.addItem(barcode, itemName, itemType_s, qty, supplier, desc);
		
		barcode = 88;
		itemName = "computer";
		supplier = "Asus";
		boolean repeatedItemAllowed = ItemFactory.addItem(barcode, itemName, itemType_s, qty, supplier, desc);
		assertEquals(false, repeatedItemAllowed);
	}
	
	@Test(expected=Error.class)
    public void testQuantitySizeEmptyCase11() {
		boolean lessThanZeroQuantity = ItemFactory.addItem(barcode, itemName, itemType_s, null, supplier, desc);
		fail("Exception not thrown");
    }

    @Test(expected=Error.class)
    public void testQuantityNonNumericCase12() {
    	boolean nonNumericQuantity = ItemFactory.addItem(barcode, itemName, itemType_s, itemName, supplier, desc);
    	fail("Exception not thrown");
    }

    @Test
    public void testQuantityLessThanZeroCase13() {
    	qty = -1;
    	boolean lessThanZeroQuantity = ItemFactory.addItem(barcode, itemName, itemType_s, qty, supplier, desc);
    	assertFalse(lessThanZeroQuantity);
    }

    @Test
    public void testQuantityOverOneHundredCase14() {
    	qty = 101;
    	boolean overOneHundredQuantity = ItemFactory.addItem(barcode, itemName, itemType_s, qty, supplier, desc);
    	assertFalse(overOneHundredQuantity);
    }

    @Test
    public void testQuantityZeroCase15() {
    	qty = 0;
    	boolean zeroQuantity = ItemFactory.addItem(barcode, itemName, itemType_s, qty, supplier, desc);
    	assertTrue(zeroQuantity);
    }

}
