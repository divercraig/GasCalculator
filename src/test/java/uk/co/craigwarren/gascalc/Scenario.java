package uk.co.craigwarren.gascalc;

import uk.co.craigwarren.gascalc.gaslaw.IdealGasLaw;
import uk.co.craigwarren.gascalc.model.Element;
import uk.co.craigwarren.gascalc.model.Gas;
/**
 * 
 */

/**
 * A scenario using the gas calculations. Not an actual test.
 * 
 * @author craig
 *
 */
public class Scenario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Gas targetGas = new Gas(36, 64);
		IdealGasLaw idealGasLaw = new IdealGasLaw();
		UnitConverter unitConverter = new UnitConverter();
		
		System.out.println("Target Gas "+targetGas);

		double molsTarget = idealGasLaw.getMolsOfGas(210, 15, unitConverter.celciusToKelvin(20f));
		System.out.println(String.format("Target Mols %f", molsTarget));
		
		double oxygenMolsTarget = molsTarget * targetGas.getDecimalRatio(Element.OXYGEN);
		double nitrogenMolsTarget = molsTarget * targetGas.getDecimalRatio(Element.NITROGEN);
		System.out.println(String.format("Target Mols Oxygen %f", oxygenMolsTarget));
		System.out.println(String.format("Target Mols Nitrogen %f", nitrogenMolsTarget));
		
		System.out.println("========================================");
		
		double molsStart = idealGasLaw.getMolsOfGas(1, 15, unitConverter.celciusToKelvin(20f));
		System.out.println(String.format("Start Mols %f", molsStart));
		
		double oxygenMolsStart = molsStart * Gas.air().getDecimalRatio(Element.OXYGEN);
		double nitrogenMolsStart = molsStart * Gas.air().getDecimalRatio(Element.NITROGEN);
		System.out.println(String.format("Start Mols Oxygen %f", oxygenMolsStart));
		System.out.println(String.format("Start Mols Nitrogen %f", nitrogenMolsStart));
		
		double oxygenMolsRequired = oxygenMolsTarget;// - oxygenMolsStart;
		double nitrogenMolsRequired = nitrogenMolsTarget;//s - nitrogenMolsStart;
		
		System.out.println("========================================");
		
		System.out.println(String.format("Required Oxygen %f", oxygenMolsRequired));
		System.out.println(String.format("Required Nitrogen %f", nitrogenMolsRequired));
		
		System.out.println("========================================");
		double molsOfOxygenInAir = (nitrogenMolsRequired/Gas.air().getDecimalRatio(Element.NITROGEN))*Gas.air().getDecimalRatio(Element.OXYGEN);
		System.out.println(String.format("Mols of Free Oxygen from air %f",molsOfOxygenInAir));
		
		double extraOxygenNeeded = oxygenMolsRequired-molsOfOxygenInAir;
		System.out.println(String.format("Mols of Oxygen Minus Air %f",extraOxygenNeeded));
		
		System.out.println("========================================");
		
		double oxygenPressure = idealGasLaw.getPressureBar(15, extraOxygenNeeded, unitConverter.celciusToKelvin(20));

		System.out.println(String.format("Topup Oxygen Pressure %f",oxygenPressure));		
	}

}
