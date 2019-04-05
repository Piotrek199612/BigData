case class Leaf(value: Int) extends CalculationTree
case class Node(op: Char, leaves: CalculationTree *) extends CalculationTree

sealed abstract class CalculationTree extends App {

  def calcToString(): String ={
    this match {
      case Leaf(x) => x.toString
      case Node('-',leaf_1) => "(-" + leaf_1.calcToString()+")"
      case Node('/',leaf_1, leaf_2) => "("+leaf_1.calcToString()+"/"+leaf_2.calcToString()+")"
      case Node(op, leaves @ _*) => "("+leaves.map(_.calcToString()).mkString(op.toString) + ")"
    }
  }

  def eval(): Float = {
    this match {
      case Leaf(x) => x
      case Node('-',leaf) => -leaf.eval()
      case Node('/',leaf_1, leaf_2) => leaf_1.eval()/leaf_2.eval()
      case Node('+', leaves @ _*) => leaves.map(_.eval()).sum
      case Node('-', leaves @ _*) => leaves.map(_.eval()).reduceLeft(_-_)
      case Node('*', leaves @ _*) => leaves.map(_.eval()).product
    }
  }

}
