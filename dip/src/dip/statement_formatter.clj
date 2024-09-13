(ns dip.statement-formatter)

(defmulti format-rental-statement (fn [formatter _statement-data]
                                    (:type formatter)))