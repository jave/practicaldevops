(ns usermanager.routes.home
  (:require [usermanager.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/useradd" []   (layout/render "useradd.html"))
  (GET "/searchuser" []   (layout/render "searchuser.html"))
  (GET "/about" [] (about-page)))

