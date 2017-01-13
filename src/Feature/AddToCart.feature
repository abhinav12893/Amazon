Feature: Adding selected Device to the Cart

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