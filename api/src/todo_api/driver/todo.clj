(ns todo-api.driver.todo
  (:require [todo-api.boundary.todo :as b]
            [integrant.core :as ig]
            [clojure.spec.alpha :as s]
            [next.jdbc :as jdbc]
            [next.jdbc.result-set :as rs]))

(declare get-todo-sqlvec create-todo-sqlvec)

(defn execute-query [datasource params]
  (with-open [conn (jdbc/get-connection datasource)]
    (jdbc/execute! conn (get-todo-sqlvec params) {:builder-fn rs/as-unqualified-kebab-maps})))

(defn- create-todo* [datasource todo]
  (let [query {:id (:id todo)
               :title (:title todo)
               :content (:content todo)}]
    (execute-query datasource query)))

(defn- register-todo [db todo]
  (create-todo* (get-in db [:spec :datasource]) todo))

(defmethod ig/init-key ::todo-repository
  [_ {:keys [db]}]
  (reify b/TodoRepository
    (create-todo [self todo]
      (when (s/valid? (:args (s/get-spec `b/create-todo))
                      [self todo])
        (register-todo db todo)))))
