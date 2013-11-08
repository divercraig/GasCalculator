/**
 * 
 */
package uk.co.craigwarren.gascalc.blender;

import uk.co.craigwarren.gascalc.exception.ImpossibleMixException;
import uk.co.craigwarren.gascalc.model.FillRequirement;
import uk.co.craigwarren.gascalc.model.filling.FillPlan;

/**
 * Abstract implementation for GasBlenders used to blending gas in empty cylinders
 * or gas topups to partially filled cylinders
 * 
 * @author craig
 *
 */
public interface GasBlender {
    
    /**
     * Generate the plan for how to acieve a fill requirement
     * 
     * @param requirement The required gas, and cylinder information
     * @return the steps to achieve the fill
     * @throws ImpossibleMixException if the gas cannot be mixed without pure nitrogen
     */
    FillPlan blendGas(FillRequirement requirement) throws ImpossibleMixException;

}
