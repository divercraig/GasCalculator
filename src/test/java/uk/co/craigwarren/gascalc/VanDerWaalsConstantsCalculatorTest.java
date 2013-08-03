/**
 * 
 */
package uk.co.craigwarren.gascalc;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author craig
 *
 */
public class VanDerWaalsConstantsCalculatorTest {
	
	private static final double EXPECTED_ELASTICITY = 1.3725;
	private static final double EXPECTED_VOLUME = 0.0372;

	@Test
	public void testCalculateAirElasticity(){
		Gas air = new Gas(21, 79);
		VanDerWaalsConstantsCalculator calc = new VanDerWaalsConstantsCalculator();
		double elasticity = calc.getVdwElasticity(air);
		assertEquals("The Elasticity of air is not as expected", EXPECTED_ELASTICITY, elasticity,0.01);
	}
	
	@Test
	public void testCalculatAirVolume(){
		Gas air = new Gas(21, 79);
		VanDerWaalsConstantsCalculator calc = new VanDerWaalsConstantsCalculator();
		double volume = calc.getVdwVolume(air);
		assertEquals("The Volume of air is not as expected", EXPECTED_VOLUME,volume,0.01);
	}
}
