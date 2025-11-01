(ns studying.core)

(defn taxa-entrega
  [valor-pedido]
  (let [frete-minimo 15
        frete-medio 5
        frete-gratis 0]
    (if (<= valor-pedido 100)
      frete-minimo
      (if (<= valor-pedido 200)
        frete-medio
        frete-gratis))))