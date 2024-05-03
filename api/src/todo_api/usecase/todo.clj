(ns todo-api.usecase.todo 
  (:require [todo-api.boundary.todo :as b]))

(defn register [{:keys [todo-repository] :as _} todo]
  (println "★★★★★★★★★★★★★★★")
  (when (satisfies? b/TodoRepository todo-repository)
    (println "todo-repository is TodoRepository")
    (b/create-todo todo-repository todo)))
