package fhnw.emoba.modules.module05.city.data

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

object CityRepository {
    lateinit var city: City

    fun loadSquad(context: Context) {
        val cityAsString = loadFromAsset(context, "citylist.json")

        city = City(cityAsString)
    }

    /**
     * Liest einen Text-File, der in den Assets abgespeichert ist, ein und gibt den Inhalt als String zurueck
     */
    private fun loadFromAsset(context: Context, fileName: String): String {
        val inputStream = context.assets.open(fileName)
        val reader = BufferedReader(InputStreamReader(inputStream, StandardCharsets.UTF_8))

        val jsonString = reader.readText()

        reader.close()

        return jsonString
    }
}