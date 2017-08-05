package salesproduction;

import java.math.BigDecimal;


// Assuming the external interface provides data in a JSON format, this class captures received data
public class JsonReceivedMessage {
	private String product;
	private BigDecimal value;
	private Integer quantity;
	private String adjustmentOperation;
	private BigDecimal adjustmentValue;
	
	
	
	public JsonReceivedMessage(String product, BigDecimal value, Integer quantity, String adjustmentOperation, BigDecimal adjustmentValue) {
		super();
		this.product = product;
		this.value = value;
		this.quantity = quantity;
		this.adjustmentOperation = adjustmentOperation;
		this.adjustmentValue = adjustmentValue;
	}
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getAdjustmentOperation() {
		return adjustmentOperation;
	}
	public void setAdjustmentOperation(String adjustmentOperation) {
		this.adjustmentOperation = adjustmentOperation;
	}
	public BigDecimal getAdjustmentValue() {
		return adjustmentValue;
	}
	public void setAdjustmentValue(BigDecimal adjustmentValue) {
		this.adjustmentValue = adjustmentValue;
	}
	
}
