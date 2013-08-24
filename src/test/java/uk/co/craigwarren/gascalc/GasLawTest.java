/**
 * 
 */
package uk.co.craigwarren.gascalc;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author craig
 *
 */
public abstract class GasLawTest {
	private double testTemp = 293;
	private double testVolume = 10;
	private double testPressure = 200;
	private double testQuantity = 83.14176;
	
	public double getTestTemp() {
		return testTemp;
	}

	public double getTestVolume() {
		return testVolume;
	}

	public double getTestPressure() {
		return testPressure;
	}

	public double getTestQuantity() {
		return testQuantity;
	}
	
	private double errorAllowance = 0.0001;
	protected GasLaw gasLawUnderTest;
	
	@Test
	public void testGetMolsOfGas(){
		double testResult = gasLawUnderTest.getMolsOfGas(getTestPressure(), getTestVolume(), getTestTemp());
		Assert.assertEquals("The test result doesn't match the testQuantity", getTestQuantity(),testResult,errorAllowance);
	}
	
	@Test
	public void testGetVolume(){
		double testResult = gasLawUnderTest.getVolumeLitres(getTestPressure(), getTestQuantity(), getTestTemp());
		Assert.assertEquals("The test result doesn't match the testVolume", getTestVolume(),testResult,errorAllowance);
	}

	@Test
	public void testGetPressure(){
		double testResult = gasLawUnderTest.getPressureBar(getTestVolume(), getTestQuantity(), getTestTemp());
		Assert.assertEquals("The test result doesn't match the testPressure", getTestPressure(),testResult,errorAllowance);
	}
	
	@Test
	public void testGetTemp(){
		double testResult = gasLawUnderTest.getTemperatureKelvin(getTestPressure(), getTestVolume(), getTestQuantity());
		Assert.assertEquals("The test result doesn't match the testTemp", getTestTemp(),testResult,errorAllowance);
	}
}
