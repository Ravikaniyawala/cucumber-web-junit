@smoketest
Feature: Jobs maintaining
  As carrier user
  I want to maintain my jobs
  So I can manage it properly

  Scenario: Create large contract job
    Given User goes to booking Login Page
    And User logs in to my booking account
    And User creates a new booking "Bayswater | Farm" to "Plant | Yard" - 100 cow
    And User goes to carrier Login Page
    And User logs in to my carrier account
    When User creates large contract job for booking
    Then User should see large contract

  Scenario: Create split from a job
    Given User goes to booking Login Page
    And User logs in to my booking account
    And User creates a new booking "Bayswater | Farm" to "Plant | Yard" - 80 cow
    And User goes to carrier Login Page
    And User logs in to my carrier account
    When User splits job for the booking
    Then User should see split jobs for booking

  Scenario: Create a job (with notes)
    Given User goes to carrier Login Page
    And User logs in to my carrier account
    When User creates job with Short note "Test short note", Notes "Test notes", Office notes "Test office notes"
    Then User should see notes for the job

  Scenario: Copy a job (with notes)
    Given User goes to carrier Login Page
    And User logs in to my carrier account
    When User copies job and change quantity
    Then User should see copied job on carrier site

  Scenario: Link a job to a booking
    Given User goes to carrier Login Page
    And User logs in to my carrier account
    And User navigates to a particular week on carrier site
    When User link job "Bayswater | Farm" to "Plant | Yard" - 15 cow with booking "Bayswater | Farm" to "Plant | Yard" - 60 cow
    Then User should see booking against job on carrier site

  Scenario: Schedule a job with a limited time window
    Given User goes to carrier Login Page
    And User logs in to my carrier account
    When User creates job "Bayswater | Farm" to "Plant | Yard" - 15 cows with depart time 12:00am - 02:00am and arrival time 12:00pm to 03:00pm

  Scenario: Create job with pick up and drop off on different days (interisland)
    Given User goes to carrier Login Page
    And User logs in to my carrier account
    When User creates job with pick up and drop off on different days
    Then User can see different weekdays on carrier site

  Scenario: Reassign a job
    Given User goes to carrier Login Page
    And User logs in to my carrier account
    And User creates job
    When User reassign to another truck
    Then Updated truck shows on carrier site for the job

  Scenario: Edit a job
    Given User goes to carrier Login Page
    And User logs in to my carrier account
    And User creates job
    When User change quantity for the job
    Then Updated quantity shows on carrier site

  Scenario: Edit start and end depot location
    Given User goes to carrier Login Page
    And User logs in to my carrier account
    And User creates job
    When User changes start and end depot location
    Then Updated start and end depot location shows on carrier site

  Scenario: Contact details hover over
    Given User goes to carrier Login Page
    And User logs in to my carrier account
    And User navigates to a particular week on carrier site
    When User hover contact icon for booking BJC935
    Then User should see contact information


  Scenario: Delete a job from corporate and verify booking site
    Given User goes to booking Login Page
    And User logs in to my booking account
    When User delete booking "Bayswater | Farm" to "Plant | Yard" - 200 cow
    Then User should see booking is canceled on booking site

  Scenario: Delete a job from corporate and verify carrier site
    Given User goes to carrier Login Page
    And User logs in to my carrier account
    When User delete booking "Bayswater | Farm" to "Plant | Yard" - 60 cow
    Then User should see booking is canceled on carrier site

  Scenario: Delete a job created by carrier
    Given User goes to carrier Login Page
    And User logs in to my carrier account
    When User delete job for booking "Bayswater | Farm" to "Plant | Yard" - 15 cow
    Then User should not see job on carrier site



