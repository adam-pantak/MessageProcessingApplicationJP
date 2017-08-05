package salesproduction;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import apantak.jptechtest.sales.Sale;

public class ProduceSalesTest {
	
	
	@Test
	public void test_addSales() {
		ProduceSales.createTestData();
		// test if 100 sales are produced
		Assert.assertTrue(ProduceSales.availableFruitsList.size() == 90);
		
		// test if the values generated are bigger than 10 and smaller than 21
		for(JsonReceivedMessage receivedMessage : ProduceSales.receivedMessageList) {
			Assert.assertTrue((receivedMessage.getValue().compareTo(new BigDecimal(10)) > 0) && receivedMessage.getValue().compareTo(new BigDecimal(21)) < 0);
		}
	}
}
