(ns todo-api.usecase.todo-test
  (:require [clojure.test :as t]
            [todo-api.boundary.todo :as b]
            [mockfn.macros :as mockfn]))

(t/deftest register-test
  (t/testing "TODOを登録することができる" 
    (mockfn/verifying [])))
