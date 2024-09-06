(ns statment-formatter-spec
  (:require [speclj.core :refer :all]
            [dip.statment-formatter :refer :all]))

(describe "Rental Statement Format"
          (it "Formats a rental statement"
              (should= (str "Rental Record for CUSTOMER\n"
                            "\tMOVIE\t9.9\n"
                            "You owed 100.0\n"
                            "You earned 99 frequent renter points\n")
                       (format-rental-statement
                        {:customer-name "CUSTOMER"
                         :movies [{:title "MOVIE"
                                   :price 9.9}]
                         :owed 100.0
                         :points 99}))))