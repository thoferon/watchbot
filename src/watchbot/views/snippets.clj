(ns watchbot.views.snippets
  (:require [watchbot.models.snippet :as snippet]
            [watchbot.models.alert   :as alert])
  (:use [noir.core]))

(defpage
  "/:id"
  {:keys [id]}

  (str
    "var alert_id = \""
    (:_id (alert/create id))
    "\";\n"
    (snippet/snippet-for id)))
