package apantak.jptechtest.messages;

import java.math.BigDecimal;

import apantak.jptechtest.sales.Sale;
import apantak.jptechtest.sales.SalesController;

public class MessageTypeOne implements Message {

	String product;
	BigDecimal value;
	
	public MessageTypeOne(String product, BigDecimal value) {
		super();
		this.product = product;
		this.value = value;
	}


	public void processMessage() {
		SalesController.salesList.add(new Sale(product, value));
//		System.out.println("Sale recorded for product: [" + product + "] valued at: [" + value + "]");
	}

}
