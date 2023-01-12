package com.chutneytesting.hello

import org.junit.jupiter.params.provider.Arguments
import java.util.stream.Stream

open class ParameterizedMethods {

    companion object {
        @JvmStatic
        fun campaign(): Stream<Arguments> = Stream.of(
            Arguments.of(call_a_website),
            Arguments.of(call_google)
        )

        @JvmStatic
        fun environments(): Stream<Arguments> = Stream.of(
            Arguments.of(CHUTNEY),
            Arguments.of(GOOGLE)
        )

        @JvmStatic
        fun environments_by_names(): Stream<Arguments> = Stream.of(
            Arguments.of("CHUTNEY"),
            Arguments.of("GOOGLE")
        )
    }
}
