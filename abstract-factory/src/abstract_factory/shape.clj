(ns abstract-factory.shape)

(defmulti to-string ::type)