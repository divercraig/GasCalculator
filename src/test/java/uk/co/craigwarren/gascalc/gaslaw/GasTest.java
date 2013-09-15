/**
 * 
 */
package uk.co.craigwarren.gascalc.gaslaw;

import org.junit.Test;
import org.junit.Assert;

import uk.co.craigwarren.gascalc.model.Element;
import uk.co.craigwarren.gascalc.model.Gas;

/**
 * @author craig
 *
 */
public class GasTest {
	
	
	
	@Test
	public void testGetDecimalRatio(){
		double acceptableError = 0.00001;
		Gas testGas = new Gas(15, 50, 35);
		Assert.assertEquals("Ratio of Oxygen is not correct", 0.15, testGas.getDecimalRatio(Element.OXYGEN),acceptableError);
		Assert.assertEquals("Ratio of Nitrogen is not correct",0.5,testGas.getDecimalRatio(Element.NITROGEN),acceptableError);
		Assert.assertEquals("Ratio of Helium is not correct",0.35,testGas.getDecimalRatio(Element.HELIUM), acceptableError);
	}

}
