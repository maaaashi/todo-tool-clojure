(ns todo-tool.core
  (:require [todo-tool.import :as import]))

(defn -main
  [& _]
  (import/execute))
