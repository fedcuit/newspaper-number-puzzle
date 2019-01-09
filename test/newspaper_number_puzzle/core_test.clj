(ns newspaper-number-puzzle.core-test
  (:require [clojure.test :refer :all]
            [newspaper-number-puzzle.core :refer :all]))

(deftest a-test
  (testing "resolve puzzle"
    (is (= (resolve-puzzle) '([
                               [4 6 2]
                               [1 7 8]
                               [5 3 9]
                               ])))))
