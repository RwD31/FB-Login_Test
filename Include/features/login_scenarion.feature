@tag
Feature: Login feature
  I want to login facebook.com

  @valid
  Scenario Outline: Login to facebook using valid credential
    Given I navigated into login page
    When I fill email <Email> and password <Password>
    And I click login button
    Then I verify I have been login facebook
      
    #change email and password with your facebook account to login into facebook.com
    #this email just dummy and not registered email, make sure you are user your real email.
		Examples: 
		#this is scenario with valid email
      | Email             | Password |
      | Budi123@email.com | budi12345  |
      
      
  @invalid1
  Scenario Outline: Login to facebook using invalid email
    Given I navigated into login page
    When I fill email <Email> and password <Password>
    And I click login button
    Then I verify invalid email
      
		Examples: 
      | Email             | Password |
      #login with unregistered email
      | email-test1212@email.com | budi123  |
      #login without email
      |   | budiganteng123  |
      #login with invalid email format
      | Budi123.email.com | budi12345  |
      
  @invalid2
  Scenario Outline: Login to facebook using invalid password
    Given I navigated into login page
    When I fill email <Email> and password <Password>
    And I click login button
    Then I verify invalid password
      
      #login with wrong registered password
      | Budi123@email.com | budi12345  |
      #login without password
      | Budi123@email.com |    |
      #login with password under 8 character
      | Budi123@email.com | budi12  |