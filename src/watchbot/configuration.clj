(ns watchbot.configuration)

(def database-url
    (or (str (System/getenv "CLOUDANT_URL") "/watchbot")  "http://localhost:5984/watchbot"))
