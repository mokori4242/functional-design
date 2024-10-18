(ns main
  (:require [abstract-factory.shape-factory-implementation :as imp]))

(def shape-factory (atom nil))

(defn init[]
  (reset! shape-factory (imp/make)))
