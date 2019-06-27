(defproject cloj-md "1.0"
  :description "Markdown in clojure"
  :url "http://example.com/FIXME"
  :license {:name "MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot cloj-md.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
