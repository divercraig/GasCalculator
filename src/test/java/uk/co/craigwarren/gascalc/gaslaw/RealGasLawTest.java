/**
 * 
 */
package uk.co.craigwarren.gascalc.gaslaw;

import org.junit.Before;

import uk.co.craigwarren.gascalc.gaslaw.IdealGasLaw;
import uk.co.craigwarren.gascalc.gaslaw.NewtonRaphson;
import uk.co.craigwarren.gascalc.gaslaw.RealGasLaw;
import uk.co.craigwarren.gascalc.gaslaw.VanDerWaalsConstantsCalculator;
import uk.co.craigwarren.gascalc.gaslaw.VanDerWaalsFunctionFactory;
import uk.co.craigwarren.gascalc.model.Gas;

/**
 * @author craig
 *
 */
public class RealGasLawTest extends GasLawTest{
	
	
	
	@Override
	public double getTestQuantity() {
		return 85.40888;
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
