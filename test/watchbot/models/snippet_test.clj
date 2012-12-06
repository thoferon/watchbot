(ns watchbot.models.snippet-test
  (:use [watchbot.models.snippet]
        [midje.sweet])
  (:require [watchbot.couchdb :as db]))

(fact "snippet-for returns a JS snippet"
      (snippet-for "a") => (contains "Blah")
      (provided
        (db/find-doc "a") => {:code "Blah"}))
