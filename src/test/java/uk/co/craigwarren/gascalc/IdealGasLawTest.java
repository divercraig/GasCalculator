/**
 * 
 */
package uk.co.craigwarren.gascalc;

import org.junit.Before;

/**
 * @author craig
 *
 */
public class IdealGasLawTest extends GasLawTest{	
	@Before
	public void setup(){
		gasLawUnderTest = new IdealGasLaw();
	}
	
}
