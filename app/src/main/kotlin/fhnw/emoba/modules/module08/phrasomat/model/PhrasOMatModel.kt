package fhnw.emoba.modules.module08.phrasomat.model

import kotlin.random.Random

object PhrasOMatModel {
    //todo 2: modelScope definieren

    val title = "PhrasOMat"

    //todo 1: geeignete Liste fuer die Phrasen definieren



    //todo 2: in Data-Layer verschieben
    private val wordListOne  = listOf("verlässliche", "erfolgsorientierte", "webbasierte", "allumfassende",
                                      "clevere", "kundenorientierte", "pfadkritische", "dynamische",
                                      "konkurrenzfähige", "verteilte", "zielgerichtete")

    private val wordListTwo  = listOf("gepowerte", "haftende", "Mehrwert-", "zentrierte", "geclusterte",
                                      "proaktive", "Out-of-the-Box", "positionierte", "vernetzte",
                                      "fokussierte", "kraftvolle", "geordnete", "geteilte", "kooperative",
                                      "beschleunigte", "Multi-Tier-", "Enterprise-", "B2B-", "Frontend-")

    private val wordListThree = listOf("Schicht", "Endstufe", "Lösung", "Architektur", "Kernkompentenz",
                                       "Strategie", "Kooperation", "Ausrichtung", "Räumlichkeit", "Vision",
                                       "Dimension", "Mission")

    //todo 2: wie kann das einfacher/uebersichtlicher implementiert werden?
    private fun generatePhrase(): String =
            wordListOne  [Random.nextInt(1, wordListOne.size)] + " " +
            wordListTwo  [Random.nextInt(1, wordListTwo.size)] + " " +
            wordListThree[Random.nextInt(1, wordListOne.size)] + " "



    //todo 1: Funktion, die neue Phrase einer Liste hinzufuegt



    //todo 2: PhrasenGenerator asnychron aufrufen

}