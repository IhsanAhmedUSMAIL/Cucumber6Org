Feature: DataTable Ornek

  Scenario: User List
    When write username "Ihsan"
    And Write username and Password "Ihsan" and "4321"

    And Write username as DataTable
    | Ihsan |
    | Ahmed |
    | Eman  |
    | Adil  |

    And Write username and Password as DataTable

      | Ihsan | | 123 |
      | Ahmed | | 1234 |
      | Eman  | | 12345  |
      | Adil  | | 123456  |

 #  dataProvider(testNG için) , senaryo
 #  Görevi : verilen değer , tüm senaryo
 #
