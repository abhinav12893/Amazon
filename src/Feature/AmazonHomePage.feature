Feature: Opening Amazon HomePage and Searching for Iphone 6s

  Scenario Outline: If user searches for Iphone 6s in the search textbox , then all related items should be shown

    Given Iam on the Homepage of Amazon India
    When I enter <PhoneName> in the Search TextBox
    And I click on the Search Button
    Then All the related items should be shown on the next page

    Examples:
    |PhoneName|
    |Iphone   |