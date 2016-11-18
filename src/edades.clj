(ns edades)

(defprotocol Envejecedor
  (cumplir_años [x]))

(extend-protocol Envejecedor
  Object
  (cumplir_años [object]
    "Todos los objetos envejecen de a un año"
    (assoc object :age (+ (:age object) 1))))

(defrecord Tree [age])

(defrecord Cat [name age])

(defrecord Owl [name age]
  Envejecedor
  (cumplir_años [this]
    "Las lechuzas no envejecen"
    this))

(defrecord Zoo [animals]
  Envejecedor
  (cumplir_años [this]
    "hace cumplir un año a todos sus animales"
    (assoc this :animals (map cumplir_años animals))))
