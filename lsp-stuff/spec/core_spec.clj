(ns core-spec
  (:require [speclj.core :refer :all]
            [lsp-stuff.core :refer :all]))

(defn test-is-payday [employee-data pay-date]
  true)


(defn test-calc-pay [employee-data]
  (:pay employee-data))

(defn test-send-paycheck [employee-data paycheck]
      (format "Send %d to: %s at: %s"
              paycheck
              (:name employee-data)
              (:address employee-data)))

(defn make-test-employee [name address pay]
  (let [employee-data {:name name
                       :address address
                       :pay pay}

        employee {:emloyee-data employee-data
                  :is-payday (partial test-is-payday employee-data)
                  :calc-pay (partial test-calc-pay employee-data)
                  :send-paycheck (partial test-send-paycheck employee-data)}]
    employee))

(defn make-later-employee [name address pay]
  (let [employee (make-test-employee name address pay)
        is-payday? (fn [pay-date] (= pay-date :tomorrow))]  ;; :tomorrow をチェックする関数
    (assoc employee :is-payday is-payday?)))


(describe "Payroll"
          (it "pays a salaried employee"
              (should= "Send 100 to: name at: address"
                       (pay (make-test-employee "name" "address" 100)
                            :today)))

 (it "does not pay an employee whose payday is not today"
     (should-be-nil (pay (make-later-employee "name" "address" 2000) :now)))
          ) ;; 明日支払うためnilが期待される
