(ns core-spec
  (:require [speclj.core :refer :all]
            [abapter.core :refer :all]))

(describe "Adapter"
          (with-stubs)
          (it "turns light on and off"
              (with-redefs [turn-on-light (stub :turn-on-light)]
                (engage-switch {:type :valiable-light})
                (should-have-invoked :turn-on-light {:times 1 :with [100]})
                (should-have-invoked :turn-on-light {:times 1 :with [0]}))))
