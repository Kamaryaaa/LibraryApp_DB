Feature: Login functionality

@wip @db
Scenario: Login with valid credentials
Given the user logged in  "librarian56@library" and "libraryUser"
When user gets username  from user fields
Then the username should be same with database