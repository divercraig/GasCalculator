/**
 * 
 */
package uk.co.craigwarren.gascalc.model;


/**
 * A Model representing the requirement for a fill
 * 
 * @author craig
 *
 */
public class FillRequirement {
	
	private Cylinder startingCylinder;
	private double targetPressure;
	private Gas targetGas;
	private double ambientTemperatureKelvin;
	
	public FillRequirement(Cylinder startingCylinder, double targetPressure, Gas targetGas, int ambientTemperatureKelvin) {
		super();
		this.startingCylinder = startingCylinder;
		this.targetPressure = targetPressure;
		this.targetGas = targetGas;
		this.ambientTemperatureKelvin = ambientTemperatureKelvin;
	}

	public Cylinder getStartingCylinder() {
		return startingCylinder;
	}

	public void setStartingCylinder(Cylinder startingCylinder) {
		this.startingCylinder = startingCylinder;
	}

	public double getTargetPressure() {
		return targetPressure;
	}

	public void setTargetPressure(double targetPressure) {
		this.targetPressure = targetPressure;
	}

	public Gas getTargetGas() {
		return targetGas;
	}

	public void setTargetGas(Gas targetGas) {
		this.targetGas = targetGas;
	}
	
	public void setAmbientTemperatureKelvin(int kelvin) {
	    this.ambientTemperatureKelvin = kelvin;
	}
	
	public double getAmbientTemperatureKelvin() {
	    return this.ambientTemperatureKelvin;
	}
	
	

}
