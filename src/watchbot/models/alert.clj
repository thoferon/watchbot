(ns watchbot.models.alert
  (:require [watchbot.couchdb :as db]))

(defn create [snippet-id]
  (db/save-doc {:snippet-id snippet-id :type "alert"}))
