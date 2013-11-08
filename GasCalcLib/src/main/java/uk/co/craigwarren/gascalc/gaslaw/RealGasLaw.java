/**
 * 
 */
package uk.co.craigwarren.gascalc.gaslaw;

import uk.co.craigwarren.gascalc.model.Gas;

/**
 * Class which can perform the real gas calculations for Bar and Litres using the formulae
 * 
 * (P+(((n^2)a)/(v^2)))(V-nb) = nRT
 * 
 * where:
 * P is the pressure the g is the gas is stored under in Atmospheres (Bar)
 * V is the volume the gas occupies in Litres
 * n is the number of mols of gas
 * R is the idea gas constant used for Bars and Litres (0.0821)
 * T is the temperature the ambient pressure of the gas in degrees kelvin
 * a is the Van der Waals constant for the molecular elasticity of the gas in question
 * b is the Van der Waals constant for the molecular volume of the gas in question
 *
 * @author craig
 */
public class RealGasLaw extends GasLaw {
	
	private Gas gas;

	private final VanDerWaalsConstantsCalculator calc;
	private final NewtonRaphson newtonRaphson;
	private final VanDerWaalsFunctionFactory vdwff;
	private final IdealGasLaw idealGasLaw;
	private Double a;
	private Double b;
	
	public Gas getGas() {
		return gas;
	}
	
	public void setGas(Gas gas) {
		this.gas = gas;
	}
	
	public RealGasLaw(Gas gas, VanDerWaalsConstantsCalculator calc, NewtonRaphson nr, VanDerWaalsFunctionFactory vdwff, IdealGasLaw idealGasLaw){
		this.gas = gas;
		this.calc = calc;
		this.newtonRaphson = nr;
		this.vdwff = vdwff;
		this.idealGasLaw = idealGasLaw;
	}
	
	private double getA(){
		if(null==a){
			a = calc.getVdwElasticity(gas);
		}
		return a;
	}
	
	private double getB(){
		if(null==b){
			b = calc.getVdwVolume(gas);
		}
		return b;
	}

	/* (non-Javadoc)
	 * @see uk.co.craigwarren.gascalc.GasLaw#getPressureBar(double, double, double)
	 * 
	 * Use the function
	 * P = ((nRT)/(v-nb)) - (((n^2)a)/(v^2))
	 * 
	 */
	@Override
	public double getPressureBar(double volumeLitres, double molsOfGas, double temperatureKelvin){
		return ((molsOfGas*gasConstantBarLitres*temperatureKelvin)/(volumeLitres-molsOfGas*getB())) - (((Math.pow(molsOfGas, 2))*getA())/Math.pow(volumeLitres,2));	
	}
	
	@Override
	public double getVolumeLitres(double pressureBar, double molsOfGas, double temperatureKelvin){
		newtonRaphson.setFunction(vdwff.getVolumeFunction(pressureBar, molsOfGas, getA(), getB(), gasConstantBarLitres, temperatureKelvin));
		newtonRaphson.setPrimeFunction(vdwff.getVolumePrimeFunction(pressureBar, molsOfGas, getA(), getB()));
		return newtonRaphson.apply(idealGasLaw.getVolumeLitres(pressureBar, molsOfGas, temperatureKelvin));
	}
	
	@Override
	public double getMolsOfGas(double pressureBar, double volumeLitres, double temperatureKelvin){
		newtonRaphson.setFunction(vdwff.getMolsFunction(pressureBar, volumeLitres, getA(), getB(), gasConstantBarLitres, temperatureKelvin));
		newtonRaphson.setPrimeFunction(vdwff.getMolsPrimeFunction(getA(), getB(), volumeLitres, pressureBar, gasConstantBarLitres, temperatureKelvin));
		return newtonRaphson.apply(idealGasLaw.getMolsOfGas(pressureBar, volumeLitres, temperatureKelvin));
	}
	
	/* (non-Javadoc)
	 * @see uk.co.craigwarren.gascalc.GasLaw#getTemperatureKelvin(double, double, double)
	 * 
	 * T = (((P+((n^2)*a)/(v^2))(V-nb))(V-nb))/nR
	 * 
	 */
	@Override
	public double getTemperatureKelvin(double pressureBar, double volumeLitres, double molsOfGas){
		double pressureSection = pressureBar + ((Math.pow(molsOfGas, 2)*getA())/Math.pow(volumeLitres, 2));
		double volumeSection = volumeLitres - (molsOfGas*getB());
		double molSection = molsOfGas * gasConstantBarLitres;
		
		return (pressureSection * volumeSection)/molSection;
	}
}
