/**
 * 
 */
package uk.co.craigwarren.gascalc;

/**
 * @author craig
 *
 */
public class UnitConverter {
	
	public float celciusToKelvin(float degreesCelcius){
		return degreesCelcius + 273;
	}
	
	public float kelvinToCelcius(float degreesKelvin){
		return degreesKelvin - 273;
	}
	
	public int celciusToKelvin(int degreesCelcius){
		return Math.round(this.celciusToKelvin((float)degreesCelcius));
	}
	
	public int kelvinToCelcius(int degreesKelvin){
		return Math.round(this.kelvinToCelcius((float)degreesKelvin));
	}

}
