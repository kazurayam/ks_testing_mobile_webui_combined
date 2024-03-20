package com.kazurayam.ks

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.WebUIDriverType as DriverType
import com.kms.katalon.core.webui.keyword.builtin.OpenBrowserKeyword


/**
 * The 
 * @author kazurayam
 */
public class OpenBrowserKeywordModifier {

	@Keyword
	public static boolean modifyKeyword() {
		//OpenBrowserKeyword kw = new OpenBrowserKeyword()
		//return true
		OpenBrowserKeyword.metaClass.openBrowser = { 
				DriverType driverType, 
				String rawUrl, 
				FailureHandling flowControl ->
			println "> driverType: ${driverType}"
			println "> rawUrl: ${rawUrl}"
			println "> flowControl: ${flowControl}"
			//
			return true
		}
	}
}

