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
      (let [todos (->> (json/parse-stream r true)
                  (map todo/json->todo)) 
            input (a/chan 2)
            shared-process (c/concurrent-process-blocking 1
                                                          (a/chan 1)
                                                          (d/map (fn [{todo :data}]
                                                                   (post-todo todo)))
                                                          (a/chan 2)
                                                          {:ordered? false})
            
            {:keys [channel]} (c/concurrently shared-process
                                              input
                                              {:option-to-function true})
            p (a/go-loop [todos todos]
                (if-let [todo (first todos)] 
                  (do (a/>! input todo)
                      (recur (rest todos)))
                  (a/close! input)))
            results (c/get-results!! channel {:catch #(log/error %)
                                              :timeout-ms 8000})]
        (a/<!! p)
        results))))

(comment
  (execute)
  )