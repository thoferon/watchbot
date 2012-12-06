(ns watchbot.couchdb
  (:require [clj-http.client :as http]
            [clojure.walk :as cwalk]
            [watchbot.configuration :as conf]
            [clojure.data.json :as json]))

(defn request [method path]
  (let [url      (str conf/database-url path)
        response (http/request {:method method :url url :throw-exceptions false})]
    (-> response
      :body
      json/read-str
      cwalk/keywordize-keys)))

(defn find-doc [id]
  (let [response (request :get (str "/" id))]
    (when-not (= (:error response) "not_found") response)))
