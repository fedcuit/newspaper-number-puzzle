(ns newspaper-number-puzzle.core
  (:gen-class)
  (:refer-clojure :exclude [==])
  (:require [clojure.core.logic :refer :all])
  (:require [clojure.core.logic.fd :as fd]))

(defn resolve-puzzle
  []
  (run* [q]

        ;; Create some new logic vars (lvars) for us to use in our rules
        (fresh [a0 a1 a2                                    ;; Top row
                b0 b1 b2                                    ;; Middle row
                c0 c1 c2]                                   ;; Bottom row

               ;; Unify q with our lvars in the output format we want
               (== q [[a0 a1 a2]
                      [b0 b1 b2]
                      [c0 c1 c2]])

               ;; State that every one of our lvars should be in the range 1-9
               (fd/in a0 a1 a2 b0 b1 b2 c0 c1 c2 (fd/interval 1 9))

               ;; State that each of our lvars should be unique
               (fd/distinct [a0 a1 a2 b0 b1 b2 c0 c1 c2])

               ;; fd/eq is just a helper to allow us to use standard Clojure
               ;; operators like + instead of fd/+
               (fd/eq

                 ;; Horizontal conditions for the puzzle
                 (= (- (* a0 a1) a2) 22)
                 (= (+ (* b0 b1) b2) 15)
                 (= (* (+ c0 c1) c2) 72)

                 ;; Vertical conditions for the puzzle
                 (= (* (+ a0 b0) c0) 25)
                 (= (- (+ a1 b1) c1) 10)
                 (= (+ (* a2 b2) c2) 25)

                 ;; And finally, in the puzzle we are told that the top left
                 ;; number (a0) is 4.
                 (= a0 4))
               ))
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  )