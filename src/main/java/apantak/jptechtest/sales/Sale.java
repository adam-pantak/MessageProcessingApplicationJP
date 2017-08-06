package apantak.jptechtest.sales;

import java.math.BigDecimal;

public class Sale {
	String type;
	BigDecimal value;
	
	public Sale(String type, BigDecimal value) {
		this.type = type;
		this.value = value;
	}
	
	public String getType() {
		return type;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
}
