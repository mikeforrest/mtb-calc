(def trails [{:name "Amherst Trail" :city "Amherst" :diff "Advanced" :length 7} 
             {:name "Brooks Woodland Preserve" :city "Petersham" :diff "Unknown" :length 5}
             {:name "Chaug Path" :city "Wilbraham" :diff "Unknown" :length 1}
             {:name "Conant Brook Dam" :city "Palmer" :diff "Unknown" :length 6}
             {:name "Covered Bridge" :city "Barre" :diff "Unknown" :length 3}
             {:name "DAR" :city "Goshen" :diff "Advanced" :length 16}
             {:name "Dubuque State Forest" :city "Hawley" :diff "Advanced" :length 16}
             {:name "E-stranged Moose" :city "Charlemont" :diff "Intermediate" :length 2}
             {:name "Earl's Trails" :city "Amherst" :diff "Intermediate" :length 12}
             {:name "Facing Rocks" :city "Ludlow" :diff "Unknown" :length 7}
             {:name "Ice House" :city "Florence" :diff "Intermediate" :length 15}
             {:name "Knightville Dam" :city "Westfield" :diff "Unknown" :length 4}
             {:name "Lithia Springs Parking" :city "South Hadley" :diff "Unknown" :length 15}
             {:name "Memorial Loop" :city "Wilbraham" :diff "Intermediate" :length 6}
             {:name "Middle Distance Trail" :city "Deerfield" :diff "Unknown" :length 5}
             {:name "Mt. Toby" :city "Sunderland" :diff "Advanced" :length 16}
             {:name "Nonotuck Park" :city "Easthampton" :diff "Intermediate" :length 4}
             {:name "Norwottuck Rail Trail" :city "Northamton" :diff "Unknown" :length 19}
             {:name "Provin Mountain" :city "Feeding Hills" :diff "Unknown" :length 3}
             {:name "Robinson State Park" :city "Agawam" :diff "Intermediate" :length 25}
             {:name "Rocky Mountain and Highland Park" :city "Greenfield" :diff "Unknown" :length 30}
             {:name "Tully Lake" :city "Royalston" :diff "Unknown" :length 23}
             {:name "A. Skinner State Park" :city "Hadley" :diff "Unknown" :length 3}
             {:name "Ware River Rail Trail" :city "Barre" :diff "Unknown" :length 7}
             {:name "Water Company Owned Woods" :city "Enfield" :diff "Intermediate" :length 2}
             {:name "Wendell State Forest" :city "Wendell" :diff "Advanced" :length 17}
             {:name "White's Reservoir" :city "Westhampton" :diff "Unknown" :length 16}
             {:name "Wilbraham/Hampden Loop" :city "Springfield" :diff "Intermediate" :length 6}])



(println "Welcome to the Mountain Bike Map Finder")
(println "Please select a map difficulty:")
(println "1. Intermediate")
(println "2. Advanced")
(println "3. Unknown")

(def seldiff (read-string (read-line)))

(if (= seldiff 1)
  (def mapvec (filter #(= (:diff %) "Intermediate") trails))
  (if (= seldiff 2) 
     (def mapvec (filter #(= (:diff %) "Advanced") trails))
     (if (= seldiff 3)
         (def mapvec (filter #(= (:diff %) "Unknown") trails))
          nil)))

(println "How many miles do you want to ride for?")
(def sellen (read-string (read-line)))
(defn abs [n] (max n (- n)))
(def maxcounter (- (count mapvec) 1))

;(def counter 0)
(loop [counter 0
       diff 100
       lowvals ""]
  (if (> counter maxcounter)
    (println lowvals)
    (if (< (abs  (- (:length (nth mapvec counter)) sellen)) diff)
      (recur (inc counter)
             (abs (- (:length (nth mapvec counter)) sellen))
             (str (:name (nth mapvec counter)) " - " (:city (nth mapvec counter)) " - " (:length (nth mapvec counter)) " miles"))
      (recur (inc counter)
             diff
             lowvals)))) 
