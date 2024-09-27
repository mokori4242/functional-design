(ns composite-switchable.variable-light
  (:require [composite-switchable.switchable :as s]))

(defn make-variable-light [] {:type :variable-light})

(defn set-light-intensity [intensity])

(defmethod s/turn-on :variable-light [switchable]
  (set-light-intensity 100))

(defmethod s/turn-off :variable-light [switchable]
  (set-light-intensity 0))