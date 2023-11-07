Feature: DataTable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create Country
    And Click on the element in LeftNav
      | setup       |
      | parameters  |
      | countries   |

    And Click on the element in Dialog
      |addButton    |

    And  User sending the keys in Dialog
      | nameInput   | Ihs1etUlk1 |
      | codeInput   | IhsKod1 |

    And  Click on the element in Dialog
      | saveButton  |

    Then Success message should be displayed

    And  User delete the element from Dialog
      | Ihs1etUlk1 |

    Then Success message should be displayed


  Scenario:  Create Nationality
    And Click on the element in LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the element in Dialog
      | addButton |

    And  User sending the keys in Dialog
        | nameInput   | Ihs1etNat1 |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And  User delete the element from Dialog
        | Ihs1etNat1 |

      Then Success message should be displayed


  Scenario: Fee Functionality

    And Click on the element in LeftNav
      | setup         |
      | parameters    |
      | fees          |

    And Click on the element in Dialog
      |addButton    |

    And  User sending the keys in Dialog
      | nameInput         | IhsFeeFun1 |
      | codeInput         | 123456 |
      | integrationCode   | 1212 |
      | priorityCode      | 2323 |

    And  Click on the element in Dialog
      | toggleBar   |
      | saveButton  |

    Then Success message should be displayed

    And  User delete the element from Dialog
      | IhsFeeFun1 |

    Then Success message should be displayed