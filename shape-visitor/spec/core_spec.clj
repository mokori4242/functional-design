(ns core-spec
  (:require [speclj.core :refer :all]
            [shape-visitor
             [square :as square]
             [json-shape-visitor :as jv]
             [circle :as circle]
             [main]]))

(describe "shape-visitor"
          (it "make json square"
              (should= "{\"top-left\": [0,0], \"side\": 1}"
                       (jv/to-json (square/make [0 0] 1))))

          (it "make json circle"
              (should= "{\"center\": [3,4], \"radius\": 1}"
                       (jv/to-json (circle/make [3 4] 1)))))