// Copyright 2018 HP Development Company, L.P.
// SPDX-License-Identifier: MIT
//
// DO NOT MODIFY. Code is auto-generated by genTypes.py. Content taken from registry at
// https://www.iana.org/assignments/ipp-registrations/ipp-registrations.xml, updated on 2019-05-28
@file:Suppress("MaxLineLength", "WildcardImport")

package com.hp.jipp.model

import com.hp.jipp.encoding.* // ktlint-disable no-wildcard-imports

/**
 * Data object corresponding to a "input-attributes" collection as defined in:
 * [PWG5100.15](https://ftp.pwg.org/pub/pwg/candidates/cs-ippfaxout10-20131115-5100.15.pdf).
 */
@Suppress("RedundantCompanionReference", "unused")
data class InputAttributes
constructor(
    var inputAutoScaling: Boolean? = null,
    var inputAutoSkewCorrection: Boolean? = null,
    var inputBrightness: Int? = null,
    /** May contain any keyword from [InputColorMode]. */
    var inputColorMode: String? = null,
    /** May contain any keyword from [InputContentType]. */
    var inputContentType: String? = null,
    var inputContrast: Int? = null,
    /** May contain any keyword from [InputFilmScanMode]. */
    var inputFilmScanMode: String? = null,
    var inputImagesToTransfer: Int? = null,
    var inputMedia: String? = null,
    var inputOrientationRequested: Orientation? = null,
    var inputQuality: PrintQuality? = null,
    var inputResolution: Resolution? = null,
    var inputScalingHeight: Int? = null,
    var inputScalingWidth: Int? = null,
    var inputScanRegions: List<InputScanRegions>? = null,
    var inputSharpness: Int? = null,
    /** May contain any keyword from [Sides]. */
    var inputSides: String? = null,
    /** May contain any keyword from [InputSource]. */
    var inputSource: String? = null
) : AttributeCollection {

    /** Construct an empty [InputAttributes]. */
    constructor() : this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)

    /** Produce an attribute list from members. */
    override val attributes: List<Attribute<*>> by lazy {
        listOfNotNull(
            inputAutoScaling?.let { Types.inputAutoScaling.of(it) },
            inputAutoSkewCorrection?.let { Types.inputAutoSkewCorrection.of(it) },
            inputBrightness?.let { Types.inputBrightness.of(it) },
            inputColorMode?.let { Types.inputColorMode.of(it) },
            inputContentType?.let { Types.inputContentType.of(it) },
            inputContrast?.let { Types.inputContrast.of(it) },
            inputFilmScanMode?.let { Types.inputFilmScanMode.of(it) },
            inputImagesToTransfer?.let { Types.inputImagesToTransfer.of(it) },
            inputMedia?.let { Types.inputMedia.of(it) },
            inputOrientationRequested?.let { Types.inputOrientationRequested.of(it) },
            inputQuality?.let { Types.inputQuality.of(it) },
            inputResolution?.let { Types.inputResolution.of(it) },
            inputScalingHeight?.let { Types.inputScalingHeight.of(it) },
            inputScalingWidth?.let { Types.inputScalingWidth.of(it) },
            inputScanRegions?.let { Types.inputScanRegions.of(it) },
            inputSharpness?.let { Types.inputSharpness.of(it) },
            inputSides?.let { Types.inputSides.of(it) },
            inputSource?.let { Types.inputSource.of(it) }
        )
    }

    /** Type for attributes of this collection */
    class Type(override val name: String) : AttributeCollection.Type<InputAttributes>(InputAttributes)

    /** All member names as strings. */
    object Name {
        /** "input-auto-scaling" member name */
        const val inputAutoScaling = "input-auto-scaling"
        /** "input-auto-skew-correction" member name */
        const val inputAutoSkewCorrection = "input-auto-skew-correction"
        /** "input-brightness" member name */
        const val inputBrightness = "input-brightness"
        /** "input-color-mode" member name */
        const val inputColorMode = "input-color-mode"
        /** "input-content-type" member name */
        const val inputContentType = "input-content-type"
        /** "input-contrast" member name */
        const val inputContrast = "input-contrast"
        /** "input-film-scan-mode" member name */
        const val inputFilmScanMode = "input-film-scan-mode"
        /** "input-images-to-transfer" member name */
        const val inputImagesToTransfer = "input-images-to-transfer"
        /** "input-media" member name */
        const val inputMedia = "input-media"
        /** "input-orientation-requested" member name */
        const val inputOrientationRequested = "input-orientation-requested"
        /** "input-quality" member name */
        const val inputQuality = "input-quality"
        /** "input-resolution" member name */
        const val inputResolution = "input-resolution"
        /** "input-scaling-height" member name */
        const val inputScalingHeight = "input-scaling-height"
        /** "input-scaling-width" member name */
        const val inputScalingWidth = "input-scaling-width"
        /** "input-scan-regions" member name */
        const val inputScanRegions = "input-scan-regions"
        /** "input-sharpness" member name */
        const val inputSharpness = "input-sharpness"
        /** "input-sides" member name */
        const val inputSides = "input-sides"
        /** "input-source" member name */
        const val inputSource = "input-source"
    }

    /** Types for each member attribute. */
    object Types {
        val inputAutoScaling = BooleanType(Name.inputAutoScaling)
        val inputAutoSkewCorrection = BooleanType(Name.inputAutoSkewCorrection)
        val inputBrightness = IntType(Name.inputBrightness)
        val inputColorMode = KeywordType(Name.inputColorMode)
        val inputContentType = KeywordType(Name.inputContentType)
        val inputContrast = IntType(Name.inputContrast)
        val inputFilmScanMode = KeywordType(Name.inputFilmScanMode)
        val inputImagesToTransfer = IntType(Name.inputImagesToTransfer)
        val inputMedia = KeywordType(Name.inputMedia)
        /**
         * "input-orientation-requested" member type.
         */
        val inputOrientationRequested = Orientation.Type(Name.inputOrientationRequested)
        /**
         * "input-quality" member type.
         */
        val inputQuality = PrintQuality.Type(Name.inputQuality)
        val inputResolution = ResolutionType(Name.inputResolution)
        val inputScalingHeight = IntType(Name.inputScalingHeight)
        val inputScalingWidth = IntType(Name.inputScalingWidth)
        val inputScanRegions = InputScanRegions.Type(Name.inputScanRegions)
        val inputSharpness = IntType(Name.inputSharpness)
        val inputSides = KeywordType(Name.inputSides)
        val inputSource = KeywordType(Name.inputSource)
    }

    /** Defines types for each member of [InputAttributes] */
    companion object : AttributeCollection.Converter<InputAttributes> {
        override fun convert(attributes: List<Attribute<*>>): InputAttributes =
            InputAttributes(
                extractOne(attributes, Types.inputAutoScaling),
                extractOne(attributes, Types.inputAutoSkewCorrection),
                extractOne(attributes, Types.inputBrightness),
                extractOne(attributes, Types.inputColorMode),
                extractOne(attributes, Types.inputContentType),
                extractOne(attributes, Types.inputContrast),
                extractOne(attributes, Types.inputFilmScanMode),
                extractOne(attributes, Types.inputImagesToTransfer),
                extractOne(attributes, Types.inputMedia),
                extractOne(attributes, Types.inputOrientationRequested),
                extractOne(attributes, Types.inputQuality),
                extractOne(attributes, Types.inputResolution),
                extractOne(attributes, Types.inputScalingHeight),
                extractOne(attributes, Types.inputScalingWidth),
                extractAll(attributes, Types.inputScanRegions),
                extractOne(attributes, Types.inputSharpness),
                extractOne(attributes, Types.inputSides),
                extractOne(attributes, Types.inputSource)
            )
    }

    /**
     * Data object corresponding to a "input-scan-regions" collection.
     */
    @Suppress("RedundantCompanionReference", "unused")
    data class InputScanRegions
    constructor(
        var xDimension: Int? = null,
        var xOrigin: Int? = null,
        var yDimension: Int? = null,
        var yOrigin: Int? = null
    ) : AttributeCollection {

        /** Construct an empty [InputScanRegions]. */
        constructor() : this(null, null, null, null)

        /** Produce an attribute list from members. */
        override val attributes: List<Attribute<*>> by lazy {
            listOfNotNull(
                xDimension?.let { Types.xDimension.of(it) },
                xOrigin?.let { Types.xOrigin.of(it) },
                yDimension?.let { Types.yDimension.of(it) },
                yOrigin?.let { Types.yOrigin.of(it) }
            )
        }

        /** Type for attributes of this collection */
        class Type(override val name: String) : AttributeCollection.Type<InputScanRegions>(InputScanRegions)

        /** All member names as strings. */
        object Name {
            /** "x-dimension" member name */
            const val xDimension = "x-dimension"
            /** "x-origin" member name */
            const val xOrigin = "x-origin"
            /** "y-dimension" member name */
            const val yDimension = "y-dimension"
            /** "y-origin" member name */
            const val yOrigin = "y-origin"
        }

        /** Types for each member attribute. */
        object Types {
            val xDimension = IntType(Name.xDimension)
            val xOrigin = IntType(Name.xOrigin)
            val yDimension = IntType(Name.yDimension)
            val yOrigin = IntType(Name.yOrigin)
        }

        /** Defines types for each member of [InputScanRegions] */
        companion object : AttributeCollection.Converter<InputScanRegions> {
            override fun convert(attributes: List<Attribute<*>>): InputScanRegions =
                InputScanRegions(
                    extractOne(attributes, Types.xDimension),
                    extractOne(attributes, Types.xOrigin),
                    extractOne(attributes, Types.yDimension),
                    extractOne(attributes, Types.yOrigin)
                )
        }
    }
}
