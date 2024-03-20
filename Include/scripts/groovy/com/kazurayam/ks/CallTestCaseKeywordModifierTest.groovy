package com.kazurayam.ks

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import com.kms.katalon.core.keyword.builtin.CallTestCaseKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.webui.driver.WebUIDriverType as DriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

@RunWith(JUnit4.class)
public class CallTestCaseKeywordModifierTest {

	private DriverType driverType = DriverType.CHROME_DRIVER
	private TestCase testCase = findTestCase("Test Cases/Verify Login CURA System Successfully - Mobile Browsers")
	private FailureHandling flowControl = FailureHandling.OPTIONAL

	@Test
	void testModify() {
		// when:
		boolean result = CallTestCaseKeywordModifier.modify()
		// then:
		new CallTestCaseKeyword().callTestCase(driverType, testCase, [:], flowControl)
		//
		assertTrue(true)
	}
}
