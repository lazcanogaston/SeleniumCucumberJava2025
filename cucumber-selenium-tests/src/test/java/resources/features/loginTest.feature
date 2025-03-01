Feature: Login Feature with Outline

    @login-regression
    Scenario Outline: <ExpectedResult> Sign in test.
        Given The user navigates to the login page
        When The user populates the username field with value: <username>
        And The user populates the password field with value: <password>
        And The user clicks Login Button
       Then Validate signs in with result: "<ExpectedResult>" and error message "<ExpectedErrorMessage>"
        Examples:
        | username     | password     | ExpectedResult | ExpectedErrorMessage |
        | gastontestslot@gmail.com   | testingAccount1 | Correct | |
        | gastontestslot@gmail.com   | short | Short password |  Minimum password length is 6  |
        | gastontestslot@gmail.com   | incorrectPass | Incorrect password |  Incorrect email or password  |
        | incorrectEmail@gmail.com   | incorrectPass  | Incorrect email| Incorrect email or password |
        | gastontestslot@gmail.com   |   | NonPassword | Password is required |
        |    | testingAccount1 | Non email | Email is required |
        |    |  | emptyFields | Email is required/Password is required  |