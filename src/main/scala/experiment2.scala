
import util.continuations.{shift, reset}

object Experiment2 {

	def main(args: Array[String]) {
		var callback: Unit=>Unit = null
		reset {
			def f(k: Unit=>Unit): Unit = {callback = k}
			shift(f)
			println(2)
		}
		println(1)
		callback()


      	
    }

}







