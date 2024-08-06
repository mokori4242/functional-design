(ns copy.core)

(defmulti getchar (fn [device] (:device-type device)))
(defmulti putchar (fn [device c] (:device-type device)))

(defn copy [device]
  (let [c (getchar device)]
    (if (= c :eof)
      nil
      (do
        (putchar device c)
        (recur device)))))

(def str-in (atom nil))
(def str-out (atom nil))

(defn str-read []
  (let [c (first @str-in)]
    (if (nil? c)
      :eof
      (do
        (swap! str-in rest)
        c))))

(defn str-write [c]
  (swap! str-out str c)
  str-write)

(defmethod getchar :test-device [device]
 (let [input (:input device)
       c (first @input)]
   (if (nil? c)
     :eof
     (do
       (swap! input rest)
       c))))

(defmethod putchar :test-device [device c]
 (let [output (:output device)]
   (swap! output str c)))