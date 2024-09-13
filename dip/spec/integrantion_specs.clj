(ns integrantion-specs
  (:require [speclj.core :refer :all]
            [dip.constructors :refer :all]
            [dip.text-statment-formatter :refer :all]
            [dip.normal-statement-policy :refer :all]
            [dip.order-processing :refer :all]))

(declare rental-order)

(describe "Integration Tests"
          (with rental-order  (make-rental-order
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
                                3)]))
          (it "formats a text statement"
              (should= (str "Rental Record for Fred\n"
                            "\tPlan 9 from Outer Space\t2.0\n"
                            "\t8 1/2\t2.0\n"
                            "\tEraserhead\t3.5\n"
                            "You owed 7.5\n"
                            "You earned 3 frequent renter points\n")
                       (process-order
                        (make-normal-policy)
                        (make-text-formatter)
                        @rental-order))))