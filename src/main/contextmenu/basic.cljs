(ns contextmenu.basic)

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

(defn create-menu [cfg]
  (js/console.log cfg))

(defn init []
  (js/chrome.contextMenus.create {:title "test parent item" :id "parent"})
  (map #(js/chrome.contextMenus.create
         {:title (concat "Test" %1 "menu item")
          :contexts [%1]
          :id %1}) contexts))

;; (create-menu "fdsa")
;; (->>
;;  (flatten-menu)
;;  ;; (map create-menu)
;;  context-menus)

