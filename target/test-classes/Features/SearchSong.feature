Feature: Search song Feature

  Scenario Outline: Search song top result with song title '<songTitle>'
    Given open browser
    And open youtube music
    Then user in youtube music page
    When user click search box
    And user type "<songTitle>" in searh box and enter
    Then user can see top result section

    Examples:
      | songTitle           |
      | killing in the name |

