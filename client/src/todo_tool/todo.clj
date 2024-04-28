(ns todo-tool.todo)

(defn json->todo [{:keys [title content]}]
  {:id (java.util.UUID/randomUUID)
   :title title
   :content content})