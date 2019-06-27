(ns cloj-md.core-test
  (:require [clojure.test :refer :all]
            [cloj-md.core :refer :all]))

(deftest headlines
  (testing "headlines"
    (is (= (h 3 "a") "### a"))))

(deftest headlines-with-text
  (testing "headlines with text"
    (is (= (h "pre " 3 "a") "pre ### a"))))

(deftest bold
  (testing "boldness"
    (is (= (b "a") "**a**"))))

(deftest italics
  (testing "italics"
    (is (= (i "a") "*a*"))))

(deftest para
  (testing "para"
    (is (= (p "a") "a"))))

(deftest bullet
  (testing "bullet points"
    (is (= (bu "a") "- a"))))

(deftest code-snippet
  (testing "code snippet"
    (is (= (<<>> 'java "a") "```java\na\n```"))))

(deftest line-break
  (testing "line break"
    (is (= (br "a") "a\n"))))

(deftest points
  (testing "bulleted points"
    (is (= ($ 1 "a") "1. a"))))

(deftest image
  (testing "image"
    (is (= (img "a" "http://img.com") "![a](http://img.com)"))))

(deftest inline-snippet
  (testing "inline code"
    (is (= (<> "a") "`a`"))))

(deftest block
  (testing "block quote"
    (is (= (>> "a") "> a"))))

(deftest video
  (testing "video"
    (is (= (vid "a" "http://img.com" "http://vid.com") "[![a](http://img.com)](http://vid.com)"))))