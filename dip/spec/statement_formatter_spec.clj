(ns statement-formatter-spec
    (:require [speclj.core :refer :all]
            [dip.statement-formatter :refer :all]
            [dip.text-statement_formatter :refer :all]
            [dip.html-statement-formatter :refer :all]))

(declare statement-data)

(describe "Rental Statement Format"
          (with statement-data {:customer-name "CUSTOMER"
                                :movies [{:title "MOVIE"
                                          :price 9.9}]
                                :owed 100.0
                                :points 99})
          (it "Formats  a text rental statement"
              (should= (str "Rental Record for CUSTOMER\n"
                            "\tMOVIE\t9.9\n"
                            "You owed 100.0"
                            "You earned 99 frequent renter points\n")
                       (format-rental-statement
                        (make-text-formatter)
                        @statement-data
                        )))

          (it "Formats an html rental statement"
              (should= (str "<h1>Rental Record for CUSTOMER</h1>"
                            "<table>"
                            "<tr><td>MOVIE</td><td>9.9</td></tr>"
                            "</table>"
                            "You owed 100.0<br>"
                            "You earned <b>99</b> frequent renter points")
                       (format-rental-statement
                        (make-html-formatter)
                        @statement-data))))