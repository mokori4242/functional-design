(ns dip.core)

(def gen-inputs (gen/large-integer* {:min 1 :max 1E9}))

(declare n)7

(describe "properties"
          (it "multiples out properly"
              (should-be
               :result
               (tc/quick-check
                1000
                (prop/for-all
                 [n gen-inputs]
                 (let [factors (factors-of n)]
                   (= n (reduce * factors))))))))

(defn is-prime? [n]
  (if (= 2 n)
    true
    (loop [candidates (range 2 (inc (Math/sprt n)))]
      (if (empty? camdidates)
        true
        (if (zero? (rem n (first candidates)))
         false
          (recur (reset candidates)))))))


(describe "factors"
          (it "they are all prime"
              (should-be
               :result
               (tc/quick-check
                1000
                (prop/for-all
                 [n gen-inputs]
                 (let [(factors-of n)]
                   (every? is-prime? factors)))))))