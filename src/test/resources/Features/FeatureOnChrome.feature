@TestingOnChrome
Feature: To execute test cases on the Chrome browser
  Scenario: C000 - Enter string into Google search field
    Given Tester goes to the "Google Home" website
    When Tester searches the "Selenium WebDriver" keyword
    Then Tester sees the "Selenium WebDriver" hyperlink is returned

  Scenario: C001 - Show a failed test case for cucumber report
    Given Tester fails a test case