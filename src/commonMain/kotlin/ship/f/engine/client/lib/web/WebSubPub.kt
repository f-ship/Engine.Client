package ship.f.engine.client.lib.web

import ship.f.engine.client.lib.web.WebSubPub.WebState
import ship.f.engine.shared.core.ScopedEvent
import ship.f.engine.shared.core.State
import ship.f.engine.shared.core.SubPub

class WebSubPub : SubPub<WebState>(
    nonRequiredEvents = setOf()
) {
    data class WebState(
        val url: String? = null,
    ) : State()

    override fun initState() = WebState()

    override suspend fun ScopedEvent.onEvent() {

    }
}