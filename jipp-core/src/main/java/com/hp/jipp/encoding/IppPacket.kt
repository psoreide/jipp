// Copyright 2017 HP Development Company, L.P.
// SPDX-License-Identifier: MIT

package com.hp.jipp.encoding

import com.hp.jipp.model.Operation
import com.hp.jipp.model.Status
import com.hp.jipp.util.PrettyPrinter
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

/**
 * An IPP packet consisting of header information and zero or more attribute groups.
 */
@Suppress("TooManyFunctions")
data class IppPacket constructor(
    val versionNumber: Int = DEFAULT_VERSION_NUMBER,
    val code: Int,
    val requestId: Int,
    val attributeGroups: List<AttributeGroup> = listOf()
) {
    @JvmOverloads
    constructor(
        versionNumber: Int = DEFAULT_VERSION_NUMBER,
        code: Int,
        requestId: Int,
        vararg groups: AttributeGroup
    ) : this(versionNumber, code, requestId, groups.toList())

    constructor(status: Status, requestId: Int, vararg groups: AttributeGroup) :
        this(code = status.code, requestId = requestId, attributeGroups = groups.toList())

    constructor(operation: Operation, requestId: Int, vararg groups: AttributeGroup) :
        this(code = operation.code, requestId = requestId, attributeGroups = groups.toList())

    /** Return this response packet's code as a [Status]. */
    val status: Status by lazy {
        Status[code]
    }

    /** Return this request packet's code as an [Operation] */
    val operation: Operation by lazy {
        Operation[code]
    }

    /** Get the attribute group having a delimiter */
    operator fun get(groupDelimiter: Tag): AttributeGroup? =
        attributeGroups.firstOrNull { it.tag == groupDelimiter }

    /** Return all values found within the specified group and having the same attribute type */
    fun <T : Any> getValues(groupDelimiter: Tag, type: AttributeType<T>): List<T> =
        this[groupDelimiter]?.get(type) ?: listOf()

    /** Return the first value within the group of [groupDelimiter] and [type]. */
    fun <T : Any> getValue(groupDelimiter: Tag, type: AttributeType<T>): T? =
        this[groupDelimiter]?.get(type)?.get(0)

    /** Return the string form of any attribute values within the group of [groupDelimiter] and [type]. */
    fun <T : Any> getStrings(groupDelimiter: Tag, type: AttributeType<T>): List<String> =
        this[groupDelimiter]?.getStrings(type) ?: listOf()

    /** Return the string form of the first attribute value within the group of [groupDelimiter] and [type]. */
    fun <T : Any> getString(groupDelimiter: Tag, type: AttributeType<T>): String? =
        this[groupDelimiter]?.getString(type)

    /** Make a copy of this packet but replace with the supplied attribute groups */
    fun withAttributeGroups(attributeGroups: List<AttributeGroup>): IppPacket =
        copy(attributeGroups = attributeGroups)

    /** Write this packet to the [OutputStream] as per RFC2910.  */
    @Throws(IOException::class)
    fun write(output: OutputStream) {
        val ippOutput = IppOutputStream(output)
        ippOutput.writeShort(versionNumber)
        ippOutput.writeShort(code)
        ippOutput.writeInt(requestId)
        attributeGroups.forEach { it.write(ippOutput) }
        Tag.endOfAttributes.write(ippOutput)
    }

    /** Return a pretty-printed version of this packet (including separators and line breaks) */
    fun prettyPrint(maxWidth: Int, indent: String) = PrettyPrinter(prefix(), PrettyPrinter.OBJECT, indent, maxWidth)
        .addAll(attributeGroups)
        .print()

    private fun prefix(): String {
        return "IppPacket(v=0x" + Integer.toHexString(versionNumber) +
            ", c=" + statusOrOperationString(code) +
            ", r=0x" + Integer.toHexString(requestId) +
            ")"
    }

    private fun statusOrOperationString(code: Int) =
        (Operation.all[code] ?: Status.all[code] ?: code).toString()

    override fun toString(): String {
        return prefix() + " " + attributeGroups
    }

    companion object {
        /** Default version number for IPP packets (0x200 for IPP 2.0) */
        const val DEFAULT_VERSION_NUMBER = 0x0200

        @JvmStatic
        @Throws(IOException::class)
        @Deprecated("use IppInputStream.readPacket()",
            ReplaceWith("readPacket()", "com.hp.jipp.encoding.IppInputStream"))
        fun parse(input: InputStream): IppPacket =
            (input as? IppInputStream ?: IppInputStream(input)).readPacket()

        @JvmStatic
        @Throws(IOException::class)
        @Deprecated("use IppInputStream.readPacket()",
            ReplaceWith("readPacket()", "com.hp.jipp.encoding.IppInputStream"))
        fun read(input: InputStream) =
            (input as? IppInputStream ?: IppInputStream(input)).readPacket()
    }
}
