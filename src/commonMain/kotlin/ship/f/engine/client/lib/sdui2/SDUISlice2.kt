package ship.f.engine.client.lib.sdui2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import ship.f.engine.client.utils.serverdrivenui3.ServerDrivenScreen3
import ship.f.engine.client.utils.serverdrivenui3.ServerToastEvent
import ship.f.engine.shared.core.Slice
import ship.f.engine.shared.core.ToastEvent
import ship.f.engine.shared.sdui2.SDUISubPub2
import ship.f.engine.shared.sdui2.SDUISubPub2.SDUIState2
import ship.f.engine.shared.utils.serverdrivenui2.ext.sduiLog

object SDUISlice2 : Slice<SDUIState2, SDUISubPub2>(
    subPubClass = SDUISubPub2::class,
) {
    @Composable
    operator fun invoke() = Show()

    @Composable
    override fun EntryPoint(state: MutableState<SDUIState2>) {
        sduiLog("sending ${state.value.toast}", tag = "EntryPoint > Toast") { state.value.toast != null}
        ServerDrivenScreen3(
            projectName = state.value.projectName,
            resources = state.value.resources,
            vectors = state.value.vectors,
            toast = state.value.toast?.run {
                ServerToastEvent(
                    message = message,
                    durationMs = durationMs,
                    actionText = actionText,
                    key = key,
                    toastType = when(toastType){
                        ToastEvent.ToastType.Error -> ServerToastEvent.ToastType.Error
                        ToastEvent.ToastType.Success -> ServerToastEvent.ToastType.Success
                        ToastEvent.ToastType.Warning -> ServerToastEvent.ToastType.Warning
                    }
                )
            },
        )
    }

    @Composable
    override fun notReadyEntryPoint(state: MutableState<SDUIState2>): @Composable (() -> Unit) {
        println("EngineX: SDUISlice2 not ready yet")
        return {
            // No need to render anything here
        }
    }
}
