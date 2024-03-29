package controllers
import javax.inject._
import play.api.Configuration
import play.api.http.HttpErrorHandler
import play.api.mvc._

/**
 * Frontend controller managing all static resource associate routes.
 * @param assets Assets controller reference.
 * @param cc Controller components reference.
 */
@Singleton
class FrontendController @Inject()(assets: Assets, errorHandler: HttpErrorHandler, config: Configuration, cc: ControllerComponents) extends AbstractController(cc) {

  def index:
    Action[AnyContent] = assets.at("index.html")

  def assetOrDefault(resource: String):
    Action[AnyContent] = if (resource.startsWith(config.get[String]("apiPrefix"))) {
      Action.async(response => errorHandler.onClientError(response, NOT_FOUND, "Response Not found"))
    } else {
      if (resource.contains(".")) {
        assets.at(resource)
      } else {
        index
      }
  }
}
