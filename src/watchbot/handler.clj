(ns watchbot.handler
  (:require [compojure.handler :as handler]
            [watchbot.routes :as routes]))

(def app
  (handler/site routes/app-routes))
