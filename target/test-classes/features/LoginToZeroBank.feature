Feature: ZeroBank login

  User Story:
  As a user story, I should be able to login to Bank and navigate to Account Activity page,
  and see options :
  (Savings, Checking, Savings, Loan, Credit Card, Brokerage)

  @smoke
  Scenario: Checking the account activity page features of ZeroBank Application
  When The user navigates to the login page
  Then user logs in with the user "username" and the password "password"
  And The user navigates to Account Activity page
  And Then The page should have the title "Zero - Account Activity"
  And Then Account drop down should have the following options
  Then Brokerage option should have "No results."
