(ns todo-api.usecase.todo 
  (:require [todo-api.boundary.todo :as b]))

(defn register [{:keys [todo-repository] :as _} todo]
  (when (satisfies? b/TodoRepository todo-repository)
    (b/create-todo todo-repository todo)))
