/**
 * 
 */
package uk.co.craigwarren.gascalc.gaslaw;

import org.junit.Before;

import uk.co.craigwarren.gascalc.gaslaw.IdealGasLaw;

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
