(ns cloj-md.core
  "Markdown generator library"
  (:gen-class))

(defn h
  "headlines the `headline` with weight `weight` and optionally appends to the `text`"
  ([weight headline]
   (if (> weight 5)
     (throw
      (ex-info "Headline weight can't be more than 5" {:type :invalid-syntax}))
     (str (apply str (repeat weight \#)) " " headline)))
  ([text weight headline]
   (str text (h weight headline))))

(defn p
  "a paragraph `pre` and optionally appends to the `text`"
  ([pre] pre)
  ([text pre]
   (str text (p pre))))

(defn b
  "bolds `pre` and optionally appends to the `text`"
  ([pre]
   (str "**" pre "**"))
  ([text pre]
   (str text (b pre))))

(defn i
  "italicize `pre` and optionally appends to the `text`"
  ([pre]
   (str "*" pre "*"))
  ([text pre]
   (str text (i pre))))

(defn bu
  "bulletize `pre` and optionally appends to the `text`"
  ([pre]
   (str "- " pre))
  ([text pre]
   (str text (bu pre))))

(defn <<>>
  "code snippet with `lang` if present and optionally appends to the `text`"
  ([code_snippet] (str "```" "\n" code_snippet "\n" "```"))
  ([lang code_snippet]
   (str "```" lang "\n" code_snippet "\n" "```"))
  ([text lang code_snippet]
   (str text (<<>> lang code_snippet))))

(defn br
  "new line `n` times if present after `text`"
  ([] "\n")
  ([text] (str text (br)))
  ([text n] (str text (apply str (repeat n (br))))))

(defn $
  "numbered points with number `i` and then optionally appends to `text`"
  ([i pre]
   (str i ". " pre))
  ([text i pre]
   (str text ($ i pre))))

(defn a
  "links the hyperlink `link` with text `val` and then optionally appends to `text`"
  ([val link]
   (str "[" val "](" link ")"))
  ([text val link]
   (str text (a val link))))

(defn img
  "image with alt text `alt` and href `link` and then optionally appends to `text`"
  ([alt link] (str "!" (a alt link)))
  ([text alt link] (str text (img alt link))))

(defn <>
  "inline code emphasize and then optionally appends to `text`"
  ([code] (str "`" code "`"))
  ([text code] (str text (<> code))))

(defn >>
  "block quote and then optionally appends to `text`"
  ([block] (str ">" " " block))
  ([text block] (str text (>> block))))

(defn vid
  "a syntatic suger for videos with image thumbnail.
  links the image with href `img_link` and alt-text `alt` with the video href `link` and then optionally appends to `text`"
  ([alt img_link link] (str "[" (img alt img_link) "](" link ")"))
  ([text alt img_link link] (str text (vid alt img_link link))))

(defn write-into [text file]
  "write the markdown `text` into `file`"
  (spit file text))
