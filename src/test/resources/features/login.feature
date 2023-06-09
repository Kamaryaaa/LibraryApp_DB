Feature: Login functionality

 @db
Scenario: Login with valid credentials
Given the user logged in  "librarian55@library" and "libraryUser"
When user gets username  from user fields
Then the username should be same with database

  @wip @db
  Scenario Outline: Login with valid credentials <email>
    Given the user logged in  "<email>" and "<password>"
    When user gets username  from user fields
    Then the username should be same with database

    Examples:
      | email               | password |
      | librarian55@library | libraryUser |
      | librarian56@library | libraryUser |
      | student5@library    | libraryUser |
      | student6@library    | libraryUser |
