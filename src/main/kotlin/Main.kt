
fun main() {

    val test = """
            00100
            11110
            10110
            10111
            10101
            01111
            00111
            11100
            10000
            11001
            00010
            01010
            """.trimIndent()
    val test2 = listOf("00100","11110","10110","10111","10101","01111","00111","11100","10000","11001","00010","01010")


    val matrix = Matrix(test)
    val matrixList = MatrixList(test2)

    println(matrix.calculatePowerConsumption())
    println("**********")
    println(matrixList.calculateConsumption())
    println("**********")


}