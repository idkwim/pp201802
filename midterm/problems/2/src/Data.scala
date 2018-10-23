package pp201802.midterm.Data

sealed abstract class IList
case class INil() extends IList
case class ICons(hd: Int, tl: IList) extends IList
