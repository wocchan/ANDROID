package com.example.hello

import java.util.*

fun randomDay(): String {
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}


fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else  -> false
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

val isUnit = println("This is an expression")
val temperature = 10
val isHot = if (temperature > 50) true else false
val message = "The water temperature is ${if (temperature > 50) "too warm" else "OK"}."
val eager = decorations.filter { it [0] == 'p' }
val filtered = decorations.asSequence().filter { it[0] == 'p' }
val newList = filtered.toList()
val lazyMap = decorations.asSequence().map {
    println("access: $it")
    it
}
val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
    println("access: $it")
    it
}

val mysports = listOf("basketball", "fishing", "running")
val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
val mylist = listOf(mysports, myplayers, mycities)

var dirtyLevel = 20


val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }


fun main(args: Array<String>) {
    println("Hello, world!")
    println("-----")
    println(isUnit)
    println(isHot)
    println(message)
    println("-----")
    feedTheFish()
    println("-----")
    swim()
    swim("slow")
    swim(speed="turtle-like")
    println("-----")
    println("eager: $eager")
    println("filtered: $filtered")
    println("new list: $newList")
    println("-----")
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")

    println("-----")
    println("filtered: ${lazyMap2.toList()}")

    println("-----")
    println("Flat: ${mylist.flatten()}")
    println("-----")
    println(updateDirty(30, waterFilter))

}
