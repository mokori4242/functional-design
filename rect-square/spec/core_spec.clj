(ns core-spec
  (:require [speclj.core :refer :all]
            [rect-square.square :refer :all]
            [rect-square.rect :refer :all]))

(describe "Rectangle"
          (it "calculates proper area and perimeter"
              (should= 25 (rect-area (make-rect 5 5)))
              (should= 18 (rect-perimeter (make-rect 4 5)))
              (should= 12 (-> (make-rect 1 1) (rect-set-h 3) (rect-set-w 4) rect-area)))

          (it "minimally increases area"
              (should= 15 (-> (make-rect 3 4) minimally-increase-rect-area rect-area))
              (should= 24 (-> (make-rect 5 4) minimally-increase-rect-area rect-area))
              (should= 20 (-> (make-rect 4 4) minimally-increase-rect-area rect-area))))

(describe "Square"
          (it "calculates proper area and perimeter"
              (should= 36 (square-area (make-square 6)))
              (should= 20 (square-perimeter (make-square 5)))
              (should= 9 (-> (make-square 1) (square-set-side 3) square-area)))


          (it "minimally increases area"
              (should= 36 (-> (make-square 5) minimally-increase-square-area square-area))))