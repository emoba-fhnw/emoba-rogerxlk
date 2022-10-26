package fhnw.emoba.modules.module06.weather_solution.model

class LRUCache<key, value>(val maxSize: Int) : LinkedHashMap<key, value>(maxSize, 0.75f, true) {
    override fun removeEldestEntry(eldest: MutableMap.MutableEntry<key, value>?): Boolean {
        return size > maxSize
    }
}