Feature: Layouts Page loads on most popular browsers

    Layouts page loads correctly with all of the functionalities

    Scenario Outline: Page loads on "<driver>"
      Given "<driver>" browser exists
      When the user goes or is redirected to "http://localhost:9003/"
      Then user is presented with the layouts page

      Examples:
          | driver         |
          | chrome         |
          | edge           |
