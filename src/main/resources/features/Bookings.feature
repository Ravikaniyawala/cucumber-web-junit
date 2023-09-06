@bookingid @regression @smoketest
Feature: Bookings test

    Scenario Outline: Test to verify Bookings on Booking site
        Given User goes to booking Login Page
        When User logs in to my booking account
        Then User should see the booking home page loaded
        And User navigates to a particular week on booking site
        Then User should see the booking Id <bookingId> on booking site
        Examples:
        |bookingId|
        |BJC935   |

    Scenario Outline: Test to verify Bookings on Carrier site
        Given User goes to booking Login Page
        When User logs in to my booking account
        Then User should see the booking home page loaded
        And User navigates to a particular week on carrier site
        Then User should see the booking Id <bookingId> on carrier site
        Examples:
            |bookingId|
            |BJC935   |

    Scenario: Create corporate booking
        Given User goes to booking Login Page
        And User logs in to my booking account
        When User creates a new booking "Bayswater | Farm" to "Plant | Yard" - 30 cows
        Then User should see the booking details on booking site
