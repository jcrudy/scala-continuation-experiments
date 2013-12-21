
import util.continuations.{shift, reset}

object Experiment1 {

	def main(args: Array[String]) {
		val x = reset {
			def f(k: Int=>Int): Int = {k(7)}
			shift(f) + 1
		}
		println(x)


      	
    }

}







