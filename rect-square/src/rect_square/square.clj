(ns rect-square.square)

(defn make-square [side]
  {:side side})

(defn square-area [square]
  (let [side (:side square)]
    (* side side)))

(defn square-perimeter [square]
  (* 4 (:side square)))

(defn square-set-side [square side]
  (assoc square :side side))

(defn minimally-increase-square-area [square]
  (let [side (:side square)]
    (make-square (inc side))))