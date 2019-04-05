import org.scalatest.FunSuite

class CalculatonTreeTest extends FunSuite{
  test("CalculationTree.calcToString simple"){
    assert(Leaf(0).calcToString()=="0")
  }

  test("CalculationTree.calcToString addition"){
    assert(Node('+',Leaf(1),Leaf(2)).calcToString()=="(1+2)")
  }

  test("CalculationTree.calcToString subtraction"){
    assert(Node('-',Leaf(1),Leaf(2)).calcToString()=="(1-2)")
  }

  test("CalculationTree.calcToString multiplication"){
    assert(Node('*',Leaf(1),Leaf(2)).calcToString()=="(1*2)")
  }

  test("CalculationTree.calcToString division"){
    assert(Node('/',Leaf(1),Leaf(2)).calcToString()=="(1/2)")
  }

  test("CalculationTree.calcToString three additions"){
    assert(Node('+',Leaf(1),Node('+',Leaf(2),Leaf(3))).calcToString()=="(1+(2+3))")
  }


  test("CalculationTree.calcToString exaple from project"){
    val calculus = Node('/',
                        Node('+',
                             Node('*', Leaf(6), Leaf(2)),
                             Leaf(3),
                             Leaf(4)
                        ),
                        Node('-', Leaf(5)))
    assert(calculus.calcToString()=="(((6*2)+3+4)/(-5))")
  }

  test("CalculationTree.eval simple"){
    assert(Leaf(0).eval()==0)
  }

  test("CalculationTree.eval addition"){
    assert(Node('+',Leaf(1),Leaf(2)).eval()==3.0f)
  }

  test("CalculationTree.eval subtraction"){
    assert(Node('-',Leaf(1),Leaf(2)).eval()==(-1.0f))
  }

  test("CalculationTree.eval multiplication"){
    assert(Node('*',Leaf(1),Leaf(2)).eval()==2.0f)
  }

  test("CalculationTree.eval division"){
    assert(Node('/',Leaf(1),Leaf(2)).eval()==0.5f)
  }

  test("CalculationTree.eval three additions"){
    assert(Node('+',Leaf(1),Node('+',Leaf(2),Leaf(3))).eval()==6)
  }

  test("CalculationTree.eval exapmle from project"){
    val calculus = Node('/',
      Node('+',
        Node('*', Leaf(6), Leaf(2)),
        Leaf(3),
        Leaf(4)
      ),
      Node('-', Leaf(5)))
    assert(calculus.eval()==(-3.8f))
  }

}
