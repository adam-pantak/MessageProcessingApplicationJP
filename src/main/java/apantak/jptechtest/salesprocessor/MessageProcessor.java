package apantak.jptechtest.salesprocessor;

import apantak.jptechtest.messages.Message;
import apantak.jptechtest.sales.SalesController;
import salesproduction.JsonReceivedMessage;

public class MessageProcessor {
	private static final int SALES_LIMIT = 50;
	public static final int LOG_INTERVAL = 10;
	
	public void processSale(JsonReceivedMessage receivedMessage) {
		// if 50 sales reached, stop processing and log a detailing report
		if(SalesController.controlSalesLimit(SALES_LIMIT, LOG_INTERVAL)) return;
		// get the right instance of a Message, depending on the Json data received
		Message message = MessageFactory.getMessage(receivedMessage);
		// process message according to the type received
		message.processMessage();
		// every 10th message received log a report detailing the number of sales of each product and total value.
		SalesController.logReportEveryInterval(LOG_INTERVAL);
	}
}
