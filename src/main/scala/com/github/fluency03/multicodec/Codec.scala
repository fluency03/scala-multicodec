package com.github.fluency03.multicodec

import enumeratum._

import scala.collection.immutable

/**
 * Codec
 * @param name Codec name
 * @param code Codec code
 */
sealed abstract class Codec(val name: String, val code: Int) extends EnumEntry {
  override def entryName: String = name
}


/**
 * MiscellaneousCodec
 */
sealed abstract class MiscellaneousCodec(
    override val name: String,
    override val code: Int
  ) extends Codec(name, code)

object MiscellaneousCodec extends Enum[MiscellaneousCodec] {
  override lazy val values: immutable.IndexedSeq[MiscellaneousCodec] = findValues

  case object Raw extends MiscellaneousCodec("raw", 0x55)
}


/**
 * MultibaseCodec
 */
sealed abstract class MultibaseCodec(
    override val name: String,
    override val code: Int
  ) extends Codec(name, code)

object MultibaseCodec extends Enum[MultibaseCodec] {
  override lazy val values: immutable.IndexedSeq[MultibaseCodec] = findValues

  // TODO (fluency03): the following four BaseX are incorrect, to be fixed
  // TODO (fluency03): See https://github.com/multiformats/multicodec/issues/89
  case object Base1 extends MultibaseCodec("base1", 0x01)
  //  case object Base2 extends MultibaseCodec("base2", 0x00)
  case object Base8 extends MultibaseCodec("base8", 0x07)
  case object Base10 extends MultibaseCodec("base10", 0x09)

  // TODO (fluency03): The following BaseXs are disabled due to the conflicts with others.
  //  case object Base1 extends MultibaseCodec("base1", '1')
  //  case object Base2 extends MultibaseCodec("base2", '0')
  //  case object Base8 extends MultibaseCodec("base8", '7')
  //  case object Base10 extends MultibaseCodec("base10", '9')

  //  case object Base16 extends MultibaseCodec("base16", 'f')
  //  case object Base16Upper extends MultibaseCodec("base16-upper", 'F')
  //
  //  case object base32 extends MultibaseCodec("base32", 'b')
  //  case object Base32Upper extends MultibaseCodec("base32-upper", 'B')
  //  case object Base32Pad extends MultibaseCodec("base32pad", 'c')
  //  case object Base32PadUpper extends MultibaseCodec("base32pad-upper", 'C')
  //  case object Base32Hex extends MultibaseCodec("base32hex", 'v')
  //  case object Base32HexUpper extends MultibaseCodec("base32hex-upper", 'V')
  //  case object Base32HexPad extends MultibaseCodec("base32hexpad", 't')
  //  case object Base32HexPadUpper extends MultibaseCodec("base32hexpad-upper", 'T')
  //
  //  case object B58Flickr extends MultibaseCodec("base58flickr", 'Z')
  //  case object Base58BTC extends MultibaseCodec("base58btc", 'z')
  //  case object Base64 extends MultibaseCodec("base64", 'm')
  //  case object Base64Pad extends MultibaseCodec("base64pad", 'M')
  //  case object Base64URL extends MultibaseCodec("base64url", 'u')
  //  case object Base64URLPad extends MultibaseCodec("base64urlpad", 'U')
}


/**
 * SerializationCodec
 */
sealed abstract class SerializationCodec(
    override val name: String,
    override val code: Int
  ) extends Codec(name, code)

object SerializationCodec extends Enum[SerializationCodec] {
  override lazy val values: immutable.IndexedSeq[SerializationCodec] = findValues

  // serialization formats
  case object CBOR extends SerializationCodec("cbor", 0x51)
  case object Protobuf extends SerializationCodec("protobuf", 0x50)
  case object RLP extends SerializationCodec("rlp", 0x60)
  case object Bencode extends SerializationCodec("bencode", 0x63)
}


/**
 * MultiformatCodec
 */
sealed abstract class MultiformatCodec(
    override val name: String,
    override val code: Int
  ) extends Codec(name, code)

object MultiformatCodec extends Enum[MultiformatCodec] {
  override lazy val values: immutable.IndexedSeq[MultiformatCodec] = findValues

  case object Multicodec extends MultiformatCodec("multicodec", 0x30)
  case object Multihash extends MultiformatCodec("multihash", 0x31)
  case object Multiaddr extends MultiformatCodec("multiaddr", 0x32)
  case object Multibase extends MultiformatCodec("multibase", 0x33)
}


/**
 * MultihashCodec
 */
sealed abstract class MultihashCodec(
    override val name: String,
    override val code: Int
  ) extends Codec(name, code)

object MultihashCodec extends Enum[MultihashCodec] {
  override lazy val values: immutable.IndexedSeq[MultihashCodec] = findValues

  case object Identity extends MultihashCodec("identity", 0x00)
  case object MD4 extends MultihashCodec("md4", 0xd4)
  case object MD5 extends MultihashCodec("md5", 0xd5)

