package com.kazurayam.ks

//import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.WebUIDriverType as DriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.builtin.OpenBrowserKeyword

@RunWith(JUnit4.class)
public class OpenBrowserKeywordModifierTest {

	private DriverType driverType = DriverType.CHROME_DRIVER
	private String rawUrl = "https://demoaut.katalon.com/"
	private FailureHandling flowControl = FailureHandling.OPTIONAL
	
	@Test
	void testOpenChromeThenClose() {
		// when:
		boolean result = OpenBrowserKeywordModifier.modifyKeyword()
		assertTrue(result)
		// then:
		new OpenBrowserKeyword().openBrowser(driverType, rawUrl, flowControl)
		// a window of Chrome browser should be opened
		WebUI.delay(3)
		WebUI.closeBrowser()
	}
}
