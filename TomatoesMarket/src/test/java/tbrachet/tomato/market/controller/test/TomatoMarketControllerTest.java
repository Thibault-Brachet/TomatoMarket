package tbrachet.tomato.market.controller.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tbrachet.tomato.market.controller.TomatoMarketController;

public class TomatoMarketControllerTest {

	private TomatoMarketController controller;

	private String size = "";

	@Before
	public void init() {
		controller = new TomatoMarketController();
	}

	/**
	 * Test the size of the response list
 	 */
	@Test
	public void sizeNumericParameterTest() {

		size = "0";

		assertEquals(Integer.parseInt(size), controller.generateTomatoMarketData(size).size());

	}
	
	/**
	 * Test the size of the response list
 	 */
	@Test
	public void sizeNonNumericParameterTest() {

		size = "string";

		assertEquals(0, controller.generateTomatoMarketData(size).size());

	}
	

}
