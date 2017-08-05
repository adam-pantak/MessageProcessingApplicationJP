package apantak.jptechtest.sales;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import apantak.jptechtest.enums.AdjustmentOperations;

public class SalesController {

	public static List<Sale> salesList = new ArrayList<Sale>();

	public static Map<String, ArrayList<String>> listOfAdjustmentsMade = new HashMap<String,ArrayList<String>>();
	
	public static void logAdjustmentsMade(String product, AdjustmentOperations operation, BigDecimal adjustmentValue) {
		if(!listOfAdjustmentsMade.containsKey(product)) {
			listOfAdjustmentsMade.put(product, new ArrayList<String>());
		}
		if(AdjustmentOperations.MULTIPLY.equals(operation)) {
			listOfAdjustmentsMade.get(product).add("[" + System.currentTimeMillis() + "] price was multiplied by " + adjustmentValue.toString());
		} else {
			listOfAdjustmentsMade.get(product).add("[" + System.currentTimeMillis() + "] " + adjustmentValue.toString() + " pence was " + operation.toString() + "ed");
		}
	}
	
	
}
