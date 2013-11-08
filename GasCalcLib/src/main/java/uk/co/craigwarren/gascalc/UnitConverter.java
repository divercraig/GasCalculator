/**
 * 
 */
package uk.co.craigwarren.gascalc;

/**
 * Unit Converter Static Methods
 * 
 * @author craig
 *
 */
public class UnitConverter {
	
	public static float celciusToKelvin(float degreesCelcius){
		return degreesCelcius + 273;
	}
	
	public static float kelvinToCelcius(float degreesKelvin){
		return degreesKelvin - 273;
	}
	
	public static int celciusToKelvin(int degreesCelcius){
		return Math.round(celciusToKelvin((float)degreesCelcius));
	}
	
	public static int kelvinToCelcius(int degreesKelvin){
		return Math.round(kelvinToCelcius((float)degreesKelvin));
	}

}
