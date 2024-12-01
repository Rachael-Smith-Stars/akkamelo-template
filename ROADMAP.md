# Akkamelo Implementation Roadmap
If you cloned this repository, you are probably looking to implement Akkamelo. 
This guide will help you understand the steps to implement Akkamelo, and the resources you can use to learn the necessary concepts.

### Run akkamelo for the first time

Get akkamelo to compile and run for the first time. Add the necessary plugins and dependencies.

### 2 Implement Akkamelo’s domain

Implement the Domain of Akkamelo as pure, immutable models.

Resources:
Scala:

https://ppb.udemy.com/course/rock-the-jvm-scala-for-beginners

hyper condensed scala course to grasp all concepts quickly: https://www.youtube.com/watch?v=-8V6bMjThNo&list=PLmtsMNDRU0BxryRX4wiwrTZ661xcp6VPM  (try this + the exercises in the first link)

**Design:**
https://martinfowler.com/bliki/DomainDrivenDesign.html
https://martinfowler.com/bliki/UbiquitousLanguage.html
https://martinfowler.com/eaaCatalog/domainModel.html
https://martinfowler.com/bliki/DDD_Aggregate.html
https://tidyfirst.substack.com/p/canon-tdd
https://dannorth.net/introducing-bdd/
https://langrsoft.com/2006/06/06/are-tests-specs/
https://www.scalatest.org/user_guide/selecting_a_style

### 3 Good Practices
Use good logging and configuration practices in akkamelo.
Resources:
- https://www.baeldung.com/scala/lightbend-config
- https://github.com/Flutter-Global/pcsa-service  (explore!)

### 4 Akka Classic Actor

Use Akka Actor to implement the flow of Akkamelo.

Resources:
- https://ppb.udemy.com/course/akka-essentials  (Probably the most important course after Scala!)
Watch Section 3 and 4 in it's entirety. Understand Actors, keep the PCSA open by your side!

- I recommend reading this guide, even though it uses Akka Typed, good to understand the event sourced Architecture: https://doc.akka.io/libraries/guide/index.html

### 5 Wire the application

Wire the whole application in memory. Achieve the desired program flow without a database.
receive http request -> "ask" actor to process -> respond to requester.

Resources:
https://www.youtube.com/watch?v=PMrcGo6rl5Q  ← good for some context of responsibility

https://ppb.udemy.com/course/akka-remoting-clustering/learn/lecture/14472760#overview ← Not needed for akkamelo, but important for PCSA. You can leave for later. Remember: don’t drown in theory.
https://ppb.udemy.com/course/akka-essentials/learn/lecture/12418650#overview ← if you haven't already!

### 6 Finishing up (take 1)

Containerize akkamelo to run anywhere, anytime using Docker, run the provided test suite, and fix problems that arise!

Resources:

https://ppb.udemy.com/course/docker-kubernetes-the-practical-guide/learn/lecture/22628185#overview (good to know but not entirely needed, keep moving forward)

### 7 Akka Persistence

Add Akka persistence with cassandra to Akkamelo and an Event Sourced Architecture!

Resources:

Small introduction: https://www.youtube.com/watch?v=yFjzGRb8NOk

https://ppb.udemy.com/course/akka-persistence

You can come back to this guide for more context:
https://doc.akka.io/libraries/guide/index.html

### 8 Finishing up (take 2)

Run akkamelo in docker, connected to a cassandra Instance. Persist events and create snapshots. The end.

