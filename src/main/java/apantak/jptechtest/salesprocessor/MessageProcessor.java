package apantak.jptechtest.salesprocessor;

import apantak.jptechtest.messages.Message;
import apantak.jptechtest.sales.SalesController;
import salesproduction.JsonReceivedMessage;

public class MessageProcessor {
	private static final int SALES_LIMIT = 50;
	int numberOfSalesLogged = 0;
	boolean isLimitReached;
	
	public void processSale(JsonReceivedMessage receivedMessage) {
		if(isLimitReached) {
			return;
		}
		
		if(SalesController.salesList.size() == SALES_LIMIT) {
			// log that it is pausing, stop accepting new messages and log a report of the adjustments that have been made to each sale type while the application was running.
			System.out.println(SALES_LIMIT + " sales reached. Pausing...");
			for(String product : SalesController.listOfAdjustmentsMade.keySet()) {
				for(String adjustment : SalesController.listOfAdjustmentsMade.get(product)) {
					System.out.println(product + ": " + adjustment);
				}
			}
			isLimitReached = true;
			return;
		}
		Message message = MessageFactory.getMessage(receivedMessage);
		message.processMessage();
		
		if(SalesController.salesList.size() % 10 == 0) {
			// log a report detailing the number of sales of each product and their total value.
		}
		
	}
	
}
