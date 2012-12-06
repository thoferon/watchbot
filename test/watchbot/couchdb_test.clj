(ns watchbot.couchdb-test
  (:use [watchbot.couchdb]
        [midje.sweet])
  (:require [clj-http.client :as http]
            [watchbot.configuration :as conf]))

(fact "request returns CouchDB response as a keywordized map"
      (with-redefs
        [conf/database-url "http://localhost:5984/foo"]
        (request :get "/stuff") => {:total_rows 0 :rows []})

      (provided
        (http/request {:method :get
                       :url "http://localhost:5984/foo/stuff"
                       :content-type "application/json"
                       :body "{}"
                       :throw-exceptions false})
        => {:body "{\"total_rows\": 0, \"rows\": []}"}))

(fact "request sends the body as JSON"
      (with-redefs
        [conf/database-url "http://localhost:5984/foo"]
        (request :put "/stuff" {:key 23}) => "Called!")

      (provided
        (http/request {:method :put
                       :url "http://localhost:5984/foo/stuff"
                       :content-type "application/json"
                       :body "{\"key\":23}"
                       :throw-exceptions false})
        => {:body "\"Called!\""}))

(fact "find-doc returns the document with the corresponding id"
      (find-doc "some-uuid") => {:blah "stuff"}
      (provided
        (request :get "/some-uuid") => {:blah "stuff"}))

(fact "find-doc returns nil if document not found"
      (find-doc "some-uuid") => nil
      (provided
        (request :get "/some-uuid") => {:error "not_found" :reason "missing"}))
