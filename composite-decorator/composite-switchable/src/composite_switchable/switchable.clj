(ns composite-switchable.switchable)

(defmulti turn-on :type)
(defmulti turn-off :type)