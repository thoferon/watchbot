(ns watchbot.views.snippets-test
  (:use [watchbot.views.snippets]
        [midje.sweet]
        [noir.util.test])
  (:require [watchbot.models.snippet]))

(fact "GET /:id returns the snippet corresponding in the database"
      (:body (send-request "/a")) => (contains "/* Javascript Snippet */")
      (provided
        (watchbot.models.snippet/snippet-for "a") => "/* Javascript Snippet */"))
