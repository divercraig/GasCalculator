/**
 * 
 */
package uk.co.craigwarren.gascalc;


/**
 * Calculator which can provide the van der waals constants for a given gas.
 * Van der Waals constants are usually referred to as "a" or "b"
 * "a" is the molecular elasticity of the gas
 * "b" is the molecular volume of the gas
 *   
 * @author craig
 *
 */
public class VanDerWaalsConstantsCalculator {
	
	/**
	 * @param gas the gas to retrieve the constant for
	 * @return the "a" Van der Waals constant for the gas
	 */
	public double getVdwElasticity(Gas gas){
		return getVdwConstant(gas, Constant.A);
	}
	
	/**
	 * @param gas the gas to retrieve the constant for
	 * @return the "b" Van der Waals constant for the gas
	 */
	public double getVdwVolume(Gas gas){
		return getVdwConstant(gas, Constant.B);
	}
	
	private double getVdwConstant(Gas gas, Constant con){
		int value = 0;
		int size = gas.getComponents().size();
		Element[] array = gas.getComponents().toArray(new Element[0]);	
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				Element elementI = array[i];
				Element elementJ = array[j];
				double constValue = 0;
				switch (con) {
				case A:
					constValue = elementI.getVdwElasticity() * elementJ.getVdwElasticity();
					break;
				case B:
					constValue = elementI.getVdwVolume() * elementJ.getVdwVolume();
				} 
				value += Math.sqrt((constValue))*(gas.getPercentage(elementI)/100)*(gas.getPercentage(elementJ)/100);
			}
		}
		
		return value;
	}
	
	private enum Constant{
		A, //The Van der Waals constant A represents the gas molecular elasticity
		B; //The Van der Waals constant B represents the gas molecular volume
	}	
}


