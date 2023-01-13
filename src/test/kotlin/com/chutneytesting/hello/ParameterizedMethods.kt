package com.chutneytesting.hello

import org.junit.jupiter.params.provider.Arguments
import java.util.stream.Stream

open class ParameterizedMethods {

    companion object {
        @JvmStatic
        fun campaign(): Stream<Arguments> = Stream.of(
            Arguments.of(call_a_chutney_website),
            Arguments.of(call_search_engine)
        )

        @JvmStatic
        fun environments(): Stream<Arguments> = Stream.of(
            Arguments.of(french_web),
            Arguments.of(english_web)
        )

        @JvmStatic
        fun environments_by_names(): Stream<Arguments> = Stream.of(
            Arguments.of("french_web"),
            Arguments.of("english_web")
        )
    }
}
