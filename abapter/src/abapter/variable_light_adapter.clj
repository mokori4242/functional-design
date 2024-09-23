(ns abapter.variable-light-adapter
  (:require [abapter.switchable :as s]
            [abapter.variable-light :as v-1]))

(defn make-adapter [min-intensity max-intensity]
  {:type :variable-light
   :min-intensity min-intensity
   :max-intensity max-intensity})

(defmethod s/turn-on :variable-light [variable-light]
  (v-1/turn-on-light {:max-intensity variable-light}))

(defmethod s/turn-off :variable-light [variable-light]
  (v-1/turn-on-light {:min-intensity variable-light}))