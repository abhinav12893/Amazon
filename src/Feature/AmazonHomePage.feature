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

  Scenario: Adding Iphone to Cart , Before proceeding to checkout I increase the quantity of Iphone
    Given Iam on the Homepage of Amazon India
    When I enter DeviceName in the Search TextBox
    |DeviceName|
    |Iphone    |
    And I click on the Search Button
    And All the related items are shown on the next page
    And I click on a device
    And Device details should open in a new tab
    And I click on Add to Cart Button
    And I click on Cart Button
    And I increase the quantity
    Then More Iphones should get Added






  Scenario: Selecting iphone from Result displayed , adding it to the cart and proceeding to checkout

    Given Iam on the Homepage of Amazon India
    When I enter DeviceName in the Search TextBox
      |DeviceName|
      |Iphone    |
    And I click on the Search Button
    And All the related items are shown on the next page
    And I click on a device
    And Device details should open in a new tab
    And I click on Add to Cart Button
    Then Device should get added to the cart
    And I click on Proceed to checkout
    Then Amazon should ask for Sign In





  Scenario: Sign In for checkout
    Given Iam on the Homepage of Amazon India
    And I enter DeviceName in the Search TextBox
    |DeviceName|
    |Iphone    |
    And I click on the Search Button
    And I click on a device
    And Device details should open in a new tab
    And I click on Add to Cart Button
    And I click on Proceed to checkout
    And I enter username and password
    |UserName               |Password|
    |iabhisharma12@gmail.com|Abhi@12893|
    And I click on Login
    Then User should be signed in and Address Page should be shown