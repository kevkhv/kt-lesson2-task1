const val minute = 60
const val hour = minute * 60
const val day = hour * 24

fun main() {
    val secondsAgo = 68400
    println(agoToText(secondsAgo))
}
fun agoToText(secondsAgo: Int): String {
    return when {
        (secondsAgo <= 60) -> "был(а) только что"
        secondsAgo in 61..hour -> "был(а) ${secondsAgo / minute} ${getStringMinutes(secondsAgo)} назад"
        secondsAgo in (hour + 1)..day -> "был(а) ${secondsAgo / hour} ${getStringHours(secondsAgo)} назад"
        secondsAgo in (day + 1)..(day * 2) -> "был(а) сегодня"
        secondsAgo in ((day * 2) + 1)..(day * 3) -> "был(а) вчера"
        else -> "был(а) давно"
    }
}
fun getStringMinutes(secondsAgo: Int): String {
    val min = secondsAgo / minute
    return when {
        min % 10 == 1 && min !in 11..14 -> "минуту"
        min % 10 in 2..4 && min !in 11..14  -> "минуты"
        else -> "минут"
    }
}
fun getStringHours(secondsAgo: Int): String {
    val hr = secondsAgo / hour
    return when {
        hr % 10 == 1 && hr !in 11..14 -> "час"
        hr % 10 in 2..4 && hr !in 11..14-> "часа"
        else -> "часов"
    }
}




