(ns studying.core
  (:require [clojure.string :as str]))

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
;; Exemplo: [5 6 6] ;;  1 estudante no quinto e 2 no sexto

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
;; Exemplo: (soma-idade [5 10 5) ;;  deve retornar 20

(defn soma-idade
  [idade-alunos]
  (reduce + idade-alunos))

(soma-idade [5 10 5])

;; Desafio 3: Crie uma função que recebe um vetor de nomes e retorna o tamanho médio
;; Exemplo: (tamanho-medio-nome ["Igor" "Maria"]) ;;  deve retornar 4,5

(defn tamanho-medio-nome
  [nomes]
  (/ (reduce + (map count nomes)) (count nomes)))

(tamanho-medio-nome ["Igor" "Maria"])

;; Desafio 4: Criar função que retorna tamanho médio dos nomes ignorando nomes com 3 ou menos chars

(defn maior-que-tamanho-minimo?
  [nome]
  (> (count nome) 3))

(defn tamanho-medio-nome-com-validacao
  [nomes]
  (let [nomes-validos (filter maior-que-tamanho-minimo? nomes)]
    (/ (reduce + (map count nomes-validos)) (count nomes-validos))))

(tamanho-medio-nome-com-validacao ["Igor" "Maria" "Jo"])

;;------------------------- || ------------------------------------
;; MAPAS

(defn compras
  []
  {:tomate {:quantidade 5 :preco 5}
   :arroz {:quantidade 1 :preco 15 }}
  )

(get (compras) :tomate)

;; Desafio: precisamos criar uma função que, dada um conjunto (vetor)
;; de disciplinas e o semestre do discente, deve:
;; filtrar a lista para exibir disciplinas restantes (que sejam do semestre atual ou superior)
;;  transformar nome da disciplina para maiúsculo e descartar demais informações
;; criar uma String concatenando o nome de todas as disciplinas filtradas
;;  Exemplo de entrada:
;; [nome "Estrutura de dados" semestre 2)
;; {:nome "Algoritmos" semestre 1)
;; (nome "Inteligência Artificiol" semestre 3}] 2
;; Saida esperada: "ESTRUTURA DE DADOS, INTELIGÊNCIA ARTIFICIAL

(defn disciplinas
  []
  [{:nome "Estrutura de dados" :semestre 2}
   {:nome "Algoritmos" :semestre 1}
   {:nome "Inteligência Artificial" :semestre 3}])

(defn nomes-disciplinas-restantes
  [disciplinas semestre-atual]
  (str/join ", " (map str/upper-case
                 (map :nome (
                              filter #(>= (:semestre %) semestre-atual) disciplinas)))))

(nomes-disciplinas-restantes (disciplinas) 2)