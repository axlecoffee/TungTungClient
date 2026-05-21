package aura.tungtungclient.bullshit

open class Setting<T: Any>(val name: String, val defaultValue: T) {
  var value = defaultValue
  open var renderHeight = 15

}