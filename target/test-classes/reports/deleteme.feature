Feature: Filter Section

    Scenario Outline: Selecting the layout dropdown
        Given The reports page is loaded
        When I click on the "<dropdown>" dropdown
        And I click on the "<dropdown-option>" option
        Then I should see the "<dropdown-option>" selected

        Examples:
          | dropdown            | dropdown-option |
          |  Layout Filter  | first   |
          |  Ruleset Filter  | first   |

