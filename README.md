# Bio text mining web services

**Discontinued: this was an experimental project (using Spring Boot, OpenNLP, Gradle).
We then moved forward with [Reach](https://github.com/PathwayCommons/reach-docker) and [Saber](https://github.com/BaderLab/Saber).**

A stateless open-source textmining (NER) web service 
(to be optionally called, e.g., by Pathway Commons Factoid).

Currently, this experimental RESTful web services are built with Java, Gradle and Spring-boot around Apache OpenNLP (using en-sent.bin sentence model) and Abner (NLPBA tagger model) libraries.

Clone, then build & run:

./gradlew build && java -Dserver.port=8080 -jar build/libs/bionlpner.jar
