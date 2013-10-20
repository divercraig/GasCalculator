/**
 * 
 */
package uk.co.craigwarren.gascalc;

import java.util.Map;

import com.google.common.collect.Maps;

import uk.co.craigwarren.gascalc.model.Element;
import uk.co.craigwarren.gascalc.model.Gas;

/**
 * @author craig
 *
 */
public class GasMixing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double amount1 = 1.0;
		Gas gas1 = new Gas(42,58);
		
		double amount2 = 2.333333333333334;
		Gas gas2 = Gas.air();
		
		Map<Element,Double> newGasComponents = Maps.newEnumMap(Element.class);
		
		for (Element element : Element.values()) {
			double ratio = (gas1.getDecimalRatio(element)/amount1)+(gas2.getDecimalRatio(element)/amount2);
			newGasComponents.put(element, ratio);
		}
		
		Gas result = new Gas(newGasComponents);
		System.out.println("componenents" + newGasComponents);
		System.out.println("Result = "+result);
	}

}
