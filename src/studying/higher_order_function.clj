(ns studying.higher-order-function)

(defn consulta-taxa-atual
  []
  0.2)

(defn imposto-retido
  [consulta-taxa-padrao salario]
  (if (< salario 1000)
    0
    (* salario (consulta-taxa-padrao))))

(imposto-retido consulta-taxa-atual 1000)
