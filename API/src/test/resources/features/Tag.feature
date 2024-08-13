Feature:  user should be able to use tag
Scenario Outline: verify user can create a tag
Given base url "https://backend.cashwise.us/"
When I provide valid token
And I provide "name_tag" with "<name_tag>"
And I provide "description" with "<description>"
And I hit POST endpoint "api/myaccount/tags"
Then verify status code is 201
And verify response body contains "name_tag" with "<name_tag>"
  And i retrieve id "id"
  And i hit DELETE endpoint "api/myaccount/tags/"
  Then verify status code is 200

Examples:
  | name_tag  | description           |
  | apple121  | apple tag             |
  | cat121    | short tag description |
  | orange121 |                       |


#  create new tag
#  catch its id
#  update this tag
#  get tag
#  delete tag


#  Scenario Outline: verify tag cannot be created without required field name_tag
#    Given base url "https://backend.cashwise.us/"
#    When I provide valid authorization token
#    And I provide "name_tag" with "<name_tag>"
#    And I provide "description" with "benas tag description"
#    And I hit POST endpoint "api/myaccount/tags"
#    Then verify status code is 400
#    And verify message "<error_message>"
#    Examples:
#      |name_tag| error_message    |
#      |        | missing name_tag |
#      | null   | missing name_tag |
#      |#$BRB   | wrong name_tag, please make sure no digits and special chars are used |
#      |bena2   | wrong name_tag, please make sure no digits and special chars are used |
#      |extra long name tag | wrong name_tag, size limit is 25 chars|
#      |name with spaces| wrong name_tag, no spaces allowed |