import play.sbt.PlayRunHook
import sbt._

import scala.sys.process.Process

/**
 * Frontend build play run hook.
 * https://www.playframework.com/documentation/2.8.x/SBTCookbook
 */
object FrontendRunHook {
  def apply(base: File): PlayRunHook = {
    object UIBuildHookProcess extends PlayRunHook {

      var processingOption: Option[Process] = None

      /**
       * Change the commands in `FrontendCommands.scala` if you want to use Yarn.
       */
      var installDependencies: String = FrontendCommands.dependencyInstall
      var runUI: String = FrontendCommands.serve

      // Windows requires npm commands prefixed with cmd /c
      if (System.getProperty("os.name").toLowerCase().contains("win")){
        installDependencies = "cmd /c" + installDependencies
        runUI = "cmd /c" + runUI
      }

      /**
       * Executed before play run start.
       * Run npm install if node modules are not installed.
       */
      override def beforeStarted(): Unit = {
        if (!(base / "ui" / "node_modules").exists()) Process(installDependencies, base / "ui").!
      }

      /**
       * Executed after play run start.
       * Run npm start
       */
      override def afterStarted(): Unit = {
        processingOption = Option(
          Process(runUI, base / "ui").run
        )
      }

      /**
       * Executed after play run stop.
       * Cleanup frontend execution processes.
       */
      override def afterStopped(): Unit = {
        processingOption.foreach(_.destroy())
        processingOption = None
      }

    }
    UIBuildHookProcess
  }
}
