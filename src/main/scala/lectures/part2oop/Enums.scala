package lectures.part2oop

object Enums {
  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    // add fields, methods
    def openDocument(): Unit = {
      if (this == READ) println("Opening document...")
      else println("Reading now allowed")
    }
  }

  val somePermission = Permissions.READ

  // Constructors args
  enum PermissionWithBits(bits: Int){
    case READ extends PermissionWithBits(4) // 100
    case WRITE extends PermissionWithBits(2) //010
    case EXECUTE extends PermissionWithBits(1) //001
    case NONE extends PermissionWithBits(0) //000
  }

  object PermissionWithBits {
    def fromBits(bits: Int): PermissionWithBits = {
      // whatever
      PermissionWithBits.NONE
    }
  }

  // standard API
  val somePermissionOrdinal = somePermission.ordinal
  val permission = PermissionWithBits.values // Array of all possible values of the enum
  val readPermission: Permissions = Permissions.valueOf("READ")


  def main(args: Array[String]): Unit = {
    somePermission.openDocument()
    println(somePermissionOrdinal)
    println(readPermission)
  }
}
