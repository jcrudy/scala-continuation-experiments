
import util.continuations.{shift, reset}

object Experiment6 {

	def main(args: Array[String]) {

		var x: Int = 0
		reset {
			var i: Int = 0
			def f(k: Unit=>Unit): Unit = {k()}
			
			while (i < 100000){
				x += 1
				// x = i
				shift(f)
				
			}


		}
		println(x)


      	
    }

}