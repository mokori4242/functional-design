(ns copy.core)

 (defprotocol device
   (getchar [_])
   (putchar [_ c]))

(defn copy [device]
  (let [c (getchar device)]
    (if (= c :eof)
      nil
      (do
        (putchar device c)
        (recur device)))))

  (defrecord str-device [in-atom out-atom]
   device
   (getchar [_]
     (let [c (first @in-atom)]
       (if (nil? c)
         :eof
         (do
           (swap! in-atom rest)
           c))))
   (putchar [_ c]
     (swap! out-atom str c)))