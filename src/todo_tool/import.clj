(ns todo-tool.import
  (:require [taoensso.timbre :as log]
            [clj-http.client :as http]))

(defn- post-todo []
  (http/post "http://localhost:3000/todos"))

(defn execute []
  (let [file-name "data.json"]
    (log/info "Importing:" file-name)))

(comment
  (post-todo)
  )