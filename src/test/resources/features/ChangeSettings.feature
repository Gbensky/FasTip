Feature: ChangeSettings

  Background:
    Given User opens app for settings
    Then User moves to Settings page

  Scenario: Changes sites
    Given User is on the Settings page
    When User enters Tip Percent
    And clicks on the Save Settings Button
    Then user confirms settings has been saved successfully