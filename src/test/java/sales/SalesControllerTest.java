package sales;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import apantak.jptechtest.sales.Sale;
import apantak.jptechtest.sales.SalesController;

public class SalesControllerTest {
	
	@Test
	public void test_getTotalForSales() {
		ArrayList<BigDecimal> allSales = new ArrayList<BigDecimal>();
		for(int i = 0; i < 10; i++) {
			allSales.add(new BigDecimal(10));
		}
		
		Assert.assertEquals(new BigDecimal(100), SalesController.getTotalForSales(allSales));
	}
	
	@Test
	public void test_getCurrency() {
		Assert.assertEquals("£1.00", SalesController.getCurrency(new BigDecimal(1)));
	}
	
	@Test
	public void test_controlSalesLimit() {
		SalesController.salesList = new ArrayList<Sale>();
		SalesController.salesList.add(new Sale("apple", new BigDecimal(10)));
		Assert.assertEquals(false, SalesController.controlSalesLimit(50, 10));
		
		for(int i = 0; i < 51; i++) {
			SalesController.salesList.add(new Sale("apple", new BigDecimal(10)));
		}
		
		Assert.assertEquals(true, SalesController.controlSalesLimit(50, 10));
	}
}
