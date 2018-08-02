(ns rpg-action.models.commands
  (:require [clojure.spec.alpha :as s]))

(def help-options #{:help})
(defn help-option?
  [option]
  (contains? help-options (keyword option)))

(defmulti command first)
(defmethod command :help [_]
  (s/cat :type #{:help} :help-option (s/? help-option?)))

(s/def ::command (s/multi-spec command (fn [genv _tag] genv)))