# Senaryo: States menusunden gelen ilk 10 verinin DB deki ile
# Data ile aynı olup olmadığını kontrol ediniz.


Feature: Testing JDBC States

  Background:
    Given Navigate to Campus
    When  Enter username and password and click login button
    Then User should login successfully

    Scenario:  State testing with JDBC
      And Click on the element in LeftNav
      | setup      |
      | parameters |
      | states     |
    Then Send The Query the Database "select * from states limit 10" and control match


