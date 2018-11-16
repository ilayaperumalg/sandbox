package org.springframework.cloud.stream.app.processor.function

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class KotlinProcessorAutoConfiguration {

    @Bean
    open fun transform(): (String) -> String {
        return { "How are you ".plus(it) }
    }
}