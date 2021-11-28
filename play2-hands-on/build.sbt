name := """play2-hands-on"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"
libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "8.0.22",
  // ScalikeJDBC本体
  "org.scalikejdbc" %% "scalikejdbc" % "3.5.0",
  // テスト用にh2 DBを使えるようにしておく（この記事では使わない）
  "com.h2database" % "h2" % "1.4.200", // for test purpose
  // ScalikeJDBCが要求するログフレームワーク
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  // テスト時にいろいろ助けてくれるらしいパッケージ
  "org.scalikejdbc" %% "scalikejdbc-test" % "3.5.0" % "test",
  // 今回はapplication.confに接続・コネクションプールの設定を記述する．
  // それを読み取るためのパッケージ
  "org.scalikejdbc" %% "scalikejdbc-config" % "3.5.0"
)
// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
