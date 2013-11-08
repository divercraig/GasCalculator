/**
 * 
 */
package uk.co.craigwarren.gascalc;

import uk.co.craigwarren.gascalc.gaslaw.GasLaw;
import uk.co.craigwarren.gascalc.gaslaw.IdealGasLaw;
import uk.co.craigwarren.gascalc.gaslaw.NewtonRaphson;
import uk.co.craigwarren.gascalc.gaslaw.RealGasLaw;
import uk.co.craigwarren.gascalc.gaslaw.VanDerWaalsConstantsCalculator;
import uk.co.craigwarren.gascalc.gaslaw.VanDerWaalsFunctionFactory;
import uk.co.craigwarren.gascalc.model.Element;
import uk.co.craigwarren.gascalc.model.Gas;

/**
 * @author craig
 *
 */
public class TopUpScenario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Gas thirtyTwoPercent = new Gas(32, 68);
		VanDerWaalsConstantsCalculator constantCalc = new VanDerWaalsConstantsCalculator();
		NewtonRaphson newton = new NewtonRaphson();
		VanDerWaalsFunctionFactory functionFactory = new VanDerWaalsFunctionFactory();
		IdealGasLaw idealGasLaw = new IdealGasLaw();
		GasLaw realGasLaw = new RealGasLaw(thirtyTwoPercent, constantCalc, newton, functionFactory, idealGasLaw);
		UnitConverter unitConverter = new UnitConverter();
		
		Gas twentySixPercent = new Gas(26, 74);
		GasLaw currentRealGasLaw = new RealGasLaw(twentySixPercent, constantCalc, newton, functionFactory, idealGasLaw);

		
		System.out.println("32 percent from 150 bar of 26%");
		
		double molsCurrent = currentRealGasLaw.getMolsOfGas(150, 12, unitConverter.celciusToKelvin(20f));
		System.out.println(String.format("Current Mols %f", molsCurrent));
		
		double oxygenMolsCurrent = molsCurrent * twentySixPercent.getDecimalRatio(Element.OXYGEN);
		System.out.println(String.format("Current Mols of Oxygen %f",oxygenMolsCurrent));
		
		double nitrogenMolsCurrent = molsCurrent * twentySixPercent.getDecimalRatio(Element.NITROGEN);
		System.out.println(String.format("Current Mols of Nitrogen %f", nitrogenMolsCurrent));		
		
		
		double molsTarget = realGasLaw.getMolsOfGas(232, 12, unitConverter.celciusToKelvin(20f));
		System.out.println(String.format("Target Mols Required %f", molsTarget));
		
		double oxygenMolsTarget = molsTarget * thirtyTwoPercent.getDecimalRatio(Element.OXYGEN);
		System.out.println(String.format("Target Mols of Oxygen %f",oxygenMolsTarget));
		
		double nitrogenMolsTarget = molsTarget * thirtyTwoPercent.getDecimalRatio(Element.NITROGEN);
		System.out.println(String.format("Target Mols of Nitrogen %f", nitrogenMolsTarget));
		
		double oxygenMolsRequired = oxygenMolsTarget-oxygenMolsCurrent;
		double nitrogenMolsRequired = nitrogenMolsTarget - nitrogenMolsCurrent;
		
		System.out.println(String.format("Required Mols Oxygen %f",oxygenMolsRequired));
		System.out.println(String.format("Required Mols Nitrogen %f",nitrogenMolsRequired));
		
		double molsOfOxygenInAir = (nitrogenMolsRequired/Gas.air().getPercentage(Element.NITROGEN))*Gas.air().getPercentageOxygen();
		System.out.println(String.format("Free Oxygen %f",molsOfOxygenInAir));
		
		double extraOxygenNeeded = oxygenMolsRequired-molsOfOxygenInAir;
		System.out.println(String.format("Extra Oxygen %f",extraOxygenNeeded));
		
		double oxygenPressure = currentRealGasLaw.getPressureBar(12, extraOxygenNeeded, unitConverter.celciusToKelvin(20));
		System.out.println(String.format("Topup Oxygen Pressure %f",oxygenPressure));

	}

}
