(ns watchbot.models.alert-test
  (:use [watchbot.models.alert]
        [midje.sweet])
  (:require [watchbot.couchdb :as db]))

(fact "create creates a new alert in the DB"
      (let [uuid "blah"]
        (create :key1 "a" :key2 "b") => {:_id "blah"}
        (provided
          (db/save-doc {:key1 "a" :key2 "b" :type "alert"}) => {:_id "blah"})))
