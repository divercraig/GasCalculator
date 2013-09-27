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
	
	
	public FillRequirement(Cylinder startingCylinder, double targetPressure, Gas targetGas) {
		super();
		this.startingCylinder = startingCylinder;
		this.targetPressure = targetPressure;
		this.targetGas = targetGas;
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
	
	

}
