(ns watchbot.routes
  (:use [compojure.core])
  (:require [compojure.route :as route]
            [watchbot.views.snippets :as snippets]))

(defroutes app-routes
           (GET "/:id" {:as request} (snippets/show request))
           (route/not-found "Not Found"))
