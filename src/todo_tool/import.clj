(ns todo-tool.import
  (:require [cheshire.core :as json]
           [clj-http.client :as http]
           [clojure.core.async :as a]
           [clojure.java.io :as io]
           [concurrently.core :as c]
           [databox.core :as d]
           [todo-tool.todo :as todo]
           [taoensso.timbre :as log]))
(defn- post-todo [todo]
  (http/post "http://localhost:3000/todos"
             {:form-params todo
              :content-type :json
              :as :json}))

(defn execute []
  (let [file-name "data2.json"]
    (with-open [r (io/reader (io/resource file-name))]
      (->> (json/parse-stream r true)
           (map todo/json->todo)
           (post-todo)
           (:body)
           (:status)))))

(comment
  (execute)
  )