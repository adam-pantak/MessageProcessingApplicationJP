package salesprocessor;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import apantak.jptechtest.messages.Message;
import apantak.jptechtest.messages.MessageTypeOne;
import apantak.jptechtest.messages.MessageTypeThree;
import apantak.jptechtest.messages.MessageTypeTwo;
import apantak.jptechtest.salesprocessor.MessageFactory;
import salesproduction.JsonReceivedMessage;

public class MessageFactoryTest {
	
	@Test
	public void test_getMessageTypeThree() {
		JsonReceivedMessage jsonMessage = new JsonReceivedMessage("add", new BigDecimal(30), null, "apple", new BigDecimal(10));
		
		Message message = MessageFactory.getMessage(jsonMessage);
		assertThat(message.getClass(), instanceOf(MessageTypeThree.class));
	}
	
	@Test
	public void test_getMessageTypeTwo() {
		JsonReceivedMessage jsonMessage = new JsonReceivedMessage("add", new BigDecimal(30), 3, null, null);

		Message message = MessageFactory.getMessage(jsonMessage);
		assertThat(message.getClass(), instanceOf(MessageTypeTwo.class));
	}
	
	@Test
	public void test_getMessageTypeOne() {
		JsonReceivedMessage jsonMessage = new JsonReceivedMessage("add", new BigDecimal(30), null, null, null);
		
		Message message = MessageFactory.getMessage(jsonMessage);
		assertThat(message.getClass(), instanceOf(MessageTypeOne.class));
		
	}
}
