(ns watchbot.configuration)

(def database-url
    (or (System/getenv "CLOUDANT_URL") "http://localhost:5984/watchbot"))
