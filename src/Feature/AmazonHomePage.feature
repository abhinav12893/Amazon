Feature: Opening Amazon HomePage and Searching for Iphone 6s

  Scenario: If user searches for Iphone 6s in the search textbox , then all related items should be shown

    Given Iam on the Homepage of Amazon India
    When I enter DeviceName in the Search TextBox
    |DeviceName|
    |Iphone    |
    And I click on the Search Button
    Then All the related items should be shown on the next page

Scenario: Selecting iphone from Result displayed when searched for Iphone

  Given Iam on the Homepage of Amazon India
  When I enter DeviceName in the Search TextBox
    |DeviceName|
    |Iphone    |
  And I click on the Search Button
  And All the related items are shown on the next page
  And I click on a device
  Then Device details should open in a new tab




