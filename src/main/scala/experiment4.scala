
import util.continuations.{shift, reset}

object Experiment4 {

	def main(args: Array[String]) {

		var x: Int = -1
		reset {
			var i: Int = 0
			def f(k: Unit=>Unit): Unit = {k()}
			
			while (i < 100){
				i += 1
				x = i
				shift(f)
				
			}


		}
		println(x)


      	
    }

}