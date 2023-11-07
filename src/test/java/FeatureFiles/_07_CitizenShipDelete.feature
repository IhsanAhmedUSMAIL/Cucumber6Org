#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)
#oluşturulan her CitizenShip i siliniz.
#yukarıdaki senaryoyu farklı 5 değer için çalıştırınız

Feature: Citizenship Functionality

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

    When User delete the "<name>"
    Then Success message should be displayed

      Examples:
        | name   | shortname |
        | ET0H55I00 | ET455100     |
        | ET1H55I11 | ET455111     |
        | ET2H55I22 | ET455122     |
        | ET3H55I33 | ET455133     |
        | ET4H55I44 | ET455144     |
        | ET5H55I55 | ET455155     |


