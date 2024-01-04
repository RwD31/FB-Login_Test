import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class login_stepdefinition {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I navigated into login page")
	def navigateLogin() {
		WebUI.openBrowser('')
		
		WebUI.navigateToUrl('https://www.facebook.com/')
	}

	@When("I fill email (.*) and password (.*)")
	def inputCredential(String Email, String Password) {
		
		WebUI.setText(findTestObject('Object Repository/Page_Facebook  log in or sign up/input_Facebook helps you connect and share _ccef60'),
			Email)
		
		WebUI.setText(findTestObject('Object Repository/Page_Facebook  log in or sign up/input_Facebook helps you connect and share _ab63fc'),
			Password)
	}

	@Then("I click login button")
	def ClickLogin() {
		
		WebUI.click(findTestObject('Object Repository/Page_Facebook  log in or sign up/button_Log in'))
		
	}

	@Then("I verify I have been login facebook")
	def verifyLogedin() {
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_(20) Facebook/input_Menu Facebook_x1i10hfl xggy1nq x1s07b_f26a0e'),
			0)
		
		WebUI.closeBrowser()
		
	}

	@Then("I verify invalid email")
	def verifyInvalidEmail() {
		
		WebUI.verifyElementPresent(findTestObject('Page_Facebook  log in or sign up/Page_Log in to Facebook/div_The email address or mobile number you entered isnt connected to an account. Create a new Facebook account'),
			0)
		
		WebUI.closeBrowser()
		
	}

	@Then("I verify invalid password")
	def verifyInvalidPassword() {
		
		WebUI.verifyElementPresent(findTestObject('Page_Facebook  log in or sign up/Page_Log in to Facebook/a_Try another way'),
			0)
		
		WebUI.closeBrowser()
	}
}