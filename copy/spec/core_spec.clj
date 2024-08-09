(ns core-spec
  (:require [speclj.core :refer :all]
            [copy.core :refer :all]))

(describe "copy"
          (it "can read and write using str-read and str-write"
              (let [device (->str-device (atom "abcdef") (atom nil))]
                (copy device)
                (should= "abcdef" @(:out-atom device)))))