  case object SHA1 extends MultihashCodec("sha1", 0x11)
  case object SHA2_256 extends MultihashCodec("sha2-256", 0x12)
  case object SHA2_512 extends MultihashCodec("sha2-512", 0x13)
  case object DBL_SHA2_256 extends MultihashCodec("dbl-sha2-256", 0x56)
  case object SHA3_224 extends MultihashCodec("sha3-224", 0x17)
  case object SHA3_256 extends MultihashCodec("sha3-256", 0x16)
  case object SHA3_384 extends MultihashCodec("sha3-384", 0x15)
  case object SHA3_512 extends MultihashCodec("sha3-512", 0x14)
  case object SHAKE_128 extends MultihashCodec("shake-128", 0x18)
  case object SHAKE_256 extends MultihashCodec("shake-256", 0x19)
  case object Keccak224 extends MultihashCodec("keccak-224", 0x1A)
  case object Keccak256 extends MultihashCodec("keccak-256", 0x1B)
  case object Keccak384 extends MultihashCodec("keccak-384", 0x1C)
  case object Keccak512 extends MultihashCodec("keccak-512", 0x1D)
  case object Murmur3 extends MultihashCodec("murmur3", 0x22)
  case object X11 extends MultihashCodec("x11", 0x1100)

  case object BLAKE2b_8 extends MultihashCodec("blake2b-8", 0xb201)
  case object BLAKE2b_16 extends MultihashCodec("blake2b-16", 0xb202)
  case object BLAKE2b_24 extends MultihashCodec("blake2b-24", 0xb203)
  case object BLAKE2b_32 extends MultihashCodec("blake2b-32", 0xb204)
  case object BLAKE2b_40 extends MultihashCodec("blake2b-40", 0xb205)
  case object BLAKE2b_48 extends MultihashCodec("blake2b-48", 0xb206)
  case object BLAKE2b_56 extends MultihashCodec("blake2b-56", 0xb207)
  case object BLAKE2b_64 extends MultihashCodec("blake2b-64", 0xb208)
  case object BLAKE2b_72 extends MultihashCodec("blake2b-72", 0xb209)
  case object BLAKE2b_80 extends MultihashCodec("blake2b-80", 0xb20a)
  case object BLAKE2b_88 extends MultihashCodec("blake2b-88", 0xb20b)
  case object BLAKE2b_96 extends MultihashCodec("blake2b-96", 0xb20c)
  case object BLAKE2b_104 extends MultihashCodec("blake2b-104", 0xb20d)
  case object BLAKE2b_112 extends MultihashCodec("blake2b-112", 0xb20e)
  case object BLAKE2b_120 extends MultihashCodec("blake2b-120", 0xb20f)
  case object BLAKE2b_128 extends MultihashCodec("blake2b-128", 0xb210)
  case object BLAKE2b_136 extends MultihashCodec("blake2b-136", 0xb211)
  case object BLAKE2b_144 extends MultihashCodec("blake2b-144", 0xb212)
  case object BLAKE2b_152 extends MultihashCodec("blake2b-152", 0xb213)
  case object BLAKE2b_160 extends MultihashCodec("blake2b-160", 0xb214)
  case object BLAKE2b_168 extends MultihashCodec("blake2b-168", 0xb215)
  case object BLAKE2b_176 extends MultihashCodec("blake2b-176", 0xb216)
  case object BLAKE2b_184 extends MultihashCodec("blake2b-184", 0xb217)
  case object BLAKE2b_192 extends MultihashCodec("blake2b-192", 0xb218)
  case object BLAKE2b_200 extends MultihashCodec("blake2b-200", 0xb219)
  case object BLAKE2b_208 extends MultihashCodec("blake2b-208", 0xb21a)
  case object BLAKE2b_216 extends MultihashCodec("blake2b-216", 0xb21b)
  case object BLAKE2b_224 extends MultihashCodec("blake2b-224", 0xb21c)
  case object BLAKE2b_232 extends MultihashCodec("blake2b-232", 0xb21d)
  case object BLAKE2b_240 extends MultihashCodec("blake2b-240", 0xb21e)
  case object BLAKE2b_248 extends MultihashCodec("blake2b-248", 0xb21f)
  case object BLAKE2b_256 extends MultihashCodec("blake2b-256", 0xb220)
  case object BLAKE2b_264 extends MultihashCodec("blake2b-264", 0xb221)
  case object BLAKE2b_272 extends MultihashCodec("blake2b-272", 0xb222)
  case object BLAKE2b_280 extends MultihashCodec("blake2b-280", 0xb223)
  case object BLAKE2b_288 extends MultihashCodec("blake2b-288", 0xb224)
  case object BLAKE2b_296 extends MultihashCodec("blake2b-296", 0xb225)
  case object BLAKE2b_304 extends MultihashCodec("blake2b-304", 0xb226)
  case object BLAKE2b_312 extends MultihashCodec("blake2b-312", 0xb227)
  case object BLAKE2b_320 extends MultihashCodec("blake2b-320", 0xb228)
  case object BLAKE2b_328 extends MultihashCodec("blake2b-328", 0xb229)
  case object BLAKE2b_336 extends MultihashCodec("blake2b-336", 0xb22a)
  case object BLAKE2b_344 extends MultihashCodec("blake2b-344", 0xb22b)
  case object BLAKE2b_352 extends MultihashCodec("blake2b-352", 0xb22c)
  case object BLAKE2b_360 extends MultihashCodec("blake2b-360", 0xb22d)
  case object BLAKE2b_368 extends MultihashCodec("blake2b-368", 0xb22e)
  case object BLAKE2b_376 extends MultihashCodec("blake2b-376", 0xb22f)
  case object BLAKE2b_384 extends MultihashCodec("blake2b-384", 0xb230)
  case object BLAKE2b_392 extends MultihashCodec("blake2b-392", 0xb231)
  case object BLAKE2b_400 extends MultihashCodec("blake2b-400", 0xb232)
  case object BLAKE2b_408 extends MultihashCodec("blake2b-408", 0xb233)
  case object BLAKE2b_416 extends MultihashCodec("blake2b-416", 0xb234)
  case object BLAKE2b_424 extends MultihashCodec("blake2b-424", 0xb235)
  case object BLAKE2b_432 extends MultihashCodec("blake2b-432", 0xb236)
  case object BLAKE2b_440 extends MultihashCodec("blake2b-440", 0xb237)
  case object BLAKE2b_448 extends MultihashCodec("blake2b-448", 0xb238)
  case object BLAKE2b_456 extends MultihashCodec("blake2b-456", 0xb239)
  case object BLAKE2b_464 extends MultihashCodec("blake2b-464", 0xb23a)
  case object BLAKE2b_472 extends MultihashCodec("blake2b-472", 0xb23b)
  case object BLAKE2b_480 extends MultihashCodec("blake2b-480", 0xb23c)
  case object BLAKE2b_488 extends MultihashCodec("blake2b-488", 0xb23d)
  case object BLAKE2b_496 extends MultihashCodec("blake2b-496", 0xb23e)
  case object BLAKE2b_504 extends MultihashCodec("blake2b-504", 0xb23f)
  case object BLAKE2b_512 extends MultihashCodec("blake2b-512", 0xb240)

