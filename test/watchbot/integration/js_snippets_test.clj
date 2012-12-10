(ns watchbot.integration.js-snippets-test
  (:use [watchbot.views.snippets]
        [midje.sweet]
        [noir.util.test]
        [watchbot.integration.common])
  (:require [watchbot.couchdb :as db]))

(wrap-integration-tests
  (against-background [(before :facts (db/request :put "/a" {:_id "e" :code "/* Javascript Snippet */"}))]

    (fact "The application returns JS snippets when accessed with URLs such as /a, /b, /c, ..."
          (:body (send-request "/a")) => (contains "/* Javascript Snippet */"))

    (fact "Showing a JS snippet creates a new record in the database and add the ID in the snippet"
          (let [uuid "js-snippet-generates-record-test"]

            (:body (send-request "/a")) => (contains (str "var alert_id = \"" uuid "\";"))
            (provided
              (db/generate-uuid) => uuid)

            (db/find-doc uuid) => (contains {:type "alert"})
            ))))
