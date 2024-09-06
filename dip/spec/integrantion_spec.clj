(ns integrantion-spec
  (:require [speclj.core :refer :all]
            [dip.statment-calculator :refer :all]
            [dip.statment-formatter :refer :all]))


(describe "Integration Tests"
          (it "formats a statement for several regular movies"
              (should= (str "Rental Record for Fred\n"
                            "\tPlan 9 from Outer Space\t2.0\n"
                            "\t8 1/2\t2.0\n"
                            "\tEraserhead\t3.5\n"
                            "You owed 7.5\n"
                            "You earned 3 frequent renter points\n")
                       (format-rental-statement
                        (make-statement-data
                         (make-rental-order
                          (make-customer "Fred")
                          [(make-rental
                            (make-movie
                             "Plan 9 from Outer Space" :regular)
                            1)
                           (make-rental
                            (make-movie "8 1/2", :regular)
                            2)
                           (make-rental
                            (make-movie "Eraserhead" :regular)
                            3)]))))))