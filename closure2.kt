fun main(args : Array<String>){
    var obj = ani{
        crying()
        eat()
        nCount++
    }
    println("증가된 숫자는 ${obj.nCount}입니다.")
    obj.setOnEvent(3,"울어") { nCount ->
        println("${nCount}번 울겠습니다.")
        (1..nCount).map{crying()}
    }
    obj.setOnEvent(2, "먹어") { nCount ->
        println("${nCount}번 먹겠습니다.")
        (1..nCount).map{eat()}
    }
}

fun ani(extFunc : Animal.() -> Unit) : Animal{
    var ani = Animal()
    ani.extFunc()
    return ani
}

class Animal{
    open var nCount = 0
    fun crying() = println("$this>> 아흥")
    fun eat() = println("$this>> 우걱우걱")
    open fun setOnEvent(nCount: Int, message : String, extFunc: Animal.(Int) -> Unit) : Animal{
        when(message){
            "울어" -> {extFunc(nCount)}
            "먹어" -> {var n = if(nCount<3) 3 else nCount; extFunc(n)}
            else -> {println("알 수 없는 메시지 : ${message}입니다.")}
        }
        return this
    }
}