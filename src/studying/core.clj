(ns studying.core)

(defn taxa-entrega
  [valor-pedido]
  (if (<= valor-pedido 100)
    15
    (if (<= valor-pedido 200)
      5
      0)))