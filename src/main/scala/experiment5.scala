
import util.continuations.{shift, reset}

object Experiment5 {

	def wrap(f: (Unit=>Unit) => Unit ) = shift(f)

	def main(args: Array[String]) {
		var callback: Unit=>Unit = null
		reset {
			def f(k: Unit=>Unit): Unit = {callback = k}
			wrap(f)
			println(2)
		}
		println(1)
		callback()


      	
    }

}







