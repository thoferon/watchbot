(ns watchbot.core
  (:require [watchbot.server]))

(defn -main [& args]
  (println "Starting web server on port 8090...")
  (watchbot.server/start-server 8090))
