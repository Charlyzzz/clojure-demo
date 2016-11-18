(ns edades-test
  (require [clojure.test :refer :all]
           [edades :refer :all]))

(let [mumi (->Cat "Mumi" 12)
      hedwig (->Owl "Hedwig" 50)
      hangingTree (->Tree 1000)
      sanDiegoZoo (->Zoo [mumi, hedwig, hangingTree])]

  (deftest cat-ages-by-one-year
    (is (= (:age (cumplir_años mumi)) 13)))

  (deftest trees-ages-by-one-year
    (is (= (:age (cumplir_años hangingTree) 1001))))

  (deftest owls-doesnt-age
    (is (= (:age (cumplir_años hedwig) 50))))

  (deftest zoo-ages-all-its-animals
    (is (= (apply (comp (partial map :age) :animals)
                  [(cumplir_años sanDiegoZoo)]) [13, 50, 1001]))))
