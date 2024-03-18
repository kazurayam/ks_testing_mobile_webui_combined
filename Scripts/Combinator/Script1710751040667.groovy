import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**
 * "Test Cases/Combinator"
 */

// run Mobile test
Mobile.callTestCase(findTestCase("Verify Last Items In List"), null)

// run WebUI test while launching PC Chrome browser explicitly without calling WebUI.openBrowser('')
WebUI.callTestCase(findTestCase("Verify Login CURA System - PC Chrome Browser"), null)