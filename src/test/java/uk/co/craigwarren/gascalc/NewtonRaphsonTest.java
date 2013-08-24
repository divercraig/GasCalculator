package uk.co.craigwarren.gascalc;

import org.junit.Assert;

import org.easymock.EasyMock;
import org.junit.Test;

import com.google.common.base.Function;

public class NewtonRaphsonTest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void testApply(){
		Function<Double, Double> mockFunction = EasyMock.createMock(Function.class);
		Function<Double, Double> mockPrimeFunction = EasyMock.createMock(Function.class);
		Double input = 5.0;
		Double expectedResult = 3.0;
		
		//Each expect should be called twice to look for two results with the same 5 decimal places
		EasyMock.expect(mockFunction.apply(EasyMock.eq(input))).andReturn(4.0);
		EasyMock.expect(mockPrimeFunction.apply(EasyMock.eq(input))).andReturn(2.0);
		EasyMock.expect(mockFunction.apply(EasyMock.eq(expectedResult))).andReturn(0.0);
		EasyMock.expect(mockPrimeFunction.apply(EasyMock.eq(expectedResult))).andReturn(1.0);
		
		EasyMock.replay(mockFunction,mockPrimeFunction);
		
		NewtonRaphson classToTest = new NewtonRaphson(mockFunction, mockPrimeFunction);
		
		Double result = classToTest.apply(input);
		
		Assert.assertEquals("The result is not as expected",expectedResult, result,0.0);
		
		EasyMock.verify(mockFunction,mockPrimeFunction);
		
	}
	
	@Test
	public void testEqualDP(){
		Assert.assertTrue("Numbers should be equal to 5 dp",NewtonRaphson.equalDP(0.123456, 0.123457, 5));
		Assert.assertFalse("Numbers should not be equal to 5 dp",NewtonRaphson.equalDP(0.123456, 0.123457, 6));
	}
}
