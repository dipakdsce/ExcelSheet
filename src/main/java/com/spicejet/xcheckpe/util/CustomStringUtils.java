package com.spicejet.xcheckpe.util;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

public final class CustomStringUtils {

    public static final Predicate<String> isBlank = StringUtils::isBlank;
    public static final Predicate<String> isNonBlank = isBlank.negate();

}
