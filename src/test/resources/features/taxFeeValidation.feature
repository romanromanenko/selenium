Feature: Tax fee validation

  Background:
    Given Open app

  Scenario Outline: Tax fee validation
    When User open catalog
    And User switch to Art tab
    And User open details of item
    And User add item to cart
    And User move to checkout
    And User continue checkout as a guest
    And User fill address data "<address>" "<state>" "<city>" "<zipCode>"
    And User move to Add payment detail page
    Then User check the tax fee "<tax_fee>"

    Examples:
      | address                     | state           | city            | zipCode | tax_fee |
      | 813 Vine St                 | Arkansas        | Corning         | 72422   | 9.75    |
      | 1264 Wells Rd               | Georgia         | Carnesville     | 30521   | 8       |
      | 11722 N Magoun Dr           | Indiana         | Saint John      | 46373   | 7       |
      | 111 Old Dolph Rd            | Arkansas        | Calico Rock     | 72519   | 10      |
      | 1128 S I Ave                | Iowa            | Nevada          | 50201   | 6       |
      | 1958 Farrel Dr              | Iowa            | Coralville      | 52241   | 6       |
      | 1633 S Osage Dr             | Kansas          | Ottawa          | 66067  `| 9.6     |
      | 710 2nd St                  | Kansas          | Mc Cune         | 66753   | 8.5     |
      | 165 Mabry RDG               | Kentucky        | Morehead        | 40351   | 6       |
      | 9580 Edward Dr              | Michigan        | Brighton        | 48114   | 6       |
      | 16558 Farrago Trl           | Minnesota       | Farmington      | 55024   | 7.13    |
      | 7601 Irvin Avenue Ct S      | Minnesota       | Cottage Grove   | 55016   | 7.37    |
      | 18540 Highland Ave          | Minnesota       | Wayzata         | 55391   | 7.53    |
      | 3265 40th Ave               | Nebraska        | Columbus        | 68601   | 7       |
      | 1091 COUNTY ROAD 24         | Nebraska        | Craig           | 68019   | 5.5     |
      | 245 ELQUIST DR              | Nevada          | Sun Valley      | 89433   | 8.27    |
      | 4445 Maxine Dr              | Nevada          | Winnemucca      | 89445   | 6.85    |
      | 701 Elm St SPC 70           | Nevada          | Boulder City    | 89005   | 8.37    |
      | 35 N 6th Ave                | New Jersey      | Highland Park   | 08904   | 6.63    |
      | 2176 Ferry Rd               | North Carolina  | Mooresboro      | 28114   | 7.01    |
      | 635 Chisenhall Rd           | North Carolina  | Angier          | 27501   | 6.75    |
      | 4262 110th Ave SW           | North Dakota    | Dickinson       | 58601   | 5       |
      | 4 Bobcat Dr                 | North Dakota    | Gwinner         | 58040   | 7       |
      | 2014 Queens Meadow Ln       | Ohio            | Grove City      | 43123   | 7.51    |
      | 16951 Bodman Rd             | Ohio            | Mount Orab      | 45154   | 7.25    |
      | 9540 Douglas Ln             | Oklahoma        | Lexington       | 73051   | 6.63    |
      | 474367 E 1010 RD            | Oklahoma        | Muldrow         | 74948   | 5.92    |
      | 891 S Boyd Pl               | Oklahoma        | Sapulpa         | 74066   | 9.67    |
      | 432 Davisville Rd           | Rhode Island    | North Kingstown | 02852   | 7       |
      | 715 Saint Jerome St         | South Dakota    | Harrisburg      | 57032   | 6.5     |
      | 15745 W Andrew Johnson Hwy  | Tennessee       | Bulls Gap       | 37711   | 9.75    |
      | 134 Colonial Hts            | Tennessee       | La Follette     | 37766   | 9.25    |
      | 4545 Big Hill Rd            | Tennessee       | Liberty         | 37095   | 8.75    |
      | 3224 S Vernal Ave           | Utah            | Vernal          | 84078   | 6.45    |
      | 628 E Wagon Trail Dr        | Utah            | Cedar City      | 84721   | 6.21    |
      | 2 Burlington Sq             | Vermont         | Burlington      | 05401   | 7       |
      | 28711 S Boston Rd           | Washington      | Cheney          | 99004   | 8.1     |
      | 182 Oakledge Ln             | West Virginia   | Princeton       | 24739   | 6       |
      | 3219 E Ramsey Ave           | Wisconsin       | Cudahy          | 53110   | 5.5     |
      | 5016 Foxen Ct               | Wyoming         | Cheyenne        | 82001   | 6       |





