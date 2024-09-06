(ns dip.statment-formatter)

(defn format-rental-statement [statement-data]
  (let [customer-name (:customer-name statement-data)
        movies (:movies statement-data)
        owed (:owed statement-data)
        points (:points statement-data)]
    (str
     (format "Rental Record for %s\n" customer-name)
     (apply str
            (for [movie movies]
              (format "\t%s\t%.1f\n"
                      (:title movie)
                      (:price movie))))
     (format "You owed %.1f\n" owed)
     (format "You earned %d frequent renter points\n" points))))