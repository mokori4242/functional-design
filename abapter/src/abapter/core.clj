(ns abapter.core)

(defn turn-on-light [intensity]
  ;turn on the bloody light!
  )

(defmulti turn-on :type)
(defmulti turn-off :type)

(defmethod turn-on :valiable-light [switchable]
  (turn-on-light 100))

(defmethod turn-off :valiable-light [switchable]
  (turn-on-light 0))

(defn engage-switch [switchable]
  ;Some other stuff...
  (turn-on switchable)
  ;Some more other stuff...
  (turn-off switchable))
