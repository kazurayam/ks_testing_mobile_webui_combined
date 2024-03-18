# Sample Katalon Studio project that executes Mobile test and WebUI test combined in a Test Case

This is a Katalon Studio project for demonstration purpose.

This project was developed in the hope to propose a solution to a question raised in the Katalon User forum:

- [How to combine mobile and web test cases](https://forum.katalon.com/t/how-to-combine-mobile-and-web-test-cases/124295) by @ronald1

This project shows a single Test Case script that executes a Mobile test first followed by a WebUI test in a sequence.

This project was derived from the Katalon's sample project

- https://github.com/katalon-studio-samples/android-mobile-tests

This project was developed using Katalon Studio v9.3.1.

## Problem to solve

The original poster wanted to write a Test Case script that execute a Mobile test first followed a WebUI test. However he wondered:

- How to choose Android rather than iPhone to run his Mobile test.

- How to choose PC Chrome on PC rather than Firefox or Edge to run his WebUI test.

Katalon Studio is not designed such case in mind. Katalon Studio requires us choose a single browser to run a Test Case with. We can choose Chrome for a WebUI test; we can choose Android for a Moble test. But the original poster wants both of Chrome and Android for a single Test Case.

![choosing browser](https://kazurayam.github.io/ks_mobile_webui_together/images/choosing_browser_in_GUI.png)

How is it possible?

## Solution proposed

A Test Case should start Chrome browser using the WebDriver API without calling the Katlaon built-in `WebUI.openBrowser` keyword.

## Description

### Combinator test case

I made a Test Case [Combinator](https://github.com/kazurayam/ks_testing_mobile_webui_combined/blob/master/Scripts/Combinator/Script1710751040667.groovy):

```
// run Mobile test
Mobile.callTestCase(findTestCase("Verify Last Items In List"), null)

// run WebUI test while launching PC Chrome browser explicitly without calling WebUI.openBrowser('')
WebUI.callTestCase(findTestCase("Verify Login CURA System - PC Chrome Browser"), null)
```

The Combinator combines two scripts in a sequence. It calls a Mobile test first, and soon after that it calls a WebUI test.

I would launch the Combinator while choosing Android. I would not mind Chrome here.

![choose Android](https://kazurayam.github.io/ks_testing_mobile_webui_combined/images/choose_Android.png)

The `Combinator` Test Case successfully worked for me. It ran a Mobile App on my Android phone, and after that it opened Chrome browser and visited http://demoaut.katalon.com .

### Mobile test

The [Verify Last Items In List](https://github.com/kazurayam/ks_mobile_webui_together/blob/master/Scripts/Verify%20Last%20Items%20In%20List/Script1529986164129.groovy) is just the same as the Katalon's demo project. I made no change.


### WebUI test

The [Verify Login CURA System - PC Chrome Browser](https://github.com/kazurayam/ks_mobile_webui_together/blob/master/Scripts/Verify%20Login%20CURA%20System%20-%20PC%20Chrome%20Browser/Script1710751905827.groovy) is derived from [Verify Login CURA System Successfully - Mobile Browser](https://github.com/kazurayam/ks_mobile_webui_together/blob/master/Scripts/Verify%20Login%20CURA%20System%20Successfully%20-%20Mobile%20Browsers/Script1674800693527.groovy). I modified the script as follows:

```
//WebUI.openBrowser(GlobalVariable.G_SiteURL)

// We want to launch PC Chrome browser explicity
System.setProperty("webdriver.chrome.driver", "/Applications/Katalon Studio.app/Contents/Eclipse/configuration/resources/drivers/chromedriver_mac/chromedriver")
WebDriver driver = new ChromeDriver()
DriverFactory.changeWebDriver(driver)
WebUI.navigateToUrl(GlobalVariable.G_SiteURL)
```

1. I commented out the line of `WebUI.openBrowser` keyword.

2. I launched Chrome browser using ChromeDriver API.

By this change, the `Verify Login CURA System - PC Chrome Browser` script will ALWAYS run with Chrome browser regardles which type of browser I chose when I start the test case. Even if I chose Android, the `Verify Login CURA System - PC Chrome Browser` will run with Chrome.

The problem is resolved.

## Applicability

This project proves that we can write a Test Case that does Mobile testing and WebUI testing combined. Katalon Studio is not designed to support such unusual cases. The trick is that the Test Case will open a PC browser using the WebDriver's native API without using `WebUI.openBrowser` keyword.

I could find several topics in the Katalon forum that wants a way to combine WebUI testing and Mobiel/Desktop testing.

- https://forum.katalon.com/t/does-katalon-support-opening-webui-and-mobile-driver-in-same-script/10489
- https://forum.katalon.com/t/testing-a-mobile-app-that-requires-input-from-a-webui/10634
- https://forum.katalon.com/t/web-application-and-desktop-application-in-the-same-test-case/124420

The same solution will apply to these cases.
