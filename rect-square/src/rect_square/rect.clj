(ns rect-square.rect)

(defn make-rect [h w]
  {:h h :w w})

(defn rect-set-h [rect h]
  (assoc rect :h h))

(defn rect-set-w [rect w]
  (assoc rect :w w))

(defn rect-area [rect]
  (* (:h rect) (:w rect)))

(defn rect-perimeter [rect]
  (let [{:keys [h w]} rect]
    (* 2 (+ h w))))

(defn minimally-increase-rect-area [rect]
  (let [{:keys [h w]} rect]
    (cond
      (>= h w) (make-rect (inc h) w)
      (> w h) (make-rect h (inc w))
      :else :tilt)))