  case object BLAKE2s_8 extends MultihashCodec("blake2s-8", 0xb241)
  case object BLAKE2s_16 extends MultihashCodec("blake2s-16", 0xb242)
  case object BLAKE2s_24 extends MultihashCodec("blake2s-24", 0xb243)
  case object BLAKE2s_32 extends MultihashCodec("blake2s-32", 0xb244)
  case object BLAKE2s_40 extends MultihashCodec("blake2s-40", 0xb245)
  case object BLAKE2s_48 extends MultihashCodec("blake2s-48", 0xb246)
  case object BLAKE2s_56 extends MultihashCodec("blake2s-56", 0xb247)
  case object BLAKE2s_64 extends MultihashCodec("blake2s-64", 0xb248)
  case object BLAKE2s_72 extends MultihashCodec("blake2s-72", 0xb249)
  case object BLAKE2s_80 extends MultihashCodec("blake2s-80", 0xb24a)
  case object BLAKE2s_88 extends MultihashCodec("blake2s-88", 0xb24b)
  case object BLAKE2s_96 extends MultihashCodec("blake2s-96", 0xb24c)
  case object BLAKE2s_104 extends MultihashCodec("blake2s-104", 0xb24d)
  case object BLAKE2s_112 extends MultihashCodec("blake2s-112", 0xb24e)
  case object BLAKE2s_120 extends MultihashCodec("blake2s-120", 0xb24f)
  case object BLAKE2s_128 extends MultihashCodec("blake2s-128", 0xb250)
  case object BLAKE2s_136 extends MultihashCodec("blake2s-136", 0xb251)
  case object BLAKE2s_144 extends MultihashCodec("blake2s-144", 0xb252)
  case object BLAKE2s_152 extends MultihashCodec("blake2s-152", 0xb253)
  case object BLAKE2s_160 extends MultihashCodec("blake2s-160", 0xb254)
  case object BLAKE2s_168 extends MultihashCodec("blake2s-168", 0xb255)
  case object BLAKE2s_176 extends MultihashCodec("blake2s-176", 0xb256)
  case object BLAKE2s_184 extends MultihashCodec("blake2s-184", 0xb257)
  case object BLAKE2s_192 extends MultihashCodec("blake2s-192", 0xb258)
  case object BLAKE2s_200 extends MultihashCodec("blake2s-200", 0xb259)
  case object BLAKE2s_208 extends MultihashCodec("blake2s-208", 0xb25a)
  case object BLAKE2s_216 extends MultihashCodec("blake2s-216", 0xb25b)
  case object BLAKE2s_224 extends MultihashCodec("blake2s-224", 0xb25c)
  case object BLAKE2s_232 extends MultihashCodec("blake2s-232", 0xb25d)
  case object BLAKE2s_240 extends MultihashCodec("blake2s-240", 0xb25e)
  case object BLAKE2s_248 extends MultihashCodec("blake2s-248", 0xb25f)
  case object BLAKE2s_256 extends MultihashCodec("blake2s-256", 0xb260)

