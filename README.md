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

But Katalon Studio requires us choose a single browser to run a Test Case with. We can choose Chrome for a WebUI test; we can choose Android for a Moble test. But the original poster wants both of Chrome and Android for a single Test Case. Katalon Studio does not allow us to do so:

![choosing browser](https://kazurayam.github.io/ks_mobile_webui_together/images/choosing_browser_in_GUI.png)






