#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)

  Feature: Citizenship Functionality

    Background:
      Given Navigate to Campus
      When Enter username and password and click login button
      Then User should login successfully
      And Navigate to Citizenship

    Scenario Outline: Create a Citizenship
      When Create a Citizenship name as "<name>" short name as "<shortname>"
      Then Success message should be displayed

      When Create a Citizenship name as "<name>" short name as "<shortname>"
      Then Already exist message should be displayed

      Examples:
        | name   | shortname |
        | ET0HI0 | ET410     |
        | ET1HI1 | ET411     |
        | ET2HI2 | ET412     |
        | ET3HI3 | ET413     |
        | ET4HI4 | ET414     |
        | ET5HI5 | ET415     |