(ns composite-switchable.composite-switchable
  (:require [composite-switchable.switchable :as s]))

(defn make-composite-switchable []
  {:type :composite-switchable
   :switchable []})

(defn add [composite-switchable switchable]
  (update composite-switchable :switchable conj switchable))

(defmethod s/turn-on :composite-switchable [c-switchable]
  (doseq [s-able (:switchable c-switchable)]
    (s/turn-on s-able)))

(defmethod s/turn-off :composite-switchable [c-switchable]
  (doseq [s-able (:switchable c-switchable)]
    (s/turn-off s-able)))
