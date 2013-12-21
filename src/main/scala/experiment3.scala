
import util.continuations.{shift, reset}


class InfiniteCounter extends Iterator[Int] {
	var count = 0
	var callback: Unit=>Unit = null
	reset {
		while (true) {
			shift {f: (Unit=>Unit) =>
				callback = f
			}
			count += 1
		}

	}

	def hasNext: Boolean = true

	def next(): Int = {
		callback()
		count
	}
}

object Experiment3 {

	def main(args: Array[String]) {
		val counter = new InfiniteCounter()
		println(counter.next())
		println("Hello")
		println(counter.next())
		for (i <- 0 until 100000000) {
			counter.next()
		}
		println(counter.next())
    }

}