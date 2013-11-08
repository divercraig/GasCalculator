/**
 * 
 */
package uk.co.craigwarren.gascalc.gaslaw;

import uk.co.craigwarren.gascalc.model.Gas;

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
	public double getPressureBar(double volumeLitres, double molsOfGas, double temperatureKelvin){
		return (molsOfGas * gasConstantBarLitres * temperatureKelvin)/volumeLitres;
	}
	
	@Override
	public double getVolumeLitres(double pressureBar, double molsOfGas, double temperatureKelvin){
		return (molsOfGas * gasConstantBarLitres * temperatureKelvin)/pressureBar;
	}
	
	@Override
	public double getMolsOfGas(double pressureBar, double volumeLitres, double temperatureKelvin){
		return (pressureBar * volumeLitres)/ (gasConstantBarLitres * temperatureKelvin);
	}
	
	@Override
	public double getTemperatureKelvin(double pressureBar, double volumeLitres, double molsOfGas){
		return (pressureBar * volumeLitres) / (gasConstantBarLitres * molsOfGas);
	}

	@Override
	public void setGas(Gas gas) {
		//Do Nothing
	}
}