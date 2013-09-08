/**
 * 
 */
package uk.co.craigwarren.gascalc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @author craig
 *
 */
public class Gas {
	
	private Map<Element, Integer> components;
	
	public int getPercentageOxygen() {
		return this.getPercentage(Element.OXYGEN);
	}
	public int getPercentageNitrogen() {
		return this.getPercentage(Element.NITROGEN);
	}
	public int getPercentageHelium() {
		return this.getPercentage(Element.HELIUM);
	}
	
	public Gas(int oxygen, int nitrogen, int helium){
		if(oxygen + nitrogen + helium != 100 ) {
			throw new IllegalArgumentException("Cannot create a gas when components do not sum to 100");
		}
		
		components = new HashMap<Element,Integer>();
		
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
	
	public Gas(int oxygen, int nitrogen)
	{
		this(oxygen,nitrogen,0);
	}
	
	public Set<Element> getComponents(){
		return this.components.keySet();
	}
	
	public int getPercentage(Element element){
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
		return String.format("(%d O2) (%d N2) (%d He)",
				this.getPercentageOxygen(), this.getPercentageNitrogen(),
				this.getPercentageHelium());
	}
	
	
	public static Gas air(){
		return new Gas(21,79);
	}

}
