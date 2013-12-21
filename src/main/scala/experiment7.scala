
import util.continuations.{shift, reset, cpsParam}


abstract class Generator[T] extends Iterator[T] {
	private var result: T = _
	private var empty = false
	var callback: Unit=>Unit = null
	reset {
		generate()
		empty = true
	}

	def generate(): Unit @cpsParam[Unit,Unit]

	def produce(item: T) = {
		shift {f: (Unit=>Unit) =>
			callback = f
			result = item
		}
	}

	def hasNext: Boolean = !empty

	def next(): T = {
		val thisResult = result
		callback()
		thisResult
	}
}

class InfiniteCounter2 extends Generator[Int] {
	def generate() = {
		var i = 0
		while (true) {
			i += 1
			produce(i)
		}
	}
}

object Experiment7 {

	def main(args: Array[String]) {
		val counter = new InfiniteCounter2()
		println(counter.next())
		println("Hello")
		println(counter.next())
		for (i <- 0 until 1000000) {
			counter.next()
		}
		println(counter.next())
    }

}