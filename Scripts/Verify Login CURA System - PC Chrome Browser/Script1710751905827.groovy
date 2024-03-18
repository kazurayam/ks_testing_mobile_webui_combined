import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

WebUI.comment('Story: Login to CURA system')

WebUI.comment('Given that the user has the valid login information')


//WebUI.openBrowser(GlobalVariable.G_SiteURL)

// We want to launch PC Chrome browser explicity
System.setProperty("webdriver.chrome.driver", "/Applications/Katalon Studio.app/Contents/Eclipse/configuration/resources/drivers/chromedriver_mac/chromedriver")
WebDriver driver = new ChromeDriver()
DriverFactory.changeWebDriver(driver)
WebUI.navigateToUrl(GlobalVariable.G_SiteURL)


WebUI.click(findTestObject('Web Browser/btn_MakeAppointment'))

WebUI.setText(findTestObject('Web Browser/txt_Username'), 'John Doe')

WebUI.setText(findTestObject('Web Browser/txt_Password'), 'ThisIsNotAPassword')

WebUI.comment('When he logins to CURA system')

WebUI.click(findTestObject('Web Browser/btn_Login'))

WebUI.comment('Then he should be able to login successfully')

WebUI.verifyTextPresent('Make Appointment', false)

WebUI.closeBrowser()

