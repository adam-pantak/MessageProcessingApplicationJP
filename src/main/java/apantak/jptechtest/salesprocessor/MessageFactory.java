package apantak.jptechtest.salesprocessor;

import apantak.jptechtest.enums.AdjustmentOperations;
import apantak.jptechtest.messages.Message;
import apantak.jptechtest.messages.MessageTypeOne;
import apantak.jptechtest.messages.MessageTypeThree;
import apantak.jptechtest.messages.MessageTypeTwo;
import salesproduction.JsonReceivedMessage;

public class MessageFactory {
	
	public static Message getMessage(JsonReceivedMessage message) {
		
		if(message.getAdjustmentOperation() != null && message.getAdjustmentValue() != null) {
			return new MessageTypeThree(message.getProduct(), message.getValue(), AdjustmentOperations.getEnumFromString(message.getAdjustmentOperation()), message.getAdjustmentValue());
		} else if(message.getQuantity() != null) {
			return new MessageTypeTwo(message.getProduct(), message.getValue(), message.getQuantity());
		} else {
			return new MessageTypeOne(message.getProduct(), message.getValue());
		}
	}
}
