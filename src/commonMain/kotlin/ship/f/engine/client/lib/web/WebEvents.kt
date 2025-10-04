package ship.f.engine.client.lib.web

import ship.f.engine.shared.core.Event

data class ReturnCodeEvent(
    val code: String, // TODO will probably need something more elaborate, mabe even scoping
) : Event()