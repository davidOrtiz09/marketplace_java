logLevel := Level.Warn

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.12")

addSbtPlugin("com.typesafe.sbt" % "sbt-play-ebean" % "4.0.1")

addSbtPlugin("com.aol.sbt" % "sbt-sonarrunner-plugin" % "1.0.4")