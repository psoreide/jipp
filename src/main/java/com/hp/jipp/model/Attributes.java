package com.hp.jipp.model;

import com.google.common.collect.ImmutableList;
import com.hp.jipp.encoding.AttributeType;
import com.hp.jipp.encoding.BooleanType;
import com.hp.jipp.encoding.NameCodeType;
import com.hp.jipp.encoding.RangeOfIntegerType;
import com.hp.jipp.encoding.ResolutionType;
import com.hp.jipp.encoding.StringType;
import com.hp.jipp.encoding.Tag;
import com.hp.jipp.encoding.UriType;

import java.util.List;

/** A library of attribute types as defined by RFC2911 */
public final class Attributes {

    // RFC2911 3.1.4.1 Request Operation Attributes
    // RFC2911 3.1.4.2 Response Operation Attributes

    public final static StringType AttributesCharset =
            new StringType(Tag.Charset, "attributes-charset");

    public final static StringType AttributesNaturalLanguage =
            new StringType(Tag.NaturalLanguage, "attributes-natural-language");

    // RFC2911 3.1.6 Operation Response Status Codes and Status Messages
    public final static StringType StatusMessage =
            new StringType(Tag.TextWithoutLanguage, "status-message");

    public final static StringType DetailedStatusMessage =
            new StringType(Tag.TextWithoutLanguage, "detailed-status-message");

    public final static StringType DocumentAccessError =
            new StringType(Tag.TextWithoutLanguage, "document-access-error");

    // Get-Printer-Attributes request fields

    public final static StringType RequestingUserName =
            new StringType(Tag.TextWithoutLanguage, "requesting-user-name");

    public final static UriType PrinterUri =
            new UriType(Tag.Uri, "printer-uri");

    public final static NameCodeType<Operation> OperationsSupported =
            Operation.createType("operations-supported");

    public final static StringType RequestedAttributes =
            new StringType(Tag.Keyword, "requested-attributes");


    // Get-Printer-Attributes response fields

    public final static StringType PrinterInfo =
            new StringType(Tag.TextWithoutLanguage, "printer-info");

    public final static NameCodeType<PrinterState> PrinterState =
            NameCodeType.type(com.hp.jipp.model.PrinterState.ENCODER, "printer-state");

    public final static RangeOfIntegerType CopiesSupported =
            new RangeOfIntegerType("copies-supported");

    public final static UriType PrinterIcons =
            new UriType(Tag.Uri, "printer-icons");

    public final static StringType DocumentFormatSupported =
            new StringType(Tag.MimeMediaType, "document-format-supported");

    // 3.2.1.1 Print-Job Request

    public final static StringType DocumentFormat =
            new StringType(Tag.MimeMediaType, "document-format");

    // 3.2.1.1 Print-Job Response

    public final static NameCodeType<JobState> JobState =
            NameCodeType.type(com.hp.jipp.model.JobState.ENCODER, "job-state");

    public final static UriType JobUri =
            new UriType(Tag.Uri, "job-uri");

    // 3.3.1.1 Send-Document Request
    public static BooleanType LastDocument =
            new BooleanType(Tag.BooleanValue, "last-document");

    // Others

    public final static StringType JobName =
            new StringType(Tag.TextWithoutLanguage, "job-name");

    public final static StringType DocumentName =
            new StringType(Tag.TextWithoutLanguage, "document-name");

    public final static ResolutionType PrinterResolutionDefault =
            new ResolutionType(Tag.Resolution, "printer-resolution-default");


    /** All attributes, useful when printing contents */
    public static final List<AttributeType<?>> All = ImmutableList.of(
            AttributesCharset,
            AttributesNaturalLanguage,
            DetailedStatusMessage,
            DocumentAccessError,
            DocumentName,
            JobName,
            OperationsSupported,
            PrinterInfo,
            PrinterState,
            CopiesSupported,
            PrinterUri,
            PrinterIcons,
            DocumentFormatSupported,
            RequestedAttributes,
            RequestingUserName,
            StatusMessage,
            LastDocument,
            DocumentFormat,
            JobState,
            PrinterResolutionDefault
    );
}