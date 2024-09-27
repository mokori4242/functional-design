(ns core-spec
  (:require [speclj.core :refer :all]
            [composite-switchable
             [light :as l]
             [variable-light :as v]
             [switchable :as s]
             [composite-switchable :as cs]]
            [composite-switchable.light :as l]
            [composite-switchable.variable-light :as v]
            [composite-switchable.composite-switchable :as cs]
            [composite-switchable.switchable :as s]))

(describe "composite-switchable"
          (with-stubs)
          (it "turns all on"
              (with-redefs [l/turn-on-light (stub :turn-on-light)
                            v/set-light-intensity (stub :set-light-intensity)]
                (let [group (-> (cs/make-composite-switchable)
                                (cs/add (l/make-light))
                                (cs/add (v/make-variable-light)))]
                  (s/turn-on group)
                  (should-have-invoked :turn-on-light)
                  (should-have-invoked :set-light-intensity {:with [100]})))))