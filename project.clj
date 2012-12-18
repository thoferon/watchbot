(defproject watchbot "0.1.0-SNAPSHOT"
  :description "Tool to monitor security errors in web applications"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.3"]
                 [midje "1.5-alpha2"]
                 [ring "1.1.6"]
                 [clj-http "0.6.0"]
                 [org.clojure/data.json "0.2.0"]]
  :plugins [[lein-ring "0.7.5"]]
  :ring {:handler watchbot.handler/app}
  :profiles {:dev {:plugins [[lein-midje "2.0.3"]]
                   :dependencies [[ring-mock "0.1.3"]]}}
  :main watchbot.core)
