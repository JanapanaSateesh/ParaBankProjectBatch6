package com.parabankautomation.helpers;

import org.testng.Assert;

public class UiHelpers {

	public static void CompareStrings(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}
}
