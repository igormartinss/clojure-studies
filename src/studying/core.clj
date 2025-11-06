(ns studying.core)

;; Estudando let e condicional

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

;;------------------------- || ------------------------------------


;; Estudando Higher Order Function

;; 1. Recebendo função como parâmetro
(defn consulta-taxa-atual
  []
  0.2)

(defn imposto-retido
  [consulta-taxa-padrao salario]
  (if (< salario 1000)
    0
    (* salario (consulta-taxa-padrao))))

(imposto-retido consulta-taxa-atual 1000)

;; 2. Retornando função como parâmetro

(defn minha-taxa-padrao
  []
  consulta-taxa-atual) ;; Retorna referência para a função

(minha-taxa-padrao) ;; Se adicionar outro parênteses vai executar essa referência ((minha-taxa-padrao))

(imposto-retido (minha-taxa-padrao) 2000)
;; chama o imposto retido, usando a referência retornada pelo minha-taxa-padrao ele executa essa referência
;;  e passa 2000 como parâmetro também

;;------------------------- || ------------------------------------

;; Vetor de estudantes contendo número representando o número da série
;; Exemplo: [5 6 6] ; 1 estudante no quinto e 2 no sexto

;; Desafio 1: criar uma função que recebe o vetor como entrada e retorna a quantidade de estudantes que estão no quinto ano

(defn esta-no-quinto-ano?
  [ano]
  (= ano 5))

(defn quantidade-estudantes-no-quinto-ano
  [estudantes]
  (count (filter esta-no-quinto-ano? estudantes)))
;; alternativa: (count (filter #(= 5 %) estudantes))

(quantidade-estudantes-no-quinto-ano [5 1 3 4 5])

;; Desafio 2: Crie uma função que recebe um vetor de idades e retorna a soma
;; Exemplo: (soma-idade [5 10 5) ; deve retornar 20

(defn soma-idade
  [idade-alunos]
  (reduce + idade-alunos))

(soma-idade [5 10 5])