  case object Skein256_8 extends MultihashCodec("skein256-8", 0xb301)
  case object Skein256_16 extends MultihashCodec("skein256-16", 0xb302)
  case object Skein256_24 extends MultihashCodec("skein256-24", 0xb303)
  case object Skein256_32 extends MultihashCodec("skein256-32", 0xb304)
  case object Skein256_40 extends MultihashCodec("skein256-40", 0xb305)
  case object Skein256_48 extends MultihashCodec("skein256-48", 0xb306)
  case object Skein256_56 extends MultihashCodec("skein256-56", 0xb307)
  case object Skein256_64 extends MultihashCodec("skein256-64", 0xb308)
  case object Skein256_72 extends MultihashCodec("skein256-72", 0xb309)
  case object Skein256_80 extends MultihashCodec("skein256-80", 0xb30a)
  case object Skein256_88 extends MultihashCodec("skein256-88", 0xb30b)
  case object Skein256_96 extends MultihashCodec("skein256-96", 0xb30c)
  case object Skein256_104 extends MultihashCodec("skein256-104", 0xb30d)
  case object Skein256_112 extends MultihashCodec("skein256-112", 0xb30e)
  case object Skein256_120 extends MultihashCodec("skein256-120", 0xb30f)
  case object Skein256_128 extends MultihashCodec("skein256-128", 0xb310)
  case object Skein256_136 extends MultihashCodec("skein256-136", 0xb311)
  case object Skein256_144 extends MultihashCodec("skein256-144", 0xb312)
  case object Skein256_152 extends MultihashCodec("skein256-152", 0xb313)
  case object Skein256_160 extends MultihashCodec("skein256-160", 0xb314)
  case object Skein256_168 extends MultihashCodec("skein256-168", 0xb315)
  case object Skein256_176 extends MultihashCodec("skein256-176", 0xb316)
  case object Skein256_184 extends MultihashCodec("skein256-184", 0xb317)
  case object Skein256_192 extends MultihashCodec("skein256-192", 0xb318)
  case object Skein256_200 extends MultihashCodec("skein256-200", 0xb319)
  case object Skein256_208 extends MultihashCodec("skein256-208", 0xb31a)
  case object Skein256_216 extends MultihashCodec("skein256-216", 0xb31b)
  case object Skein256_224 extends MultihashCodec("skein256-224", 0xb31c)
  case object Skein256_232 extends MultihashCodec("skein256-232", 0xb31d)
  case object Skein256_240 extends MultihashCodec("skein256-240", 0xb31e)
  case object Skein256_248 extends MultihashCodec("skein256-248", 0xb31f)
  case object Skein256_256 extends MultihashCodec("skein256-256", 0xb320)

