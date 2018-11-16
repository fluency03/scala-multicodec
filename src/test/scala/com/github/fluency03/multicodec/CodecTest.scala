package com.github.fluency03.multicodec

import com.github.fluency03.multicodec.MiscellaneousCodec.Raw
import com.github.fluency03.multicodec.MultibaseCodec.Base1
import com.github.fluency03.multicodec.MultihashCodec.{BLAKE2b_8, Identity}
import com.github.fluency03.multicodec.SerializationCodec.CBOR
import org.scalatest.{FlatSpec, Matchers}

import scala.io.Source

class CodecTest extends FlatSpec with Matchers {

  it should "be able to get the Codec based Codec name and Codec code." in {
    Codec.values.size shouldBe 396
    Codec.Codes.size shouldBe 396

    Codec.withName("raw") shouldBe Raw
    Codec.withName("base1") shouldBe Base1
    Codec.withName("cbor") shouldBe CBOR
    Codec.withName("blake2b-8") shouldBe BLAKE2b_8

    val existingEntriesString = Codec.values.map(_.entryName).mkString(", ")
    the [NoSuchElementException] thrownBy {
      Codec.withName("blake2b")
    } should have message s"blake2b is not a member of Enum ($existingEntriesString)"
    Codec.withNameOption("blake2b") shouldBe None

    for (c <- Codec.values) {
      Codec.withCode(c.code) shouldBe c
      Codec.withName(c.name) shouldBe c
    }

    for ((code, codec) <- Codec.Codes) {
      Codec.withCode(code) shouldBe codec
      Codec.withName(codec.name).code shouldBe code
    }

    Codec.withCode(0x55) shouldBe Raw
    Codec.withCode(0x00) shouldBe Identity
    Codec.withCode(0x51) shouldBe CBOR
    Codec.withCode(0xb201) shouldBe BLAKE2b_8

    the [NoSuchElementException] thrownBy {
      Codec.withCode(0x123)
    } should have message s"key not found: ${0x123}"

    Codec.withCodeOption(0x123) shouldBe None

    val lines = Source.fromResource("table.csv").getLines
    lines.size shouldBe 396
    for (line <- lines) {
      val row: Array[String] = line.split(',').map(_.trim)
      val name = row(0)
      val code = Integer.parseInt(row(2).substring(2), 16)
      Codec.withCode(code) shouldBe Codec.withName(name)
    }

  }








}
