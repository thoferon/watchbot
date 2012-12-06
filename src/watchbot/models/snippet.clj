(ns watchbot.models.snippet
  (:require [watchbot.couchdb :as db]))

(defn snippet-for [id]
  (:code (db/find-doc id)))
