package fhnw.emoba.modules.module08.lotto.data

import androidx.compose.runtime.mutableStateListOf
import kotlin.random.Random
import kotlin.streams.toList

fun gewinnzahlenZiehen(): Ziehung {
    // sechs unterschiedliche Gewinnzahlen ziehen und aufsteigend sortieren
    // Hinweis: eventuell ist ein Set hilfreich
    val set = mutableSetOf<Int>()
    var randomInt = naechsteKugel()
    while (set.size < 7) {
        if(!set.contains(randomInt)){
            set.add(randomInt)
        } else {
            randomInt = naechsteKugel()
        }
    }

    val gewinnZahlen = mutableStateListOf<Int>()
    for (i in set.stream().sorted().toList()) {
        gewinnZahlen.add(i)
    }

    // Superzahl ziehen, ist eine Zahl von 0-9
    val superZahl = Random.nextInt(from = 0, until = 9)

    //emptyList und 7 ersetzen
    return Ziehung(gewinnZahlen, superZahl)
}

//liefert eine Zahl von 1..49
private fun naechsteKugel() = Random.nextInt(from = 1, until = 50)