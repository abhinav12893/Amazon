Feature: Place order and move to payment gateway


Scenario: Placing the order and moving to payment gateway
Given Iam on the Homepage of Amazon India
And I enter DeviceName in the Search TextBox
|DeviceName|
|Iphone    |
And I click on the Search Button
And I click on a device
And I click on Add to Cart Button
And I click on Cart Button
And I increase the quantity
And I click on Proceed to checkout
And I enter username and password
|UserName               |Password|
|iabhisharma12@gmail.com|Abhi@12893|
And I click on Login
And I select Delivery Address
And I click on Continue
And I click on Debit Card Payment
And I select Bank from the dropdown
And I click on Continue To Place Order
And I click on Place your order button
Then I should be redirected to payment gateway