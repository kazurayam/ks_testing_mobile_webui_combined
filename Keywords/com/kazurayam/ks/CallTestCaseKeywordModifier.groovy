package com.kazurayam.ks

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.keyword.builtin.CallTestCaseKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType as DriverType

public class CallTestCaseKeywordModifier {

	@Keyword
	public static boolean modify() {
		println "CallTestCaseKeywordModifier.modify() was invoked"
		CallTestCaseKeyword.metaClass.callTestCase = {   
				DriverType driverType, 
				TestCase calledTestCase, 
				Map<String, Object> binding, 
				FailureHandling flowControl ->
			println "> driverType: ${driverType}"
			println "> calledTestCase: ${calledTestCase}"
			println "> flowControl: ${flowControl}"

			// enforce DriverFactory.openBrowser() to open the required type of browser
			modifyGetExecutedBrowserMethod(driverType)

			// execute the genuine CallTestCase keyword
			CallTestCaseKeyword ctc = new CallTestCaseKeyword()
			ctc.callTestCase(calledTestCase, binding, flowControl)

			// bring back the DriverFactory as previous
			restoreGetExecutedBrowserMethod()

			// return true just to notify nothing problematic has occured
			return true
		}
	}

	private static void modifyGetExecutedBrowserMethod(DriverType requiredDriverType) {
		DriverFactory.metaClass.static.getExecutedBrowser = { DriverType dt ->
			return dt
		}
	}

	private static void restoreGetExecutedBrowserMethod() {
		DriverFactory.metaClass.static.getExecutedBrowser = {
			throw new MissingMethodException()
		}
	}
}
