package ship.f.engine.client.lib.sdui

import ship.f.engine.client.utils.serverdrivenui.CommonClient
import ship.f.engine.shared.core.Dependency

class CommonClientDependency(projectName: String? = null) : Dependency() {
    val client = CommonClient.getClient(projectName)
}