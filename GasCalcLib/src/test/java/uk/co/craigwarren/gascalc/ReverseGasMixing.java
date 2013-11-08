/**
 * 
 */
package uk.co.craigwarren.gascalc;

import uk.co.craigwarren.gascalc.gaslaw.IdealGasLaw;
import uk.co.craigwarren.gascalc.model.Element;
import uk.co.craigwarren.gascalc.model.Gas;

/**
 * @author craig
 *
 */
public class ReverseGasMixing {

	/**
	 * Work out the mols of a starting gas which can be mixed with Air  to
	 * result in a specific number of mols of a target gas.
	 * 
	 * Ao(Tm - X) + (Go*X) = To * Tm
	 * 
	 * where
	 * Ao = the decimal value of O2 in air
	 * Go = the decimal value of O2 in the initial gas
	 * Tm = the target mols of the target gas
	 * To = the decimal value of O2 in the target gas
	 * 
	 * X = the number of mols of the initial gas that when mixed will result the correct
	 * mix of the target gas
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		Gas gas1 = new Gas(40,60);
		
		Gas target = new Gas(30,70);
		
		Gas air = Gas.air();
		
		Element element = Element.OXYGEN;
		
		Double targetMols = 114.79155515849408;
		
		double part1 = target.getDecimalRatio(element)*targetMols;
		double part2 = air.getDecimalRatio(element)* targetMols;
		double part3 = gas1.getDecimalRatio(element) - air.getDecimalRatio(element);
		
		double answer = (part1 - part2) / part3;
		System.out.println("answer = "+answer);
		
		IdealGasLaw gasLaw = new IdealGasLaw();
		
		
		double pressure = gasLaw.getPressureBar(12, answer, UnitConverter.celciusToKelvin(20));
		System.out.println("Pressure = "+pressure);
	}

}