  case object Skein512_8 extends MultihashCodec("skein512-8", 0xb321)
  case object Skein512_16 extends MultihashCodec("skein512-16", 0xb322)
  case object Skein512_24 extends MultihashCodec("skein512-24", 0xb323)
  case object Skein512_32 extends MultihashCodec("skein512-32", 0xb324)
  case object Skein512_40 extends MultihashCodec("skein512-40", 0xb325)
  case object Skein512_48 extends MultihashCodec("skein512-48", 0xb326)
  case object Skein512_56 extends MultihashCodec("skein512-56", 0xb327)
  case object Skein512_64 extends MultihashCodec("skein512-64", 0xb328)
  case object Skein512_72 extends MultihashCodec("skein512-72", 0xb329)
  case object Skein512_80 extends MultihashCodec("skein512-80", 0xb32a)
  case object Skein512_88 extends MultihashCodec("skein512-88", 0xb32b)
  case object Skein512_96 extends MultihashCodec("skein512-96", 0xb32c)
  case object Skein512_104 extends MultihashCodec("skein512-104", 0xb32d)
  case object Skein512_112 extends MultihashCodec("skein512-112", 0xb32e)
  case object Skein512_120 extends MultihashCodec("skein512-120", 0xb32f)
  case object Skein512_128 extends MultihashCodec("skein512-128", 0xb330)
  case object Skein512_136 extends MultihashCodec("skein512-136", 0xb331)
  case object Skein512_144 extends MultihashCodec("skein512-144", 0xb332)
  case object Skein512_152 extends MultihashCodec("skein512-152", 0xb333)
  case object Skein512_160 extends MultihashCodec("skein512-160", 0xb334)
  case object Skein512_168 extends MultihashCodec("skein512-168", 0xb335)
  case object Skein512_176 extends MultihashCodec("skein512-176", 0xb336)
  case object Skein512_184 extends MultihashCodec("skein512-184", 0xb337)
  case object Skein512_192 extends MultihashCodec("skein512-192", 0xb338)
  case object Skein512_200 extends MultihashCodec("skein512-200", 0xb339)
  case object Skein512_208 extends MultihashCodec("skein512-208", 0xb33a)
  case object Skein512_216 extends MultihashCodec("skein512-216", 0xb33b)
  case object Skein512_224 extends MultihashCodec("skein512-224", 0xb33c)
  case object Skein512_232 extends MultihashCodec("skein512-232", 0xb33d)
  case object Skein512_240 extends MultihashCodec("skein512-240", 0xb33e)
  case object Skein512_248 extends MultihashCodec("skein512-248", 0xb33f)
  case object Skein512_256 extends MultihashCodec("skein512-256", 0xb340)
  case object Skein512_264 extends MultihashCodec("skein512-264", 0xb341)
  case object Skein512_272 extends MultihashCodec("skein512-272", 0xb342)
  case object Skein512_280 extends MultihashCodec("skein512-280", 0xb343)
  case object Skein512_288 extends MultihashCodec("skein512-288", 0xb344)
  case object Skein512_296 extends MultihashCodec("skein512-296", 0xb345)
  case object Skein512_304 extends MultihashCodec("skein512-304", 0xb346)
  case object Skein512_312 extends MultihashCodec("skein512-312", 0xb347)
  case object Skein512_320 extends MultihashCodec("skein512-320", 0xb348)
  case object Skein512_328 extends MultihashCodec("skein512-328", 0xb349)
  case object Skein512_336 extends MultihashCodec("skein512-336", 0xb34a)
  case object Skein512_344 extends MultihashCodec("skein512-344", 0xb34b)
  case object Skein512_352 extends MultihashCodec("skein512-352", 0xb34c)
  case object Skein512_360 extends MultihashCodec("skein512-360", 0xb34d)
  case object Skein512_368 extends MultihashCodec("skein512-368", 0xb34e)
  case object Skein512_376 extends MultihashCodec("skein512-376", 0xb34f)
  case object Skein512_384 extends MultihashCodec("skein512-384", 0xb350)
  case object Skein512_392 extends MultihashCodec("skein512-392", 0xb351)
  case object Skein512_400 extends MultihashCodec("skein512-400", 0xb352)
  case object Skein512_408 extends MultihashCodec("skein512-408", 0xb353)
  case object Skein512_416 extends MultihashCodec("skein512-416", 0xb354)
  case object Skein512_424 extends MultihashCodec("skein512-424", 0xb355)
  case object Skein512_432 extends MultihashCodec("skein512-432", 0xb356)
  case object Skein512_440 extends MultihashCodec("skein512-440", 0xb357)
  case object Skein512_448 extends MultihashCodec("skein512-448", 0xb358)
  case object Skein512_456 extends MultihashCodec("skein512-456", 0xb359)
  case object Skein512_464 extends MultihashCodec("skein512-464", 0xb35a)
  case object Skein512_472 extends MultihashCodec("skein512-472", 0xb35b)
  case object Skein512_480 extends MultihashCodec("skein512-480", 0xb35c)
  case object Skein512_488 extends MultihashCodec("skein512-488", 0xb35d)
  case object Skein512_496 extends MultihashCodec("skein512-496", 0xb35e)
  case object Skein512_504 extends MultihashCodec("skein512-504", 0xb35f)
  case object Skein512_512 extends MultihashCodec("skein512-512", 0xb360)

