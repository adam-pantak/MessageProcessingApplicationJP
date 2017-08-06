package messages;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import apantak.jptechtest.enums.AdjustmentOperations;
import apantak.jptechtest.messages.Message;
import apantak.jptechtest.messages.MessageTypeOne;
import apantak.jptechtest.messages.MessageTypeThree;
import apantak.jptechtest.messages.MessageTypeTwo;
import apantak.jptechtest.sales.Sale;
import apantak.jptechtest.sales.SalesController;

public class MessageTest {
	
	@Test
	public void test_processMessageTypeOne() {
		SalesController.salesList = new ArrayList<Sale>();
		Message message = new MessageTypeOne("apple", new BigDecimal(10));
		message.processMessage();
		Assert.assertEquals("apple", SalesController.salesList.get(0).getType());
		Assert.assertEquals(new BigDecimal(10), SalesController.salesList.get(0).getValue());
	}
	
	@Test
	public void test_processMessageTypeTwo() {
		SalesController.salesList = new ArrayList<Sale>();
		Message message = new MessageTypeTwo("apple", new BigDecimal(10), 5);
		message.processMessage();
		Assert.assertEquals("apple", SalesController.salesList.get(0).getType());
		Assert.assertEquals(new BigDecimal(10), SalesController.salesList.get(0).getValue());
		Assert.assertEquals(5, SalesController.salesList.size());
	}

	@Test
	public void test_processMessageTypeThree() {
		SalesController.salesList = new ArrayList<Sale>();
		SalesController.salesList.add(new Sale("apple", new BigDecimal(10)));
		
		Message message = new MessageTypeThree("apple", new BigDecimal(10), AdjustmentOperations.ADD, new BigDecimal(20));
		message.processMessage();
		Assert.assertEquals("apple", SalesController.salesList.get(0).getType());
		Assert.assertEquals(new BigDecimal(30), SalesController.salesList.get(0).getValue());
		Assert.assertEquals("apple", SalesController.salesList.get(1).getType());
		Assert.assertEquals(new BigDecimal(30), SalesController.salesList.get(1).getValue());
	}
}
