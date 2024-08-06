(ns core-spec
  (:require [speclj.core :refer :all]
            [copy.core :refer :all]))

(describe "copy"
          (it "can read and write using multi-method"
              (let [device {:device-type :test-device
                            :input (atom "abcdef")
                            :output (atom nil)}]
                (copy device)
                (should= "abcdef" @(:output device)))))