  case object Skein1024_8 extends MultihashCodec("skein1024-8", 0xb361)
  case object Skein1024_16 extends MultihashCodec("skein1024-16", 0xb362)
  case object Skein1024_24 extends MultihashCodec("skein1024-24", 0xb363)
  case object Skein1024_32 extends MultihashCodec("skein1024-32", 0xb364)
  case object Skein1024_40 extends MultihashCodec("skein1024-40", 0xb365)
  case object Skein1024_48 extends MultihashCodec("skein1024-48", 0xb366)
  case object Skein1024_56 extends MultihashCodec("skein1024-56", 0xb367)
  case object Skein1024_64 extends MultihashCodec("skein1024-64", 0xb368)
  case object Skein1024_72 extends MultihashCodec("skein1024-72", 0xb369)
  case object Skein1024_80 extends MultihashCodec("skein1024-80", 0xb36a)
  case object Skein1024_88 extends MultihashCodec("skein1024-88", 0xb36b)
  case object Skein1024_96 extends MultihashCodec("skein1024-96", 0xb36c)
  case object Skein1024_104 extends MultihashCodec("skein1024-104", 0xb36d)
  case object Skein1024_112 extends MultihashCodec("skein1024-112", 0xb36e)
  case object Skein1024_120 extends MultihashCodec("skein1024-120", 0xb36f)
  case object Skein1024_128 extends MultihashCodec("skein1024-128", 0xb370)
  case object Skein1024_136 extends MultihashCodec("skein1024-136", 0xb371)
  case object Skein1024_144 extends MultihashCodec("skein1024-144", 0xb372)
  case object Skein1024_152 extends MultihashCodec("skein1024-152", 0xb373)
  case object Skein1024_160 extends MultihashCodec("skein1024-160", 0xb374)
  case object Skein1024_168 extends MultihashCodec("skein1024-168", 0xb375)
  case object Skein1024_176 extends MultihashCodec("skein1024-176", 0xb376)
  case object Skein1024_184 extends MultihashCodec("skein1024-184", 0xb377)
  case object Skein1024_192 extends MultihashCodec("skein1024-192", 0xb378)
  case object Skein1024_200 extends MultihashCodec("skein1024-200", 0xb379)
  case object Skein1024_208 extends MultihashCodec("skein1024-208", 0xb37a)
  case object Skein1024_216 extends MultihashCodec("skein1024-216", 0xb37b)
  case object Skein1024_224 extends MultihashCodec("skein1024-224", 0xb37c)
  case object Skein1024_232 extends MultihashCodec("skein1024-232", 0xb37d)
  case object Skein1024_240 extends MultihashCodec("skein1024-240", 0xb37e)
  case object Skein1024_248 extends MultihashCodec("skein1024-248", 0xb37f)
  case object Skein1024_256 extends MultihashCodec("skein1024-256", 0xb380)
  case object Skein1024_264 extends MultihashCodec("skein1024-264", 0xb381)
  case object Skein1024_272 extends MultihashCodec("skein1024-272", 0xb382)
  case object Skein1024_280 extends MultihashCodec("skein1024-280", 0xb383)
  case object Skein1024_288 extends MultihashCodec("skein1024-288", 0xb384)
  case object Skein1024_296 extends MultihashCodec("skein1024-296", 0xb385)
  case object Skein1024_304 extends MultihashCodec("skein1024-304", 0xb386)
  case object Skein1024_312 extends MultihashCodec("skein1024-312", 0xb387)
  case object Skein1024_320 extends MultihashCodec("skein1024-320", 0xb388)
  case object Skein1024_328 extends MultihashCodec("skein1024-328", 0xb389)
  case object Skein1024_336 extends MultihashCodec("skein1024-336", 0xb38a)
  case object Skein1024_344 extends MultihashCodec("skein1024-344", 0xb38b)
  case object Skein1024_352 extends MultihashCodec("skein1024-352", 0xb38c)
  case object Skein1024_360 extends MultihashCodec("skein1024-360", 0xb38d)
  case object Skein1024_368 extends MultihashCodec("skein1024-368", 0xb38e)
  case object Skein1024_376 extends MultihashCodec("skein1024-376", 0xb38f)
  case object Skein1024_384 extends MultihashCodec("skein1024-384", 0xb390)
  case object Skein1024_392 extends MultihashCodec("skein1024-392", 0xb391)
  case object Skein1024_400 extends MultihashCodec("skein1024-400", 0xb392)
  case object Skein1024_408 extends MultihashCodec("skein1024-408", 0xb393)
  case object Skein1024_416 extends MultihashCodec("skein1024-416", 0xb394)
  case object Skein1024_424 extends MultihashCodec("skein1024-424", 0xb395)
  case object Skein1024_432 extends MultihashCodec("skein1024-432", 0xb396)
  case object Skein1024_440 extends MultihashCodec("skein1024-440", 0xb397)
  case object Skein1024_448 extends MultihashCodec("skein1024-448", 0xb398)
  case object Skein1024_456 extends MultihashCodec("skein1024-456", 0xb399)
  case object Skein1024_464 extends MultihashCodec("skein1024-464", 0xb39a)
  case object Skein1024_472 extends MultihashCodec("skein1024-472", 0xb39b)
  case object Skein1024_480 extends MultihashCodec("skein1024-480", 0xb39c)
  case object Skein1024_488 extends MultihashCodec("skein1024-488", 0xb39d)
  case object Skein1024_496 extends MultihashCodec("skein1024-496", 0xb39e)
  case object Skein1024_504 extends MultihashCodec("skein1024-504", 0xb39f)
  case object Skein1024_512 extends MultihashCodec("skein1024-512", 0xb3a0)
  case object Skein1024_520 extends MultihashCodec("skein1024-520", 0xb3a1)
  case object Skein1024_528 extends MultihashCodec("skein1024-528", 0xb3a2)
  case object Skein1024_536 extends MultihashCodec("skein1024-536", 0xb3a3)
  case object Skein1024_544 extends MultihashCodec("skein1024-544", 0xb3a4)
  case object Skein1024_552 extends MultihashCodec("skein1024-552", 0xb3a5)
  case object Skein1024_560 extends MultihashCodec("skein1024-560", 0xb3a6)
  case object Skein1024_568 extends MultihashCodec("skein1024-568", 0xb3a7)
  case object Skein1024_576 extends MultihashCodec("skein1024-576", 0xb3a8)
  case object Skein1024_584 extends MultihashCodec("skein1024-584", 0xb3a9)
  case object Skein1024_592 extends MultihashCodec("skein1024-592", 0xb3aa)
  case object Skein1024_600 extends MultihashCodec("skein1024-600", 0xb3ab)
  case object Skein1024_608 extends MultihashCodec("skein1024-608", 0xb3ac)
  case object Skein1024_616 extends MultihashCodec("skein1024-616", 0xb3ad)
  case object Skein1024_624 extends MultihashCodec("skein1024-624", 0xb3ae)
  case object Skein1024_632 extends MultihashCodec("skein1024-632", 0xb3af)
  case object Skein1024_640 extends MultihashCodec("skein1024-640", 0xb3b0)
  case object Skein1024_648 extends MultihashCodec("skein1024-648", 0xb3b1)
  case object Skein1024_656 extends MultihashCodec("skein1024-656", 0xb3b2)
  case object Skein1024_664 extends MultihashCodec("skein1024-664", 0xb3b3)
  case object Skein1024_672 extends MultihashCodec("skein1024-672", 0xb3b4)
  case object Skein1024_680 extends MultihashCodec("skein1024-680", 0xb3b5)
  case object Skein1024_688 extends MultihashCodec("skein1024-688", 0xb3b6)
  case object Skein1024_696 extends MultihashCodec("skein1024-696", 0xb3b7)
  case object Skein1024_704 extends MultihashCodec("skein1024-704", 0xb3b8)
  case object Skein1024_712 extends MultihashCodec("skein1024-712", 0xb3b9)
  case object Skein1024_720 extends MultihashCodec("skein1024-720", 0xb3ba)
  case object Skein1024_728 extends MultihashCodec("skein1024-728", 0xb3bb)
  case object Skein1024_736 extends MultihashCodec("skein1024-736", 0xb3bc)
  case object Skein1024_744 extends MultihashCodec("skein1024-744", 0xb3bd)
  case object Skein1024_752 extends MultihashCodec("skein1024-752", 0xb3be)
  case object Skein1024_760 extends MultihashCodec("skein1024-760", 0xb3bf)
  case object Skein1024_768 extends MultihashCodec("skein1024-768", 0xb3c0)
  case object Skein1024_776 extends MultihashCodec("skein1024-776", 0xb3c1)
  case object Skein1024_784 extends MultihashCodec("skein1024-784", 0xb3c2)
  case object Skein1024_792 extends MultihashCodec("skein1024-792", 0xb3c3)
  case object Skein1024_800 extends MultihashCodec("skein1024-800", 0xb3c4)
  case object Skein1024_808 extends MultihashCodec("skein1024-808", 0xb3c5)
  case object Skein1024_816 extends MultihashCodec("skein1024-816", 0xb3c6)
  case object Skein1024_824 extends MultihashCodec("skein1024-824", 0xb3c7)
  case object Skein1024_832 extends MultihashCodec("skein1024-832", 0xb3c8)
  case object Skein1024_840 extends MultihashCodec("skein1024-840", 0xb3c9)
  case object Skein1024_848 extends MultihashCodec("skein1024-848", 0xb3ca)
  case object Skein1024_856 extends MultihashCodec("skein1024-856", 0xb3cb)
  case object Skein1024_864 extends MultihashCodec("skein1024-864", 0xb3cc)
  case object Skein1024_872 extends MultihashCodec("skein1024-872", 0xb3cd)
  case object Skein1024_880 extends MultihashCodec("skein1024-880", 0xb3ce)
  case object Skein1024_888 extends MultihashCodec("skein1024-888", 0xb3cf)
  case object Skein1024_896 extends MultihashCodec("skein1024-896", 0xb3d0)
  case object Skein1024_904 extends MultihashCodec("skein1024-904", 0xb3d1)
  case object Skein1024_912 extends MultihashCodec("skein1024-912", 0xb3d2)
  case object Skein1024_920 extends MultihashCodec("skein1024-920", 0xb3d3)
  case object Skein1024_928 extends MultihashCodec("skein1024-928", 0xb3d4)
  case object Skein1024_936 extends MultihashCodec("skein1024-936", 0xb3d5)
  case object Skein1024_944 extends MultihashCodec("skein1024-944", 0xb3d6)
  case object Skein1024_952 extends MultihashCodec("skein1024-952", 0xb3d7)
  case object Skein1024_960 extends MultihashCodec("skein1024-960", 0xb3d8)
  case object Skein1024_968 extends MultihashCodec("skein1024-968", 0xb3d9)
  case object Skein1024_976 extends MultihashCodec("skein1024-976", 0xb3da)
  case object Skein1024_984 extends MultihashCodec("skein1024-984", 0xb3db)
  case object Skein1024_992 extends MultihashCodec("skein1024-992", 0xb3dc)
  case object Skein1024_1000 extends MultihashCodec("skein1024-1000", 0xb3dd)
  case object Skein1024_1008 extends MultihashCodec("skein1024-1008", 0xb3de)
  case object Skein1024_1016 extends MultihashCodec("skein1024-1016", 0xb3df)
  case object Skein1024_1024 extends MultihashCodec("skein1024-1024", 0xb3e0)

}

