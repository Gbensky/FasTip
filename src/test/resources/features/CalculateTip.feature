Feature: CalculateTip

  Background:
    Given User opens app

  Scenario: Launched app
    Then User should see app fully loaded

  Scenario: Calculate Tip
    When User enters bill amount
    And clicks on the Calculate Tip Button
    Then User should see Tip amount as Tip Percentage multiplied by bill amount
    And Total Amount as bill amount plus Tip Amount