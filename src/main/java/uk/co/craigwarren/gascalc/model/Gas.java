/**
 * 
 */
package uk.co.craigwarren.gascalc.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @author craig
 *
 */
public class Gas {
	
	private Map<Element, Double> components;
	
	public double getPercentageOxygen() {
		return this.getPercentage(Element.OXYGEN);
	}
	public double getPercentageNitrogen() {
		return this.getPercentage(Element.NITROGEN);
	}
	public double getPercentageHelium() {
		return this.getPercentage(Element.HELIUM);
	}
	
	public Gas(double oxygen, double nitrogen, double helium){
		if(oxygen + nitrogen + helium != 100 ) {
			throw new IllegalArgumentException("Cannot create a gas when components do not sum to 100");
		}
		
		components = new HashMap<Element,Double>();
		
		if(oxygen != 0){
			components.put(Element.OXYGEN, oxygen);
		}
		
		if(nitrogen != 0){
			components.put(Element.NITROGEN, nitrogen);
		}
		
		if(helium != 0){
			components.put(Element.HELIUM, helium);
		}
	}
	
	public Gas(double oxygen, double nitrogen){
		this(oxygen,nitrogen,0);
	}
	
	public Gas(int oxygen, int nitrogen){
		this((double)oxygen,(double)nitrogen);
	}
	
	public Gas(int oxygen, int nitrogen, int helium){
		this((double)oxygen,(double)nitrogen,(double)helium);
	}
	
	public Set<Element> getComponents(){
		return this.components.keySet();
	}
	
	public double getPercentage(Element element){
		if(components.containsKey(element)){
			return components.get(element);
		}
		return 0;
	}
	
	public double getDecimalRatio(Element element){
		return 0.01 * getPercentage(element);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Gas)){
			return false;
		}
		Gas gas = (Gas) obj;
		if ((gas.getPercentageOxygen() != this.getPercentageOxygen() )
				|| (gas.getPercentageNitrogen() != this.getPercentageNitrogen())
				|| (gas.getPercentageHelium() != this.getPercentageHelium())){
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("(%f O2) (%f N2) (%f He)",
				this.getPercentageOxygen(), this.getPercentageNitrogen(),
				this.getPercentageHelium());
	}
	
	
	public static Gas air(){
		return new Gas(21,79);
	}

}
