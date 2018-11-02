/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.stream.app.http.source.rabbit;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({org.springframework.cloud.stream.app.http.source.HttpSourceConfiguration.class,
		HttpSourceRabbitApplication.FunctionProcessorConfiguration.class })
public class HttpSourceRabbitApplication {

	@Configuration
	public static class FunctionProcessorConfiguration {

		@Bean
		public Function<String, String> upper() {
			return value -> value.toUpperCase();
		}

		@Bean
		public Function<String, String> concat() {
			return value -> "Hello "+ value;
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(HttpSourceRabbitApplication.class, args);
	}
}
