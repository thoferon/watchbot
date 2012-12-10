(ns watchbot.models.alert-test
  (:use [watchbot.models.alert]
        [midje.sweet])
  (:require [watchbot.couchdb :as db]))

(fact "create creates a new alert in the DB"
      (let [uuid "blah"]
        (create "a") => {}
        (provided
          (db/save-doc {:snippet-id "a" :type "alert"}) => {})))
