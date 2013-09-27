/**
 * 
 */
package uk.co.craigwarren.gascalc.exception;

import uk.co.craigwarren.gascalc.model.Gas;

/**
 * An Exception thrown when a gas mix is not possible using only Helium, Oxygen and Air.
 * @author craig
 *
 */
public class ImpossibleMixException extends Exception {

    /***/
    private static final long serialVersionUID = 1L;
    
    public ImpossibleMixException(Gas gas) {
        super("The gas "+gas.toString()+" cannot be mixed without a source of pure nitrogen");
    }
}
