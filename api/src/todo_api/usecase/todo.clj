(ns todo-api.usecase.todo 
  (:require [todo-api.boundary.todo :as b]
            [clojure.spec.alpha :as s]))

(s/def ::id string?)
(s/def ::title string?)
(s/def ::content string?)
(s/def ::todo (s/keys :req-un [::id ::title ::content]))

(defn- register-todo [todo-repository todo]
  (println "todo-repository is TodoRepository")
  (b/create-todo todo-repository todo)
  {:status "ok"})

(defn register [{:keys [todo-repository] :as _} todo]
  (when (satisfies? b/TodoRepository todo-repository)
    (println todo)
    (if (s/valid? ::todo todo)
      (register-todo todo-repository todo)
      {:status "ng"})))
