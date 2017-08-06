package apantak.jptechtest.sales;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import apantak.jptechtest.enums.AdjustmentOperations;

public class SalesController {
	int numberOfSalesLogged = 0;
	private static boolean isLimitReached;
	
	public static List<Sale> salesList = new ArrayList<Sale>();

	public static Map<String, ArrayList<String>> listOfAdjustmentsMade = new HashMap<String,ArrayList<String>>();
	
	public static void logAdjustmentsMade(String product, AdjustmentOperations operation, BigDecimal adjustmentValue) {
		if(!listOfAdjustmentsMade.containsKey(product)) {
			listOfAdjustmentsMade.put(product, new ArrayList<String>());
		}
		if(AdjustmentOperations.MULTIPLY.equals(operation)) {
			listOfAdjustmentsMade.get(product).add("[" + Calendar.getInstance().getTime() + "] price of [" + product +"] was multiplied by " + adjustmentValue.toString());
		} else if (AdjustmentOperations.ADD.equals(operation)){
			listOfAdjustmentsMade.get(product).add("[" + Calendar.getInstance().getTime() + "] £" + adjustmentValue.toString() + " were " + operation.toString() + "ed to each [" + product + "] sold");
		} else {
			listOfAdjustmentsMade.get(product).add("[" + Calendar.getInstance().getTime() + "] £" + adjustmentValue.toString() + " were " + operation.toString() + "ed from each [" + product + "] sold");
		}
	}

	public static BigDecimal getTotalForSales(ArrayList<BigDecimal> allSales) {
		BigDecimal totalValue = new BigDecimal(0);
		for(BigDecimal value : allSales) {
			totalValue = totalValue.add(value);
		}
		return totalValue;
	}

	public static void logReportEveryInterval(int logInterval) {
		if(SalesController.salesList.size() % logInterval == 0) {
			// logging time and reaching the interval
			System.out.println("[" + Calendar.getInstance().getTime() + "] [" + logInterval + "] messages received ");
			// log a report detailing the number of sales of each product and their total value.
			Map<String, ArrayList<BigDecimal>> salesPerProduct = new HashMap<String, ArrayList<BigDecimal>>();
			for(Sale sale : SalesController.salesList) {
				if(!salesPerProduct.containsKey(sale.getType())) {
					salesPerProduct.put(sale.getType(), new ArrayList<BigDecimal>());
				}
				salesPerProduct.get(sale.getType()).add(sale.getValue());
			}
			
			for(String product : salesPerProduct.keySet()) {
				System.out.println("[" + salesPerProduct.get(product).size() + "] sales recorded for product [" + product + "] for a total value of [" + getCurrency(SalesController.getTotalForSales(salesPerProduct.get(product))) + "]");
			}
			
		}
	}

	public static String getCurrency(BigDecimal bd) {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.UK); 
		return numberFormat.format(bd);
	}
	
	public static boolean controlSalesLimit(int salesLimit, int logInterval) {
		if(isLimitReached) {
			return true;
		}
		
		if(SalesController.salesList.size() >= salesLimit) {
			// log a final interval of sales 
			logReportEveryInterval(logInterval);
			// log that it is pausing, stop accepting new messages and log a report of the adjustments that have been made to each sale type while the application was running.
			System.out.println(salesLimit + " sales reached. Pausing...");
			for(String product : SalesController.listOfAdjustmentsMade.keySet()) {
				for(String adjustment : SalesController.listOfAdjustmentsMade.get(product)) {
					System.out.println(product + ": " + adjustment);
				}
			}
			isLimitReached = true;
			return true;
		}
		return false;
	}
	
}
