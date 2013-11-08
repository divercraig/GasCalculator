/**
 * 
 */
package uk.co.craigwarren.gascalc.model.filling;

import uk.co.craigwarren.gascalc.model.Gas;

/**
 * A single step in a fill plan
 * 
 * @author craig
 *
 */
public class FillStep {
	private final FillAction action;
	private final double pressure;
	private final Gas gas;
	
	public FillStep(FillAction action, double pressure, Gas gas){
		this.action = action;
		this.pressure = pressure;
		this.gas = gas;
	}

	/**
	 * @return the action to be carried out
	 */
	public FillAction getAction() {
		return action;
	}

	/**
	 * @return the new pressure Reading after the step
	 */
	public double getPressure() {
		return pressure;
	}

	/**
	 * @return the gas to be used in the step
	 */
	public Gas getGas() {
		return gas;
	}

}
