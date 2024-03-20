package com.kazurayam.ks

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.keyword.builtin.CallTestCaseKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.webui.driver.WebUIDriverType as DriverType

public class CallTestCaseKeywordModifier {

	@Keyword
	public static boolean modify() {
		CallTestCaseKeyword.metaClass.callTestCase = { 
				DriverType driverType,
				TestCase calledTestCase,
				Map<String, Object> binding,
				FailureHandling flowControl ->
			println "> driverType: ${driverType}"
			println "> calledTestCase: ${calledTestCase}"
			println "> flowControl: ${flowControl}"
			return true
		}
	}
}
