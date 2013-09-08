/**
 * 
 */
package uk.co.craigwarren.gascalc;

import org.junit.Before;

/**
 * @author craig
 *
 */
public class RealGasLawTest extends GasLawTest{
	
	
	
	@Override
	public double getTestQuantity() {
		return 85.04;
	}

	@Before
	public void setup(){
		Gas testGas = new Gas(21, 79);
		VanDerWaalsConstantsCalculator testConstCalc = new VanDerWaalsConstantsCalculator();
		NewtonRaphson testNewtonRaphson = new NewtonRaphson();
		VanDerWaalsFunctionFactory testVDWFF = new VanDerWaalsFunctionFactory();
		IdealGasLaw testIdealGasLaws = new IdealGasLaw();
		gasLawUnderTest = new RealGasLaw(testGas, testConstCalc, testNewtonRaphson, testVDWFF, testIdealGasLaws);
	}

}
