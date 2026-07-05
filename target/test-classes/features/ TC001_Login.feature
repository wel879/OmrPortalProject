@Login 


Feature: Login Module

               
  Scenario Outline: Verifying login with valid credentials
    Given User is on the OMR Branch hotel page
    When User enter "<userName>" and "<password>" and click login
    Then User should verify success message after login "Welcome Greens"

    Examples:
      | userName                       | password   |
      | greenstechchennaiomr@gmail.com | GTOMR4j0b$ |

  Scenario Outline: Verifying login with registered username and invalid password
    Given User is on the OMR Branch hotel page
    When User enter "<userName>" and "<password>" and click login
    Then User should verify error message after login "Invalid credentials"

    Examples:
      | userName                       | password    |
      | greenstechchennaiomr@gmail.com | Hello@45678 |

  Scenario: Verifying login without entering credentials
    Given User is on the OMR Branch hotel page
    When User click on login button
    Then User should verify error message after login "Please enter your registered Email Address"

  Scenario Outline: Verifying login with unregistered email and password
    Given User is on the OMR Branch hotel page
    When User enter "<userName>" and "<password>" and click login
    Then User should verify error message after login "User does not exist"

    Examples:
      | userName         | Password   |
      | greens@gmail.com | Hello@6545 |

  Scenario Outline: Verifying login with invalid email and password
    Given User is on the OMR Branch hotel page
    When User enter "<userName>" and "<password>" and click login
    Then User should verify error message after login "Email ID is invalid"

    Examples:
      | userName       | Password |
      | greengmail.com | Hello    |
