package fhnw.emoba.modules.module04.countries.data

object Repository {

//Todo: Hier sind einige Laender. Implementieren Sie Country so, dass die Kommentare entfernt werden
// koennen, ohne dass Compile-Fehler auftreten.

//die Parameter sollen in diesem Beispiel nicht mehr veraendert werden koennen.

    val countries = listOf(
            Country(name = "Liechtenstein", area =     160.5,  population =     38_650),
            Country(name = "Schweiz",       area =  41_285.0,  population =  8_603_900),
            Country(name = "Italien",       area = 301_338.0,  population = 60_260_229),
            Country(name = "Frankreich",    area = 632_834.0,  population = 66_993_000),
            Country(name = "Spanien",       area = 505_970.0,  population = 47_100_396),
            Country(name = "Portugal",      area =  92_212.0,  population = 10_600_000),
            Country(name = "Griechenland",  area = 131_957.0,  population = 10_727_668),
            Country(name = "Schweden",      area = 447_435.0,  population = 10_327_589),
            Country(name = "San Marino",    area =     61.19,  population =     33_420)
    )
}