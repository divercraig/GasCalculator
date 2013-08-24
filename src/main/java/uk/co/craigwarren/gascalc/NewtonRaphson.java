/**
 * 
 */
package uk.co.craigwarren.gascalc;

import com.google.common.base.Function;

/**
 * Class which can be used to perform NewtonRaphson computations using the method
 * 
 * Xi+1 = Xi - (f(Xi)/f'(Xi))
 * 
 * @author craig
 *
 */
public class NewtonRaphson implements Function<Double,Double> {
	
	private Function<Double,Double> function;
	private Function<Double,Double> primeFunction;

	public void setPrimeFunction(Function<Double, Double> primeFunction) {
		this.primeFunction = primeFunction;
	}
	
	public void setFunction(Function<Double, Double> function) {
		this.function = function;
	}
	
	public NewtonRaphson(Function<Double, Double> function,
			Function<Double, Double> primeFunction) {
		super();
		this.function = function;
		this.primeFunction = primeFunction;
	}
	
	public NewtonRaphson(){
		super();
	}
	
	public Double apply(Double input) {
		if(null==function || null==primeFunction){
			throw new IllegalArgumentException("Cannot perform newton raphson without function and prime function");
		}
		Double temp =  input - (function.apply(input)/primeFunction.apply(input));
		if(equalDP(temp,input,5)){
			return temp;
		}
		return this.apply(temp);
	}
	
	protected static boolean equalDP(double a, double b, int decimalPlaces){
		long multiplier = Math.round(Math.pow(10, decimalPlaces));
		long sizedA = Math.round(a * multiplier);
		long sizedB = Math.round(b * multiplier);
		
		return sizedA == sizedB;
	}

}
