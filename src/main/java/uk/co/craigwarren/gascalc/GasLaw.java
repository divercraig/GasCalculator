/**
 * 
 */
package uk.co.craigwarren.gascalc;

/**
 * @author craig
 *
 */
public abstract class GasLaw {

	protected static final float gasConstantBarLitres = 0.0821f;

	public abstract float getPressureBar(float volumeLitres, float molsOfGas, float temperatureKelvin);
	
	public abstract float getVolumeLitres(float pressureBar, float molsOfGas, float temperatureKelvin);
	
	public abstract float getMolsOfGas(float pressureBar, float volumeLitres, float temperatureKelvin);
	
	public abstract float getTemperatureKelvin(float pressureBar, float volumeLitres, float molsOfGas);
	
}
