package salesproduction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import apantak.jptechtest.sales.Sale;
import apantak.jptechtest.salesprocessor.MessageProcessor;

public class ProduceSales {
	static List<String> availableFruitsList = new ArrayList<String>();
	static List<JsonReceivedMessage> receivedMessageList = new ArrayList<JsonReceivedMessage>();
	
	public static void createTestData() {
		availableFruitsList.add("apple");	
		availableFruitsList.add("raspberry");	
		availableFruitsList.add("pineapple");	
		availableFruitsList.add("cherry");	
		availableFruitsList.add("peach");	
		availableFruitsList.add("watermelon");	
		availableFruitsList.add("blackberry");	
		availableFruitsList.add("banana");	
		availableFruitsList.add("strawberry");	
		availableFruitsList.add("mango");
		
		for(String fruit : availableFruitsList) {
			for(int i = 0; i < 9; i++) {
				if(i < 3) {
					// generated value will be between 11 and 20
					receivedMessageList.add(new JsonReceivedMessage(fruit, new BigDecimal(Math.floor(Math.random()*10 + 11)), null, null, null));
				} else if (i < 6) {
					// generated quantity will be between 1 and 5
					receivedMessageList.add(new JsonReceivedMessage(fruit, new BigDecimal(Math.floor(Math.random()*10 + 11)), (int) Math.floor(Math.random()*5 + 1), null, null));
				} else if(i == 6) {
					receivedMessageList.add(new JsonReceivedMessage(fruit, new BigDecimal(Math.floor(Math.random()*10 + 11)), null, "add", new BigDecimal(10)));
				} else if(i == 7) {
					receivedMessageList.add(new JsonReceivedMessage(fruit, new BigDecimal(Math.floor(Math.random()*10 + 11)), null, "subtract", new BigDecimal(5)));
				} else if(i == 8) {
					receivedMessageList.add(new JsonReceivedMessage(fruit, new BigDecimal(Math.floor(Math.random()*10 + 11)), null, "multiply", new BigDecimal(2)));
				}
			}
		}
		
	}
	
	
	public static void produce() {
		createTestData();
		MessageProcessor processor = new MessageProcessor();
		for(JsonReceivedMessage receivedMessage : receivedMessageList) {
			processor.processSale(receivedMessage);
		}
		
	}
}
