import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.WebUIDriverType as DriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**
 * "Test Cases/CombinatorUsingCallTestCaseKeywordModifyer"
 */

// run Mobile test
//Mobile.callTestCase(findTestCase("Verify Last Items In List"), [:])

// modify the com.kms.katalon.core.webui.keyword.builtin.CallTestCaseKeyword class dynamically
// so that the WebUI.callTestCase() method accepts a DriverType instance as the 1st argument
CustomKeywords.'com.kazurayam.ks.CallTestCaseKeywordModifier.modify'()

// run WebUI test while launching PC Chrome browser explicitly without calling WebUI.openBrowser('')
WebUI.callTestCase(DriverType.CHROME_DRIVER, findTestCase("Verify Login CURA System"), [:], FailureHandling.STOP_ON_FAILURE)