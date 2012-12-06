(defproject watchbot "0.1.0-SNAPSHOT"
  :description "Tool to monitor security errors in web applications"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [noir "1.3.0-alpha10"]
                 [midje "1.5-alpha2"]
                 [clj-http "0.6.0"]
                 [org.clojure/data.json "0.2.0"]]
  :profiles {:dev {:plugins [[lein-midje "2.0.3"]]}}
  :main watchbot.core)
