(ns dip.constructors
  (:require [clojure.string :as str]))

(defn make-customer [name]
  {:name name})

(defn make-movie [title type]
  {:title title
   :type type})

(defn make-rental [movie days]
  {:movie movie
   :days days})

(defn make-rental-order [customer rentals]
  {:customer customer
   :rentals rentals})

(defn determine-amount [rental]
  (let [{:keys [movie days]} rental
        type (:type movie)]  ;; movieからtypeを取り出す
    (cond
      (= type :regular)  ;; typeが:regularの場合
      (if (> days 2)
        (+ 2.0 (* (- days 2) 1.5))
        2.0)

      (= type :new-release)  ;; typeが:new-releaseの場合
      (* 3.0 days)

      (= type :childrens)  ;; typeが:childrensの場合
      (if (> days 3)
        (+ 1.5 (* (- days 3) 1.5))
        1.5))))

(defn determine-points [rental]
  (let [{:keys [movie days]} rental
        type (:type movie)]
    (if (and (= type :new-release)
             (< days 1))
      2
      1)))

(defn make-detial [rental]
  (let [title (:title (:movie rental))
        price (determine-amount rental)]
    (format "\t%s\t%.1f" title price)))  ;; '%.if'を修正

(defn make-details [rentals]
  (map make-detial rentals))

(defn make-footer [rentals]
  (let [owed (reduce + (map determine-amount rentals))
        points (reduce + (map determine-points rentals))]
    (format
     "\nYou owed %.1f\nYou earned %d frequent renter points\n"  ;; '%.if'を修正
     owed points)))

(defn make-statement [rental-order]
  (let [{:keys [customer rentals]} rental-order  ;; customerとrentalsを取り出す
        name (:name customer)
        header (format "Rental Record for %s\n" name)
        details (str/join "\n" (make-details rentals))
        footer (make-footer rentals)]
    (str header details footer)))
