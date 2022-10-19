package fhnw.emoba.modules.module05.squad.data

import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import android.content.Context

object SquadRepository {
    lateinit var squad: Squad
    
    fun loadSquad(context: Context) {
        val squadAsString = loadFromAsset(context, "superherosquad.json")
       
        squad = Squad(squadAsString)
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