(ns watchbot.views.snippets-test
  (:use [watchbot.views.snippets]
        [midje.sweet]
        [noir.util.test])
  (:require [watchbot.models.snippet]
            [watchbot.models.alert]))

(fact "GET /:id returns the snippet corresponding in the database"
      (:body (send-request "/a")) => (contains "/* Javascript Snippet */")
      (:body (send-request "/a")) => (contains "uuid")

      (against-background
        (watchbot.models.snippet/snippet-for "a") => "/* Javascript Snippet */"
        (watchbot.models.alert/create "a")        => {:_id "uuid"}))
