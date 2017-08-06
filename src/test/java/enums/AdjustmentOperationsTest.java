package enums;

import org.junit.Assert;
import org.junit.Test;

import apantak.jptechtest.enums.AdjustmentOperations;


public class AdjustmentOperationsTest {
	
	@Test
	public void test_getEnumFromString() {
		Assert.assertEquals(AdjustmentOperations.ADD, AdjustmentOperations.getEnumFromString("add"));
		Assert.assertEquals(AdjustmentOperations.SUBTRACT, AdjustmentOperations.getEnumFromString("subtract"));
		Assert.assertEquals(AdjustmentOperations.MULTIPLY, AdjustmentOperations.getEnumFromString("multiply"));
	}
}
