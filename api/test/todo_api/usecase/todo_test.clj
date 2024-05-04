(ns todo-api.usecase.todo-test
  (:require [clojure.test :as t]
            [todo-api.boundary.todo :as b]
            [todo-api.usecase.todo :as sut]
            [shrubbery.core :as shr]))

(t/deftest register-test
  (t/testing "TODOを登録することができる" 
    (let [todo {:id "id" :title "test"}
          todo-repository (shr/mock b/TodoRepository {:create-todo todo})]
      (t/is (= (sut/register {:todo-repository todo-repository} todo) todo)))))
