package salesproduction;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import apantak.jptechtest.salesprocessor.MessageProcessor;

public class ProduceSales {
	static List<String> availableFruitsList = new ArrayList<String>();
	static List<JsonReceivedMessage> receivedMessageList = new ArrayList<JsonReceivedMessage>();
	static DecimalFormat f = new DecimalFormat("##.00");
	
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

		// produce test data - give a total of 90 sales, all of different types
		for(String fruit : availableFruitsList) {
			for(int i = 0; i < 9; i++) {
				if(i < 3) {
					// generated value will be between 10p and 20p
					receivedMessageList.add(new JsonReceivedMessage(fruit, new BigDecimal(f.format((Math.random()*10 + 10 )/100)), null, null, null));
				} else if (i < 6) {
					// generated quantity will be between 1p and 5p
					receivedMessageList.add(new JsonReceivedMessage(fruit, new BigDecimal(f.format((Math.random()*10 + 10 )/100)), (int) Math.floor(Math.random()*5 + 1), null, null));
				} else if(i == 6) {
					receivedMessageList.add(new JsonReceivedMessage(fruit, new BigDecimal(f.format((Math.random()*10 + 10 )/100)), null, "add", new BigDecimal(f.format(0.10))));
				} else if(i == 7) {
					receivedMessageList.add(new JsonReceivedMessage(fruit, new BigDecimal(f.format((Math.random()*10 + 10 )/100)), null, "subtract", new BigDecimal(f.format(0.05))));
				} else if(i == 8) {
					receivedMessageList.add(new JsonReceivedMessage(fruit, new BigDecimal(f.format((Math.random()*10 + 10 )/100)), null, "multiply", new BigDecimal(2)));
				}
			}
		}
		
	}
	
	
	public static void produce() {
		createTestData();
		// shuffle array list to simulate random product sales
		Collections.shuffle(receivedMessageList);
		MessageProcessor processor = new MessageProcessor();
		
		// pass data to the processor one by one to simulate scenario of continuously incoming messages
		for(JsonReceivedMessage receivedMessage : receivedMessageList) {
			processor.processSale(receivedMessage);
		}
		
	}
}
