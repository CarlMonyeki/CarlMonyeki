Feature: Search location functionality
Scenario Outline: Validating the user can search for any location on the system
  Given Navigate to the adactin driving innovation website and login
  When User enter correct <username> and <password>
  And click login buton
  And Navigate to <location> and select London
  And Click search button
  And Validate if there is a list of hotels returned
  Then Click logout and close the browser
  Examples:
    |username|password|location|
    |autotestb|W858OZ|   London     |



