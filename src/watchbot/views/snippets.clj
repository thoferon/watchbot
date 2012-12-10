(ns watchbot.views.snippets
  (:require [watchbot.models.snippet :as snippet]
            [watchbot.models.alert   :as alert]
            [noir.request])
  (:use [noir.core]))

(defpage
  "/:id"
  {:keys [id] :as x}

  (str
    "var alert_id = \""
    (:_id (alert/create :snippet-id   id
                        :ring-request (noir.request/ring-request)))
    "\";\n"
    (snippet/snippet-for id)))
