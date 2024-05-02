(ns todo-api.boundary.todo)

(defprotocol TodoRepository
  (create-todo [this todo]))