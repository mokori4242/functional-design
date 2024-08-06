(ns core-spec
  (:require [speclj.core :refer :all]
            [copy.core :refer :all]))

(describe "copy"
          (it "can read and write using str-read and str-write"
              (reset! str-in "abcedf")
              (reset! str-out "")
              (copy {:getchar str-read :putchar str-write})
              (should= "abcedf" @str-out)))