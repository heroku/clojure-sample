(ns sample.app
  (:require [ring.adapter.jetty :as jetty]
            [compojure.core :refer [defroutes GET]]))

(defroutes handler
  (GET "/" []
       {:headers {"Content-type" "text/plain; charset=UTF-8"}
        :body "Hello world!\nVisit 'Getting Started with Clojure on Heroku' at the Heroku Dev Center to learn more: https://devcenter.heroku.com/articles/clojure  "}))

(defn -main []
  (jetty/run-jetty handler
                   {:port (Integer. (or (System/getenv "PORT") "8080"))
                    :join? false}))
