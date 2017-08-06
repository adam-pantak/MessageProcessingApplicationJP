package salesproduction;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ProduceSalesTest {
	
	
	@Test
	public void test_addSales() {
		ProduceSales.availableFruitsList = new ArrayList<String>();
		ProduceSales.receivedMessageList = new ArrayList<JsonReceivedMessage>();
		DecimalFormat f = new DecimalFormat("##.00");
		ProduceSales.createTestData();
		// test if 90 sales are produced
		Assert.assertEquals(90, ProduceSales.receivedMessageList.size());
		
		// test if the values generated are greater than 9 and smaller than 21
		for(JsonReceivedMessage receivedMessage : ProduceSales.receivedMessageList) {
			System.out.println(receivedMessage.getValue());
			Assert.assertEquals(true, (receivedMessage.getValue().compareTo(new BigDecimal(f.format(0.09))) > 0) && (receivedMessage.getValue().compareTo(new BigDecimal(f.format(0.21))) < 0));
		}
	}
}
