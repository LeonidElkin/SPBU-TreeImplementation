package abstractTree

open class Vertex<T>(private val key: Int, private var value: T){
    private var height = 1

    fun getKey() = this.key

    fun getValue() = this.value

    fun setValue(newValue: T){
        this.value = newValue
    }

    fun getHeight() = this.height

    fun setHeight(newValue: Int){
        this.height = newValue
    }
}