(ns todo-api.usecase.todo-test
  (:require [clojure.test :as t]
            [todo-api.boundary.todo :as b]
            [todo-api.usecase.todo :as sut]
            [mockfn.macros :as mockfn]
            [mockfn.matchers :as matchers]))

(t/deftest register-test
  (t/testing "TODOを登録することができる" 
    (let [todo {:id "id" :title "test"}]
     (mockfn/verifying
      [(b/TodoRepository matchers/any-args? todo) :ok (matchers/exactly 1)]
      (sut/register todo)))))
