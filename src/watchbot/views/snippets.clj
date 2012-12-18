(ns watchbot.views.snippets
  (:require [watchbot.models.snippet :as snippet]
            [watchbot.models.alert   :as alert]))

(defn show [{{:keys [id]} :params :as request}]
  (str
    "var alert_id = \""
    (:_id (alert/create :snippet-id   id
                        :ring-request (dissoc request :body)))
    "\";\n"
    (snippet/snippet-for id)))
