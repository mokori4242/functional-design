(ns dip.buy-two-get-one-free-policy
  (:require [dip.statement-policy :refer :all]
            [dip.normal-statement-policy :as normal]))

(derive ::buy-two-get-one-free ::normal/normal)

(defn make-buy-two-get-one-free-policy [] {:type ::buy-two-get-one-free})

(defmethod total-amount ::buy-two-get-one-free [policy rentals]
  (let [amounts (map #(determine-amount policy %) rentals)]
    (if (> (count amounts) 2)
      (reduce + (drop 1 (sort amounts)))
      (reduce + amounts))))