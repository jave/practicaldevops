(ns usermanager.routes.home
  (:require [usermanager.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page []
  (layout/render "about.html"))

(def user-list (atom []))

(defn user-list-add [name surname]
  (swap! user-list conj  {:name name :surname surname} ))

(defn user-list-delete [name surname]
  (reset! user-list (remove (fn [ x] (= x {:surname surname :name name })) @user-list)))

(defn useradded [name surname]
  (layout/render "useradded.html" {:name name :surname surname})
  (user-list-add name surname)
  )

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/useradd" []   (layout/render "useradd.html"))
  (GET "/userdelete" []   (layout/render "userdelete.html"))  
  (POST "/useradded" [name surname]   (do   (user-list-add name surname)  (layout/render "useradded.html" {:name name :surname surname})))  
  (POST "/userdeleted" [name surname]   (do   (user-list-delete name surname)  (layout/render "userdeleted.html" {:name name :surname surname})))  
  (GET "/searchuser" []   (layout/render "searchuser.html"))
  (POST "/searchresult" []   (layout/render "searchresult.html" {:users @user-list}))
  (GET "/about" [] (about-page)))

