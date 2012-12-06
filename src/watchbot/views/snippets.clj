(ns watchbot.views.snippets
  (:require [watchbot.models.snippet :as snippet])
  (:use [noir.core]))

(defpage
  "/:id"
  {:keys [id]}

  (snippet/snippet-for id))
