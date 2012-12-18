(ns watchbot.views.snippets-test
  (:use [watchbot.views.snippets]
        [midje.sweet])
  (:require [watchbot.models.snippet]
            [watchbot.models.alert]))

;; TODO: Refactor this shit

(background
  (watchbot.models.alert/create :snippet-id   "a"
                                :ring-request {:params {:id "a"}})
  => {:_id "uuid"}
  (watchbot.models.snippet/snippet-for "a") => "/* Javascript Snippet */")

(fact "GET /:id returns the snippet corresponding in the database"
      (let [req         {:params {:id "a"} :body ""}]

        (against-background
          [(watchbot.models.snippet/snippet-for "a") => "/* Javascript Snippet */"]

          (show req) => (contains "/* Javascript Snippet */")
          (show req) => (contains "uuid")
        )))


