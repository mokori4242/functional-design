(ns abapter.switchable)

(defmulti turn-on :type)
(defmulti turn-off :type)