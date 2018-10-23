package pp201802.midterm
import pp201802.midterm.Data._

object Main {

  def unzip(l: IList): (IList, IList) =
    l match {
      case INil() => (INil(), INil())
      case ICons(hd1, INil()) => (ICons(hd1, INil()), INil())
      case ICons(hd1, ICons(hd2, tl)) => {
        val (fst, snd) = unzip(tl)
        (ICons(hd1, fst), (ICons(hd2, snd)))
      }
     }

}
