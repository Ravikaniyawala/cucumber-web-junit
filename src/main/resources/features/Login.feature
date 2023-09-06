@login @regression @smoketest
Feature: Login page

    Scenario Outline: Test to verify Login
        Given User goes to <market2x> Login Page
        When User logs in to my <market2x> account
        Then User should see the <market2x> home page loaded
        Examples:
            |market2x |
            |booking|
            |carrier|