/**
 * MultiaddrCodec
 */
sealed abstract class MultiaddrCodec(
    override val name: String,
    override val code: Int
  ) extends Codec(name, code)

object MultiaddrCodec extends Enum[MultiaddrCodec] {
  override lazy val values: immutable.IndexedSeq[MultiaddrCodec] = findValues

  case object IP4 extends MultiaddrCodec("ip4", 0x04)
  case object IP6 extends MultiaddrCodec("ip6", 0x29)
  case object IP6Zone extends MultiaddrCodec("ip6zone", 0x2A)
  case object TCP extends MultiaddrCodec("tcp", 0x06)
  case object UDP extends MultiaddrCodec("udp", 0x0111)
  case object DCCP extends MultiaddrCodec("dccp", 0x21)
  case object SCTP extends MultiaddrCodec("sctp", 0x84)
  case object UDT extends MultiaddrCodec("udt", 0x012D)
  case object UTP extends MultiaddrCodec("utp", 0x012E)
  case object IPFS extends MultiaddrCodec("ipfs", 0x01A5)
  case object HTTP extends MultiaddrCodec("http", 0x01E0)
  case object HTTPS extends MultiaddrCodec("https", 0x01BB)
  case object QUIC extends MultiaddrCodec("quic", 0x01CC)
  case object WS extends MultiaddrCodec("ws", 0x01DD)
  case object Onion extends MultiaddrCodec("onion", 0x01BC)
  case object P2PCircuit extends MultiaddrCodec("p2p-circuit", 0x0122)
  case object DNS4 extends MultiaddrCodec("dns4", 0x36)
  case object DNS6 extends MultiaddrCodec("dns6", 0x37)
  case object DNSAddr extends MultiaddrCodec("dnsaddr", 0x38)
}


