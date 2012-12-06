(ns watchbot.server
  (:require [noir.server :as server]))

(server/load-views "src/watchbot/views/")

(defn start-server [port]
  (server/start port {:mode :dev
                      :ns 'watchbot}))
