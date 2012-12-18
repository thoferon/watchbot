(ns watchbot.core
  (:use [watchbot.handler]
        [ring.adapter.jetty]))

(defn -main [& args]
  (run-jetty app {:port 80}))
