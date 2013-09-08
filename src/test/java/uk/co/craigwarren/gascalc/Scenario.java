package uk.co.craigwarren.gascalc;
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
		Gas thirtyTwoPercent = new Gas(32, 68);
		VanDerWaalsConstantsCalculator constantCalc = new VanDerWaalsConstantsCalculator();
		NewtonRaphson newton = new NewtonRaphson();
		VanDerWaalsFunctionFactory functionFactory = new VanDerWaalsFunctionFactory();
		IdealGasLaw idealGasLaw = new IdealGasLaw();
		GasLaw realGasLaw = new RealGasLaw(thirtyTwoPercent, constantCalc, newton, functionFactory, idealGasLaw);
		UnitConverter unitConverter = new UnitConverter();
		
		double molsRequired = realGasLaw.getMolsOfGas(232, 12, unitConverter.celciusToKelvin(20f));
		System.out.println(String.format("Mols Required %f", molsRequired));
		
		double oxygenMolsRequired = molsRequired * thirtyTwoPercent.getDecimalRatio(Element.OXYGEN);
		System.out.println(String.format("Mols of Oxygen %f",oxygenMolsRequired));
		
		double nitrogenMolsRequired = molsRequired * thirtyTwoPercent.getDecimalRatio(Element.NITROGEN);
		System.out.println(String.format("Mols of Nitrogen %f", nitrogenMolsRequired));
		
		double heliumMolsRequired = molsRequired * thirtyTwoPercent.getDecimalRatio(Element.HELIUM);
		System.out.println(String.format("Mols of Helium %f",heliumMolsRequired));
		
		double molsOfOxygenInAir = (nitrogenMolsRequired/Gas.air().getPercentage(Element.NITROGEN))*Gas.air().getPercentageOxygen();
		System.out.println(String.format("Free Oxygen %f",molsOfOxygenInAir));
		
		double extraOxygenNeeded = oxygenMolsRequired-molsOfOxygenInAir;
		System.out.println(String.format("Extra Oxygen %f",extraOxygenNeeded));
		
		double oxygenPressure = realGasLaw.getPressureBar(12, extraOxygenNeeded, unitConverter.celciusToKelvin(20));
		long roundedOxygenPressure = Math.round(oxygenPressure);
		System.out.println(String.format("Starting Oxygen Pressure %d",roundedOxygenPressure));
	}

}