/**
 * ArchiveCodec
 */
sealed abstract class ArchiveCodec(
    override val name: String,
    override val code: Int
  ) extends Codec(name, code)

object ArchiveCodec extends Enum[ArchiveCodec] {
  override lazy val values: immutable.IndexedSeq[ArchiveCodec] = findValues

}


/**
 * ImageCodec
 */
sealed abstract class ImageCodec(
    override val name: String,
    override val code: Int
  ) extends Codec(name, code)

object ImageCodec extends Enum[ImageCodec] {
  override lazy val values: immutable.IndexedSeq[ImageCodec] = findValues

}


/**
 * VideoCodec
 */
sealed abstract class VideoCodec(
    override val name: String,
    override val code: Int
  ) extends Codec(name, code)

object VideoCodec extends Enum[VideoCodec] {
  override lazy val values: immutable.IndexedSeq[VideoCodec] = findValues

}


/**
 * IPLDCodec
 */
sealed abstract class IPLDCodec(
    override val name: String,
    override val code: Int
  ) extends Codec(name, code)

object IPLDCodec extends Enum[IPLDCodec] {
  override lazy val values: immutable.IndexedSeq[IPLDCodec] = findValues

  case object MerkleDAG_Protobuf extends IPLDCodec("dag-pb", 0x70)
  case object MerkleDAG_CBOR extends IPLDCodec("dag-cbor", 0x71)
  case object MerkleDAG_JSON extends IPLDCodec("dag-json", 0x129)

  case object GitRaw extends IPLDCodec("git-raw", 0x78)

  case object ETHBlock extends IPLDCodec("eth-block", 0x90)
  case object ETHBlockList extends IPLDCodec("eth-block-list", 0x91)
  case object ETHTxTrie extends IPLDCodec("eth-tx-trie", 0x92)
  case object ETHTx extends IPLDCodec("eth-tx", 0x93)
  case object ETHTxReceiptTrie extends IPLDCodec("eth-tx-receipt-trie", 0x94)
  case object ETHTxReceipt extends IPLDCodec("eth-tx-receipt", 0x95)
  case object ETHStateTrie extends IPLDCodec("eth-state-trie", 0x96)
  case object ETHAccountSnapshot extends IPLDCodec("eth-account-snapshot", 0x97)
  case object ETHStorageTrie extends IPLDCodec("eth-storage-trie", 0x98)

  case object BitcoinBlock extends IPLDCodec("bitcoin-block", 0xb0)
  case object BitcoinTx extends IPLDCodec("bitcoin-tx", 0xb1)

  case object ZcashBlock extends IPLDCodec("zcash-block", 0xc0)
  case object ZcashTx extends IPLDCodec("zcash-tx", 0xc1)

  case object StellarBlock extends IPLDCodec("stellar-block", 0xd0)
  case object StellarTx extends IPLDCodec("stellar-tx", 0xd1)

  case object DecredBlock extends IPLDCodec("decred-block", 0xe0)
  case object DecredTx extends IPLDCodec("decred-tx", 0xe1)

  case object DashBlock extends IPLDCodec("dash-block", 0xf0)
  case object DashTx extends IPLDCodec("dash-tx", 0xf1)

  case object TorrentInfo extends IPLDCodec("torrent-info", 0x7b)
  case object TorrentFile extends IPLDCodec("torrent-file", 0x7c)
  case object Ed25519Pub extends IPLDCodec("ed25519-pub", 0xed)
}

object Codec extends Enum[Codec] {
  override lazy val values: immutable.IndexedSeq[Codec] =
    MiscellaneousCodec.values ++
      MultibaseCodec.values ++
      SerializationCodec.values ++
      MultiformatCodec.values ++
      MultihashCodec.values ++
      MultiaddrCodec.values ++
      ArchiveCodec.values ++
      ImageCodec.values ++
      VideoCodec.values ++
      IPLDCodec.values

  lazy val Codes: Map[Int, Codec] = values.map(codec => codec.code -> codec).toMap

  def withCode(code: Int): Codec = Codes(code)

  def withCodeOption(code: Int): Option[Codec] = Codes.get(code)

}
