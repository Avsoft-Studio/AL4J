package org.avs.logs;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Unitaire - Enumeration LogLevel")
public class UnitTestLogLevel {
	
	@Nested
	@DisplayName("Test des propri�t�s")
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	class UnitTestPropertyLogLevel{
		@Test @Order(1)
		@Timeout(value=100, unit=TimeUnit.MILLISECONDS)
		@DisplayName("LogLevel - Nombre d'�l�ment")
		public void test_Number_Enum() {
			fail("Not Implemented Yet !");
		}
		
		@ParameterizedTest @Order(2)
		@EnumSource(LogLevel.class)
		@Timeout(value=100, unit=TimeUnit.MILLISECONDS)
		@DisplayName("LogLevel - Not Null Values in Enum")
		public void test_Enum_NotNull_Values(LogLevel level) {
			assertTrue(Objects.nonNull(level));
		}
	}
	
	@Nested
	@DisplayName("Test des m�thodes")
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	static class UnitTestMethodLogLevel{
		static Stream<Arguments> GetCodeArguments(){
			return Stream.of(
					arguments("INFO", LogLevel.INFO),
					arguments("ERROR", LogLevel.ERROR),
					arguments("WARNING", LogLevel.WARNING),
					arguments("DEBUG", LogLevel.DEBUG)
			);
		}
		
		@ParameterizedTest @Order(1)
		@Timeout(value=100, unit=TimeUnit.MILLISECONDS)
		@DisplayName("LogLevel.getCode() - Get code associated")
		@MethodSource("GetCodeArguments")
		public void test_Get_Code(String code, LogLevel level) {
			fail("Not Implemented Yet !");
		}
	}

}
