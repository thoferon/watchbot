(ns watchbot.integration.js-snippets-test
  (:use [watchbot.views.snippets]
        [midje.sweet]
        [noir.util.test]
        [watchbot.integration.common])
  (:require [watchbot.couchdb :as db]))

(wrap-integration-tests
  (fact "The application returns JS snippets when accessed with URLs such as /a, /b, /c, ..."
        (:body (send-request "/a")) => (contains "/* Javascript Snippet */")
        (against-background (before :facts (db/request :put "/a" {:_id "e" :code "/* Javascript Snippet */"}))))

  (future-fact "Showing a JS snippet creates a new record in the database"))
