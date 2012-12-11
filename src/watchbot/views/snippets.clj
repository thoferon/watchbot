(ns watchbot.views.snippets
  (:require [watchbot.models.snippet :as snippet]
            [watchbot.models.alert   :as alert]
            [noir.request])
  (:use [noir.core]))

(defpage
  "/:id"
  {:keys [id]}

  (str
    "var alert_id = \""
    (:_id (alert/create :snippet-id   id
                        :ring-request (dissoc (noir.request/ring-request) :body)))
    "\";\n"
    (snippet/snippet-for id)))
