(ns core-spec
  (:require [speclj.core :refer :all]
            [abapter.engage-switch :refer :all]
            [abapter.variable-light :as v-l]
            [abapter.variable-light-adapter :as v-l-adapter]))

(describe "Adapter"
          (with-stubs)
          (it "turns light on and off"
              (with-redefs [v-l/turn-on-light (stub :turn-on-light)]
                (engage-switch (v-l-adapter/make-adapter 5 90))
                (should-have-invoked :turn-on-light {:times 1 :with [90]})
                (should-have-invoked :turn-on-light {:times 1 :with [5]}))))