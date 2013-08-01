/**
 * 
 */
package uk.co.craigwarren.gascalc;

/**
 * Class which can perform the ideal gas calculations for Bar and Litres using the formulae
 * 
 * PV = nRT 
 * 
 * where:
 * P is the pressure the g is the gas is stored under in Atmospheres (Bar)
 * V is the volume the gas occupies in Litres
 * n is the number of mols of gas
 * R is the idea gas constant used for Bars and Litres (0.0821)
 * T is the temperature the ambient pressure of the gas in degrees kelvin
 *
 * @author craig
 *
 */
public class IdealGasLaw extends GasLaw {
	
	@Override
	public float getPressureBar(float volumeLitres, float molsOfGas, float temperatureKelvin){
		return (molsOfGas * gasConstantBarLitres * temperatureKelvin)/volumeLitres;
	}
	
	@Override
	public float getVolumeLitres(float pressureBar, float molsOfGas, float temperatureKelvin){
		return (molsOfGas * gasConstantBarLitres * temperatureKelvin)/pressureBar;
	}
	
	@Override
	public float getMolsOfGas(float pressureBar, float volumeLitres, float temperatureKelvin){
		return (pressureBar * volumeLitres)/ (gasConstantBarLitres * temperatureKelvin);
	}
	
	@Override
	public float getTemperatureKelvin(float pressureBar, float volumeLitres, float molsOfGas){
		return (pressureBar * volumeLitres) / (gasConstantBarLitres * molsOfGas);
	}
}