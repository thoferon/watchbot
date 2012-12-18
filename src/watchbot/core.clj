(ns watchbot.core
  (:use [watchbot.handler]
        [ring.adapter.jetty]))

(defn -main [port]
  (run-jetty app {:port (Integer. port)}))
