








--loop
    val a = listOf(1,2,56,7,0)
    a.forEach {
        println(it)
    }

    for((i , j) in a.withIndex()){
        println("$i $j")
    }

    // key to value  == quantity to price
    var a = mapOf(1 to 12, 5 to 9, 20 to 11)
        // we want to find the total
    var theSum  = 0
    a.forEach{
        theSum +=it.key * it.value
    }


--filter
    val greaterThan10 = a.filter{
        it > 10
    }

--map
   val multiplyBy20 = a.map{
        it * 20
    }

    val changeTheType = theList.map{
        it.toIntOrNull()
    }  // can give you say == [12, 2, 43, 9, null, 33]

    var newList = a.mapNotNull{
        it.toIntOrNull()
    } //  will give out  == [12, 2, 43, 9, 33]  without the null

--fold
    var a = listOf(1,3,5,7)
    var theSum = a.fold(0){a,b ->
        a+b
    }  // theSum == 16  // 0 in the fold is the initial value


-- reduce
    // same as the fold - but uses the starting elements as the initial value
    var a = listOf(1,3,5,7)
    var theSum = a.reduce { acc, i ->
        acc+i
    } // theSum = 16





TypeCasting
theIntValue.toDouble() .. toInt() .. toString()

checkType
theValue::class.simpleName








Array
var a = arrayOf("a", "b")
a.sorted()
a.joinToString(separator=",")
a.sortedWith(compareBy{ -it.length })
// negative sign is for descending order, + = ascending order





List
val a = listOf("frank", "ben", "Priscilla")
var b = a.sortedWith(compareBy{
        +it.length
})







Lambdas

declarations and assignment

    var theFunction: (Int, Int) -> Int
    theFunction = {a: Int, b: Int ->Int
        a+b
    }
   var theResult = theFunction(2,5)

anotherWay of writing
   var theFunction:(Int, Int) -> Int
   theFunction = { a, b ->
            a * b
   }


combining them

    var fullName: (String, String) -> String = { firstName, SurName ->
        "$firstName $SurName"
    }
    var person1 = fullName("Frank", "Aboagye")

lambda with one value
    var theAge:(Int)-> Int = { a ->
        3 * a
    }
    var ageInTwoYears = theAge(23)
    println(ageInTwoYears)

    var theSecondAge:(Int) ->Int = {
        3 * it
    }
    println(theSecondAge(33))


e.g. of lambda function to double a number
    val square: (Int) -> Int = { it * it }
    var doubleTheNumber:(Int) ->Int = {
        it * it
    }

A lambda function in a Function
    fun theFunction(a:Int, b:Int, perform:(Int, Int)->Int):Unit{
        var theResult = perform(a,b)
        println("The result is $theResult")
    }
    var theLambdaFunction:(Int, Int)->Int = {a,b -> a + b}
    theFunction(20, 17, theLambdaFunction)




    the above is similar to

    fun theFunction(a:Int, b:Int, perform:(Int, Int)->Int):Unit{
        var theResult = perform(a,b)
        println("The result is $theResult")
    }

    fun addFunction(a:Int, b:Int):Int = a+b

    theFunction(12,45, ::addFunction)  // using the reference operator


you can define the lambda function in the call
e.g. theFunction(12,45, perform = {a,b -> a+b})  or
     theFunction(12,45, {a,b -> a+b})



A type of lambda function
-- it takes two number and add them.. from the Int class
-- Int::plus


lambdas with no return
    var unitLambda: () -> Unit = {
        println("iiiiiii")
    }
    unitLambda()

when lambda does not do anything -- use the Nothing type
e.g. Just throwing an exception


capturing from enclosing scope

        var a  = 0
        var theLambda:()->Unit = {
            a+=1
        }

        theLambda()
        theLambda()
        println("The value of a = $a") // the value of a  = 2


        // neat thing here
            fun countingLambda(): () -> Int {
                var counter = 0
                val incrementCounter: () -> Int = {
                    counter += 1
                    counter
                }
                return incrementCounter
            }

            val counter1 = countingLambda()
            val counter2 = countingLambda()

            println(counter1()) // > 1
            println(counter2()) // > 1
            println(counter1()) // > 2
            println(counter1()) // > 3
            println(counter2()) // > 2


use lambda for clever sorting

   val a = arrayOf(1,6,9,0,1,3,4)

    var theSorted = a.sortedWith(compareBy{
        -it.hashCode()
    })
    println(theSorted) // > [9, 6, 4, 3, 1, 1, 0]

    val a = arrayOf("frank", "ben", "Priscilla")

    var theSorted = a.sortedWith(compareBy{
        -it.length
    })

    println(theSorted)  // > [Priscilla, frank, ben]


















// building your own types



