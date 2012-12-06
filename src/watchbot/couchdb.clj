(ns watchbot.couchdb
  (:require [clj-http.client :as http]
            [clojure.walk :as cwalk]
            [watchbot.configuration :as conf]
            [clojure.data.json :as json]))

(defn request
  ([method path] (request method path {}))
  ([method path body]
   (let [url      (str conf/database-url path)
         response (http/request {:method method
                                 :url url
                                 :content-type "application/json"
                                 :body (json/write-str body)
                                 :throw-exceptions false})]
     (-> response
       :body
       json/read-str
       cwalk/keywordize-keys))))

(defn find-doc [id]
  (let [response (request :get (str "/" id))]
    (when-not (= (:error response) "not_found") response)))
