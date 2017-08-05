package apantak.jptechtest.messages;

import java.math.BigDecimal;

public class MessageTypeTwo extends MessageTypeOne {
	int quantity;
	
	public MessageTypeTwo(String product, BigDecimal value, int quantity) {
		super(product, value);
		this.quantity = quantity;
	}

	@Override
	public void processMessage() {
		for(int i = 0; i < quantity; i++) {
			super.processMessage();
		}
	}
}
