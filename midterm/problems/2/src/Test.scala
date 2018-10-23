package pp201802.midtermtest
import pp201802.midterm.Main._
import pp201802.midterm.Data._

object Test extends App {
  def print_result(b:Boolean) : Unit =
    if (b) println("O") else println("X")
  
  print_result(unzip(ICons(1, (ICons(2, INil())))) == (ICons(1, INil()), ICons(2, INil())))

}
