package DataStructureAndAlgorithm


/**
  * Created by jiangzl on 2016/10/24.
  */
class Tree {
  var value: String = ""
  var left: Tree = _
  var right: Tree = _

  def this(value: String){
    this()
    this.value = value
  }

  def this(value: String, left: Tree = new Tree, right: Tree = new Tree){
    this(value)
    this.left = left
    this.right = right
  }
}

object TreeRecursion {

  // 前序遍历：
  def beforeTraverse(tree: Tree): Unit = {
    if ( tree.isInstanceOf[Tree] ) {
      if (tree.value != "") print(tree.value+"\t")
      beforeTraverse(tree.left)
      beforeTraverse(tree.right)
    }
  }

  // 中序遍历：
  def midTraverse(tree: Tree): Unit = {
    if ( tree.isInstanceOf[Tree] ) {
      midTraverse(tree.left)
      if (tree.value != "") print(tree.value+"\t")
      midTraverse(tree.right)
    }
  }

  // 后序遍历：
  def afterTraverse(tree: Tree): Unit = {
    if ( tree.isInstanceOf[Tree] ) {
      afterTraverse(tree.left)
      afterTraverse(tree.right)
      if (tree.value != "") print(tree.value+"\t")
    }
  }

  def main(args: Array[String]) {
    // val tree = new Tree("D", right=new Tree("C"))
    val tree = new Tree("D", new Tree("B", new Tree("A"), new Tree("C")), new Tree("E", right=new Tree("G", left=new Tree("F"))))
    println("\n前序遍历：")
    beforeTraverse(tree)
    println("\n中序遍历：")
    midTraverse(tree)
    println("\n后序遍历：")
    afterTraverse(tree)
  }
}
