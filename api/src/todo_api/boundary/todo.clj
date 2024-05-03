(ns todo-api.boundary.todo
  (:require [clojure.spec.alpha :as s]))

(defprotocol TodoRepository
  (create-todo [this todo]))

(s/fdef create-todo
  :args (s/cat :this ::todo-repository
               :todo ::todo)
  :ret any?)