(ns watchbot.integration.js-snippets-test
  (:use [watchbot.views.snippets]
        [midje.sweet]
        [noir.util.test])
  (:require [watchbot.couchdb :as db]))

(fact "The application returns JS snippets when accessed with URLs such as /a, /b, /c, ..."
      (:body (send-request "/a")) => (contains "/* Javascript Snippet */")
      (provided
        (db/request :get "/a") => {:code "/* Javascript Snippet */"}))
