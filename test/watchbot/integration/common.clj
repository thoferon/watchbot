(ns watchbot.integration.common
  (:use [midje.sweet])
  (:require [watchbot.couchdb :as db]))

(defn clean-db []
  (doseq [{:keys [id value]} (:rows (db/request :get "/_all_docs"))
          :when (not= id "_design/api")]
    (db/request :delete (str "/" id "?rev=" (:rev value)))))

(defmacro wrap-integration-tests
  [& body]
  (conj body
        `[(before :facts (clean-db))]
        `against-background))
