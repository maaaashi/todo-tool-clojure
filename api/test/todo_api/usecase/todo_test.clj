(ns todo-api.usecase.todo-test
  (:require [clojure.test :as t]
            [todo-api.boundary.todo :as b]
            [todo-api.usecase.todo :as sut]
            [shrubbery.core :as shr]))

(t/deftest register-test
  (t/testing "TODOを登録することができる"
    (let [todo {:id "id" :title "test" :content "content"}
          todo-repository (shr/mock b/TodoRepository {:create-todo todo})]
      (t/is (= (sut/register {:todo-repository todo-repository} todo) {:status "ok"}))))
  (t/testing "TODOの型が合わない場合、TODOを登録することができない"
    (let [todo {:id "id"}
          todo-repository (shr/mock b/TodoRepository {:create-todo todo})]
      (t/is (= (sut/register {:todo-repository todo-repository} todo) {:status "ng"})))))
