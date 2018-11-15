package com.github.fluency03.multicodec

import com.github.fluency03.multicodec.Codec._
import org.scalatest.{FlatSpec, Matchers}

class CodecTest extends FlatSpec with Matchers {

  it should "be able to get the Codec based Codec name and Codec code." in {
    Codec.withName("raw") shouldBe Raw
    Codec.withName("base1") shouldBe Base1
    Codec.withName("cbor") shouldBe CBOR
    Codec.withName("blake2b-8") shouldBe BLAKE2b_8

    val existingEntriesString = values.map(_.entryName).mkString(", ")
    the [NoSuchElementException] thrownBy {
      Codec.withName("blake2b")
    } should have message s"blake2b is not a member of Enum ($existingEntriesString)"
    Codec.withNameOption("blake2b") shouldBe None

    Codec.values.size shouldBe Codec.Codes.size

    println(Codec.values.size + " - " + Codec.Codes.size)
    for (c <- Codec.values) {
      Codec.withCode(c.code) shouldBe c
      Codec.withName(c.name) shouldBe c
    }

    for ((code, codec) <- Codec.Codes) {
      Codec.withCode(code) shouldBe codec
      Codec.withName(codec.name).code shouldBe code
    }

    Codec.withCode(0x55) shouldBe Raw
//    Codec.withCode('1') shouldBe Base1
    Codec.withCode(0x51) shouldBe CBOR
    Codec.withCode(0xb201) shouldBe BLAKE2b_8

    the [NoSuchElementException] thrownBy {
      Codec.withCode(0x123)
    } should have message s"key not found: ${0x123}"

    Codec.withCodeOption(0x123) shouldBe None
  }


}
