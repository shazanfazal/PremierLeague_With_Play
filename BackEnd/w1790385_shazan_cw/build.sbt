name := """W1790385_Shazan_CW"""
organization := "com.W1790385_Shazan"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.3"

libraryDependencies += guice
