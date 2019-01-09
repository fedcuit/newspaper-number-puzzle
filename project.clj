(defproject newspaper-number-puzzle "0.1.0-SNAPSHOT"
  :description "newspaper-number-puzzle"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/core.logic "0.8.11"]]
  :main ^:skip-aot newspaper-number-puzzle.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
