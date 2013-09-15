/**
 * 
 */
package uk.co.craigwarren.gascalc.gaslaw;

import com.google.common.base.Function;

/**
 * Class which contains the functions used in VanDerWaalsEquations
 * 
 * @author craig
 *
 */
public class VanDerWaalsFunctionFactory {
	
	public Function<Double,Double> getVolumeFunction(final double pressure, final double mols, final double a, final double b, final double r, final double temp){

		return new Function<Double,Double>(){
			public Double apply(Double volume) {
				return (pressure*volume) - (pressure*mols*b) + ((Math.pow(mols, 2)*a)/(volume)) - ((Math.pow(mols, 3)*a*b)/(Math.pow(volume, 2)))-(mols * r* temp);
			}
			
		};
	}
	
	public Function<Double,Double> getVolumePrimeFunction(final double pressure, final double mols, final double a, final double b){
		return new Function<Double,Double>(){

			public Double apply(Double volume) {
				return (pressure) - ((Math.pow(mols, 2) * a)/(Math.pow(volume, 2))) + ((2*a*b*Math.pow(mols, 3))/(Math.pow(volume, 3)));
			}
			
		};
	}
	
	public Function<Double,Double> getMolsFunction(final double pressure, final double volume, final double a, final double b, final double r, final double temp){
		return new Function<Double, Double>(){

			public Double apply(Double mols) {
				return (pressure * volume) - (pressure * mols * b ) + ((Math.pow(mols, 2)*a)/volume) - ((Math.pow(mols, 3)*a*b)/Math.pow(volume, 2)) - (mols*r*temp);
			}
			
		};
	}
	
	public Function<Double,Double> getMolsPrimeFunction(final double a, final double b, final double volume, final double pressure, final double r, final double temp){
		return new Function<Double, Double>(){

			public Double apply(Double mols) {
				return ((2 * mols * a)/volume) - ((3 * Math.pow(mols, 2)*a*b)/Math.pow(volume, 2))-(pressure*b)-(r*temp);
			}
			
		};	
	}
}
