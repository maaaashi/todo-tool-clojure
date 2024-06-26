(defproject todo-tool "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.2"]
                 [cheshire "5.13.0"]
                 [clj-http "3.13.0"]
                 [concurrently "0.3.0"]
                 [com.taoensso/timbre "6.5.0"]]
  :main ^:skip-aot todo-tool.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}}
  :repl-options {:init-ns todo-tool.core})
