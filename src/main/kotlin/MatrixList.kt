class MatrixList(private val matrixList: List<String>) {
    private fun nbElements() = matrixList[0].count()
    private fun column(): List<List<Char>> {
        val list: MutableList<List<Char>> = ArrayList()
        for (i in 0 until nbElements()) {
            list.add(matrixList.map { it[i] })
        }

        return list.toList()
    }

    fun calculateConsumption(): Int {
        val list = column()
        var gammaRate = ""
        val map = mapOf('0' to '1', '1' to '0')
        val convertToListOfStrings = list.map { it -> String(it.toCharArray()) }
        val zeroBitOccurrence = convertToListOfStrings.map { it -> it.count { it == '0' } }
        val oneBitOccurrence = convertToListOfStrings.map { it -> it.count { it == '1' } }
        for (i in list.indices) {
            gammaRate += if (zeroBitOccurrence[i] > oneBitOccurrence[i]) {
                "0"
            } else {
                "1"
            }
        }
        val epsilonRate = gammaRate.map { map.getOrDefault(it, it) }.joinToString("")
        return gammaRate.toInt(2) * epsilonRate.toInt(2)
    }

}