package scala.meta.internal.implementation

import io.github.classgraph.ClassGraph

final class ClassGraphTable(pkgName: String, className: String) {

  val classpath: String = pkgName + className

  def scan(): Unit = {
    val scanResult = new ClassGraph()
      .enableClassInfo()
      .whitelistPackages(pkgName)
      .scan()

    try {
      val classes = scanResult.getSubclasses(classpath)
      println(s"ClassGraphTable> $classes")

    } finally {
      scanResult.close()
    }

  }

}
