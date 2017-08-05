package apantak.jptechtest.messages;

import java.math.BigDecimal;

import apantak.jptechtest.enums.AdjustmentOperations;
import apantak.jptechtest.sales.Sale;
import apantak.jptechtest.sales.SalesController;

public class MessageTypeThree extends MessageTypeOne {

	AdjustmentOperations operation;
	BigDecimal adjustmentValue;

	
	public MessageTypeThree(String product, BigDecimal value, AdjustmentOperations operation, BigDecimal adjustmentValue) {
		super(product, value);
		this.operation = operation;
		this.adjustmentValue = adjustmentValue;
	}

	@Override
	public void processMessage() {
		super.processMessage();
		
		for(Sale sale : SalesController.salesList) {
			if(sale.getType().equals(product)) {
				if(operation.equals(AdjustmentOperations.ADD)) {
					sale.getValue().add(adjustmentValue);
				} else if (operation.equals(AdjustmentOperations.SUBTRACT)) {
					sale.getValue().subtract(adjustmentValue);
				} else if (operation.equals(AdjustmentOperations.MULTIPLY)) {
					sale.getValue().multiply(adjustmentValue);
				}
			}
		}
		SalesController.logAdjustmentsMade(product, operation, adjustmentValue);
	}

}
