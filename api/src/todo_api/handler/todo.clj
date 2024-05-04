(ns todo-api.handler.todo
  (:require [integrant.core :as ig]
            [todo-api.usecase.todo :as usecase]))

(defn handler
  [{:keys [body-params]}]
  (usecase/register {} body-params)
  {:status 200
   :body "hello world"})

(defmethod ig/init-key :todo-api.handler.todo/post
  [_ _]
  handler)

