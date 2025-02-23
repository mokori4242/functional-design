(ns abstract-factory.circle
  (:require
   [abstract-factory.shape :as shape]))

(defn make [center radius]
  {::shape/type ::circle
   ::center center
   ::radius radius})

(defmethod shape/to-string ::circle [circle]
  (let [[x y] (::center circle)
        radius (::radius circle)]
    (format "Circle center: [%s,%s] radius: %s" x y radius)))