(ns dip.order-processing
  (:require [dip.statement-formatter :refer :all]
            [dip.statement-policy :refer :all]))

(defn process-order [policy formatter order]
  (->> order
       (make-statement-data policy)
       (format-rental-statement formatter)))