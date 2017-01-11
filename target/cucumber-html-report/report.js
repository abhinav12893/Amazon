$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/home/ee/Desktop/Abhinav/Amazon/src/Feature/AmazonHomePage.feature");
formatter.feature({
  "line": 1,
  "name": "Opening Amazon HomePage and Searching for Iphone 6s",
  "description": "",
  "id": "opening-amazon-homepage-and-searching-for-iphone-6s",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "If user searches for Iphone 6s in the search textbox , then all related items should be shown",
  "description": "\nGiven: Iam on the Homepage of Amazon India\nWhen: I enter \u003cPhoneName\u003e in the Search TextBox\nAnd: I click on the Search Button\nThen: All the related items should be shown on the next page\n\nExamples:\n|PhoneName|\n|Iphone 6s|",
  "id": "opening-amazon-homepage-and-searching-for-iphone-6s;if-user-searches-for-iphone-6s-in-the-search-textbox-,-then-all-related-items-should-be-shown",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
});