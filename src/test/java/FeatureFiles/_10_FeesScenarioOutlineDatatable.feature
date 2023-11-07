# Senaryo:
# Daha önceki Fee Functionality Senaryosunu
# name, code , intCode ve priority içi 5 farklı kombinasyon için çalıştırınız.

  Feature: Fees multiple values functionality

    Background:
      Given Navigate to Campus
      When Enter username and password and click login button
      Then User should login successfully

    Scenario Outline: Fee Functionality

      And Click on the element in LeftNav
        | setup         |
        | parameters    |
        | fees          |

      And Click on the element in Dialog
        |addButton    |

      And User sending the keys in Dialog
        | nameInput         | <name>     |
        | codeInput         | <code>     |
        | integrationCode   | <intCode>  |
        | priorityCode      | <priority> |

      And Click on the element in Dialog
        | toggleBar  |
        | saveButton |

      Then Success message should be displayed

      And User delete the element from Dialog
        | <name> |

      Then Success message should be displayed
      Examples:
        | name    | code | intCode  | priority |
        | IhsFee6 | 4141 | PayPal   | 3211     |
        | IhsFee7 | 4142 | Csh      | 3212     |
        | IhsFee8 | 4143 | Cheque   | 3213     |
        | IhsFee9 | 4144 | ApplePay | 3214     |
        | IhsFee1 | 4145 | Crypto   | 3215     |




