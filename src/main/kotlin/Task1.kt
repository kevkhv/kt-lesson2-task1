const val minute = 60
const val hour = minute * 60
const val day = hour * 24

fun main() {
    val secondsAgo = 68400
    println(agoToText(secondsAgo))
}
fun agoToText(secondsAgo: Int): String {
    val minutes = secondsAgo / minute
    val hours = secondsAgo / hour
    return when {
        (secondsAgo <= minute) -> "был(а) только что"
        secondsAgo in minute..hour -> "был(а) $minutes ${getStringMinutes(minutes)} назад"
        secondsAgo in (hour + 1)..day -> "был(а) $hours ${getStringHours(hours)} назад"
        secondsAgo in (day + 1)..(day * 2) -> "был(а) сегодня"
        secondsAgo in ((day * 2) + 1)..(day * 3) -> "был(а) вчера"
        else -> "был(а) давно"
    }
}
fun getStringMinutes(minutes: Int): String {
    return when {
        minutes % 10 == 1 && minutes !in 11..14 -> "минуту"
        minutes % 10 in 2..4 && minutes !in 11..14  -> "минуты"
        else -> "минут"
    }
}
fun getStringHours(hours: Int): String {
    return when {
        hours % 10 == 1 && hours !in 11..14 -> "час"
        hours % 10 in 2..4 && hours !in 11..14-> "часа"
        else -> "часов"
    }
}




