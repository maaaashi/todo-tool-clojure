(ns todo-api.handler.todo
  (:require [integrant.core :as ig]))

(defn- handler [req]
  (println req)
  {:status 200
   :body { :message "Hello, World!" }})

(defmethod ig/init-key :todo-api.handler.todo/post
  [_ deps]
  (handler deps))

