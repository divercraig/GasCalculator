/**
 * 
 */
package uk.co.craigwarren.gascalc.model.filling;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * A Fill plan is just a linked list of Fill Steps
 * 
 * @author craig
 *
 */
public class FillPlan extends LinkedList<FillStep> {

	/***/
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(FillStep arg0) {
		if(this.size() > 0) {
			FillStep lastStep = this.getLast();
			if(new BigDecimal(lastStep.getPressure()).equals(new BigDecimal(arg0.getPressure()))){
				return false;
			}
		}
		return super.add(arg0);
	}
	
	

}
