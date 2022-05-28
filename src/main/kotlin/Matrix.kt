class Matrix(private val matrixAsString: String) {

    private val matrix = matrixAsString.lines()

    private fun column(colNb: Int): List<Char> = matrix.map { it[colNb - 1] }
    private fun row(rowNb: Int): String = matrix[rowNb - 1]
    private fun nbOfElementsInRow(rowNb: Int) = row(rowNb).count()

    private fun determineIfZeroBitOccurrenceIsGreaterThanOneBit(colNb: Int): Boolean {
        val occurrenceOfZeroBit = column(colNb).count { it == '0' }
        val occurrenceOfOneBit = column(colNb).count { it == '1' }
        return occurrenceOfZeroBit > occurrenceOfOneBit
    }

    private fun calculateGammaRate(): String {
        var gammaRate = ""
        for (i in 1..nbOfElementsInRow(1)) {
            gammaRate += if (determineIfZeroBitOccurrenceIsGreaterThanOneBit(i)) {
                "0"
            }else{
                "1"
            }
        }
        return gammaRate
    }

    private fun gammaRateInDecimals() = calculateGammaRate().toInt(2)

    private fun calculateEpsilonRate(): String {
        val map = mapOf('0' to '1', '1' to '0')
        return calculateGammaRate().map { map.getOrDefault(it, it) }.joinToString("")
    }

    private fun epsilonRateInDecimals() = calculateEpsilonRate().toInt(2)

    fun calculatePowerConsumption() = epsilonRateInDecimals() * gammaRateInDecimals()



}