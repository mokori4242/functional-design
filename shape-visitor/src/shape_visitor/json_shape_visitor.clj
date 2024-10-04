(ns shape-visitor.json-shape-visitor
  (:require [shape-visitor
             [shape :as shape]]))

(defmulti to-json ::shape/type)