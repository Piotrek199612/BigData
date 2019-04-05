## BigData – Scala

### Krzysztof Jankiewicz

# Scala – projekt

### Dana jest następująca klasa CalculationTree i jej podklasy

**sealed abstract class** CalculationTree
**case class** Leaf(value: Int) **extends** CalculationTree
**case class** Node(op: Char, leaves: CalculationTree *) **extends** CalculationTree

#### Klasa ta jest wykorzystywana do przechowywania wyrażeń matematycznych wykorzystujących następujące operacje

##### (op): -, +, *, /.

##### Operacje -, +, * mogą być wieloargumentowe.

##### Operacja – może być dodatkowo unarna!.

##### Operacja / występuje tylko binarna.

### Przykładowo obiekt

**val** calculus = Node('/',Node('+',Node('*', Leaf( 6 ), Leaf( 2 )),Leaf( 3 ),Leaf( 4 )),Node('-', Leaf( 5 )))

Przechowuje wyrażenie postaci: ((( 6 *2)+3+4)/(-5))

#### Napisz funkcję eval,
która będzie wyznaczała wartość liczbową takiego wyrażenia (dla naszego przykładu wynikiem jest: -3.8).

#### Ponadto napisz funkcje calcToString,
która będzie zamieniała obiekt klasy CalculationTree w tekstowe wyrażenie matematyczne, które będzie mu odpowiadało (dla naszego przykładu: (((6*2)+3+4)/(-5)) ).

#### Podpowiedzi:

- Wykorzystaj w przypadku obu funkcji rekurencję(co jest oczywiste) i dopasowywanie wzorców, znacznie Ci to ułatwi pracę.

- Przy obliczaniu wyniku funkcji calcToString możesz wspomóc się używaną już wcześniej metodą sekwencji mkString, która tworzy ciąg znaków łącząc poszczególne składowe podanym jako argument fragmentem.

##### Przykładowo:

**val** a = Array( 1 , 2 , 3 , 4 , 5 ) //> a : Array[Int] = Array(1, 2, 3, 4, 5)
a.map(x => x.toString).mkString("+") //> res0: String = 1+2+3+4+


