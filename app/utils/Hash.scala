package utils

import java.security.MessageDigest
import org.apache.commons.codec.binary.Hex

object Hash {

  abstract class Algorithm {
    def get: MessageDigest

    def apply(in: String): Digest = {
      val c = get
      c.reset()
      c.update(in.getBytes("UTF-8"))
      new Digest(c.digest())
    }
  }

  object SHA1 extends Algorithm {
    override def get: MessageDigest = MessageDigest.getInstance("SHA-1")
  }

  class Digest(val rawBytes: Array[Byte]) extends AnyVal {
    def toBytes: Seq[Byte] = rawBytes.toList

    def toHexString: String = Hex.encodeHexString(rawBytes)
  }

}
