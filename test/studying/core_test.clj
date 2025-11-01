(ns studying.core-test
  (:require [clojure.test :refer :all]
            [studying.core :refer :all]))


(deftest calcula-frete-test
  (testing "Dado um valor abaixo de 100, o frete deve ser 15")
  (is (= 15 (taxa-entrega 50)))
  (is (= 15 (taxa-entrega 100)))
  (testing "Dado um valor acima de 100 e abaixo de 200, o frete deve ser 5")
    (is (= 5 (taxa-entrega 100.01)))
    (is (= 5 (taxa-entrega 200)))
  (testing "Dado um valor acima de 200, frete grátis")
    (is (= 0 (taxa-entrega 200.01)))
    (is (= 0 (taxa-entrega 3000))))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))
