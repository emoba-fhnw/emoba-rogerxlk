package fhnw.emoba.modules.module08.lotto.data

import kotlin.random.Random

fun gewinnzahlenZiehen(): Ziehung {
    // todo: sechs unterschiedliche Gewinnzahlen ziehen und aufsteigend sortieren
    // Hinweis: eventuell ist ein Set hilfreich


    // todo: Superzahl ziehen, ist eine Zahl von 0-9


    //todo: emptyList und 7 ersetzen
    return Ziehung(emptyList(), 7)
}

//liefert eine Zahl von 1..49
private fun naechsteKugel() = Random.nextInt(from = 1, until = 50)