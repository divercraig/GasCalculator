/**
 * 
 */
package uk.co.craigwarren.gascalc;

/**
 * An enum representing an element which is identified by it's name but also contains 
 * specific values about the molecules of the element.
 *
 * @author craig
 *
 */
public enum Element {
	OXYGEN(1.382,0.03186,31.9988),
	NITROGEN(1.370,0.03870,28.01348),
	HELIUM(0.0346,0.02380,4.0020602);
	
	private double vdwElasticity;
	private double vdwVolume;
	private double vdwMolWeight;
	
	
	private Element(double elasticity, double volume, double molWeight) {
		vdwElasticity = elasticity;
		vdwVolume = volume;
		vdwMolWeight = molWeight;
	}


	/**
	 * @return the constant value of the element describing how attractive the molecule
	 * is to other molecules and therefore how close molecules rest on average from each other.
	 */
	public double getVdwElasticity() {
		return vdwElasticity;
	}


	/**
	 * @return the constant value of the element describing how much volume the molecule occupies
	 * compared with other elemental molecular volume.
	 */
	public double getVdwVolume() {
		return vdwVolume;
	}


	/**
	 * @return the constant value of the elements mol weight. That is the number of grams
	 * of the element in 1 mol.
	 */
	public double getVdwMolWeight() {
		return vdwMolWeight;
	}

	
	
}
