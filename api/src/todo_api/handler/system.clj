(ns todo-api.handler.system
  (:require [integrant.core :as ig]))

(defn- ping
  [_]
  (println "ping")
  {:status 200
   :body "pong"})

(defmethod ig/init-key :todo-api.handler.system/ping
 [_ _]
  ping)