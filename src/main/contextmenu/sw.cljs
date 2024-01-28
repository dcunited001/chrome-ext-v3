(ns contextmenu.sw
  (:require [shadow.cljs.modern :refer (js-await)]))

;; TODO: running a service worker is definitely required for shadow-cljs
;; 

;; TODO: unsafe eval is necessary for shadow-cljs to introspect?
;; "EvalError: Refused to evaluate a string as JavaScript because 'unsafe-eval'

;; (defn on-alarm []
;;   (js/chrome.action.setBadgeText #js {:text ""})
;;   (js/chrome.notifications.create
;;     (clj->js
;;       {:type "basic"
;;        :iconUrl "/stay_hydrated.png"
;;        :title "Time to hydrate"
;;        :message "Everyday I'm Guzzlin'!"
;;        :buttons [{:title "Keep it Flowing."}]
;;        :priority 0}))

;;   (js/console.log "on-alarm done"))

;; (defn init []
;;   (js/chrome.alarms.onAlarm.addListener on-alarm)
;;   (js/chrome.notifications.onButtonClicked.addListener
;;     (fn []
;;       (js-await [^js item (js/chrome.storage.sync.get #js ["minutes"])]
;;         (js/chrome.action.setBadgeText #js {:text "ON"})
;;         (js/chrome.alarms.create #js {:delayInMinutes (.-minutes item)})
;;         )))

;;   (js/console.log "sw init done"))

(defn generic-on-click [info] "fdsa")

(def contexts
  ["page" "selection" "link" "editable" "image" "video" "audio"])

(def contextmenus
  {:top {:id "parent"
         :title "Test parent item"
         :submenus [{:id "child1" :title "Child 1"}
                    {:id "child2" :title "Child 2"}]}
   :radio {:type "radio" :id "radio1" :title "Radio"}
   :checkbox {:type "checkbox" :id "checkbox1" :title "Checkbox"}})

(defn flatten-menu
  ([menu]
   (if (contains? :submenus menu)
     (cons menu (flatten-menu (:submenus menu) (:id menu)))
     menu))
  ([menu parent]
   (if (contains? :submenus menu)
     (cons (assoc menu :parentId parent)
           (flatten-menu (:submenus menu) (:id menu))))))

;; (defn create-menu [cfg]
;;   (js/console.log cfg))

(defn init []

  
  ;; (create-menu "fdsa")
  ;; (->>
  ;;  (flatten-menu)
  ;;  ;; (map create-menu)
  ;;  context-menus)
  )
