(ns turtle-graphics.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  ;; 背景色を白に設定
  (q/background 255))

(defn draw []
  ;; ランダムな位置に円を描画
  (q/ellipse (q/random (q/width)) (q/random (q/height)) 50 50))

(q/defsketch example
  :title "Quil Example"
  :setup setup
  :draw draw
  :size [500 500]
  :middleware [m/fun-mode])
