(ns watchbot.models.alert
  (:require [watchbot.couchdb :as db]))

(defn create [& {:as data}]
  (db/save-doc (assoc data :type "alert")))
