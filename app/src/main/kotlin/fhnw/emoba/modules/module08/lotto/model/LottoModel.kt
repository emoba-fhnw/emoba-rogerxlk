package fhnw.emoba.modules.module08.lotto.model

import androidx.compose.runtime.mutableStateListOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import fhnw.emoba.modules.module08.lotto.data.Ziehung
import fhnw.emoba.modules.module08.lotto.data.gewinnzahlenZiehen

object LottoModel {
    private val modelScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    val title = "Lotto 6 aus 49"

    // ersetzen durch geeignete Variante, um die Liste von allen Ziehungen zu verwalten
    val alleZiehungen = mutableStateListOf<Ziehung>()

    // ersetzen durch geeignete Variante, um die Liste aller Kaestchen des aktuellen Lottoscheins zu verwalten
    var lottoschein = mutableStateListOf<Kaestchen>()


    fun neuerLottoschein(anzahlKaestchen: Int){
        // auch wenn es diesem Beispiel kein Performanceproblem gibt:
        // "Datenservices" ruft man asynchron auf
        modelScope.launch {
            //mittels 'gewinnzahlenZiehen()'( siehe 'Ziehungsgeraet') eine Liste
            //von Kaestchen erzeugen und 'lottoschein' zuweisen

            lottoschein.add(Kaestchen(gewinnzahlenZiehen()))
        }
    }

    fun neueZiehung(){
        modelScope.launch {
            //neue Gewinnzahlen ziehen (siehe 'Ziehungsgeraet.gewinnzahlenziehen')
            // und 'alleZiehungen' hinzufuegen
            val aktuelleGewinnzahlen = gewinnzahlenZiehen()
            alleZiehungen.add(aktuelleGewinnzahlen)

            // bei allen Kaestchen des aktuellen Lottoscheins das ergebnis setzen
            lottoschein.forEach { it.ergebnis(ziehung = aktuelleGewinnzahlen) }
        }
    }
}