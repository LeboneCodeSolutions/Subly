package utils

/**
 * If RegexPatterns.kt grows to something like 50–100 unrelated patterns, then split it by responsibility.
 */
object RegexPatterns {
    val NAME_REGEX = "^[\\p{L}\\s'-]{2,50}$".toRegex()
    val EMAIL_REGEX =  """[a-zA-Z0-9+._%\-]{1,256}@[a-zA-Z0-9][a-zA-Z0-9\-]{0,64}(\.[a-zA-Z0-9][a-zA-Z0-9\-]{0,25})""".toRegex()
    val PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!_])(?=\\S+$).{8,}$".toRegex()
    val NUMBER_REGEX = "^[1-8]\\d{8}$".toRegex()


    val UPPERCASE_REGEX = ".*[A-Z].*".toRegex()
    val VALID_NUMBER_REGEX = ".*\\d.*".toRegex()
    val SPECIAL_CHARACTER_REGEX = ".*[^a-zA-Z0-9].*".toRegex()

    fun regexCheckList(): List<Regex> {
        val list = listOf(
            UPPERCASE_REGEX,
            VALID_NUMBER_REGEX,
            SPECIAL_CHARACTER_REGEX
        )
        return list
    }

}