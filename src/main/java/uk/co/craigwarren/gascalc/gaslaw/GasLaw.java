/**
 * 
 */
package uk.co.craigwarren.gascalc.gaslaw;

/**
 * @author craig
 *
 */
public abstract class GasLaw {

	protected static final double gasConstantBarLitres = 0.08206f;

	public abstract double getPressureBar(double volumeLitres, double molsOfGas, double temperatureKelvin);
	
	public abstract double getVolumeLitres(double pressureBar, double molsOfGas, double temperatureKelvin);
	
	public abstract double getMolsOfGas(double pressureBar, double volumeLitres, double temperatureKelvin);
	
	public abstract double getTemperatureKelvin(double pressureBar, double volumeLitres, double molsOfGas);
	
}
