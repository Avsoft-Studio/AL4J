package org.avs.core.helper.formats;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
import org.avs.core.helper.StringHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Tests Unitaires - StringHelper")
public class UnitTestStringHelper {
	
	@BeforeAll
	static void setEnvrionnement() {
		System.out.println("Initialisation de l'environnement !");
		//TODO IF NECESSARY
	}
	
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Test des proprietes de la classe")
	class UnitTestStaticProperty{
		@Test
		@Order(1)
		@DisplayName("StringHelper.Empty - verification")
		void testEmptyValue() {
			//Arrange
			//Act
			//Assert
			assertThat(StringHelper.Empty).isEmpty();
		}
		
		@Test
		@Order(2)
		@DisplayName("Test des longueurs des tables d'accent")
		void testLengthAccentTable() {
			//Arrange
			//Act
			//Assert
			assertThat(StringHelper.accents.length).isEqualTo(StringHelper.saccents.length);
		}
		
		@Test
		@Order(3) 
		@DisplayName("Verification du code SepRegex pour les methodes regex")
		void testCodeSepRegex() {
			//Arrange
			//Act
			//Assert
			assertThat(StringHelper.SepRegex).isEqualTo("SepRegex");
		}
	}
	
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Tests des methodes utilisant des Strings")
	class UnitTestMethodTakingString{
		@Order(1) 
		@ParameterizedTest
		@DisplayName("StringHelper.IsNullOrWhiteSpace - Case True")
		@NullSource @EmptySource @ValueSource( strings= {"       ", " "})
		void testIsNullOrWhiteSpace_True(String source) {
			//Arrange
			//Act
			boolean incomingResult = StringHelper.IsNullOrWhiteSpace(source);
			//Assert
			assertThat(incomingResult).isTrue();
		}
		
		@Order(2)
		@ParameterizedTest
		@DisplayName("StringHelper.IsNullOrWhiteSpace - Case False")
		@ValueSource(strings= {"  t  ", "geropge", "n g  g"})
		void testIsNullOrWhiteSpace_False(String source) {
			//Arrange
			//Act
			boolean incomingResult = StringHelper.IsNullOrWhiteSpace(source);
			//Assert
			assertThat(incomingResult).isFalse();
		}
		
		@Order(3)
		@ParameterizedTest
		@DisplayName("StringHelper.ToASCII - Case Working")
		@CsvSource({"bonjour,BONJOUR","élèmatre,ELEMATRE"})
		void testToASCII_Works(String source, String expectedResult) {
			//Arrange
			//Act
			String incomingResult = StringHelper.ToASCII(source);
			//Assert
			assertThat(incomingResult).isNotNull().isEqualTo(expectedResult);
		}
		
		@ParameterizedTest
		@Order(4) @NullSource
		@DisplayName("String.ToASCII - Exception")
		void testToASCII_Exception(String source) {
			//Arrange
			//Act
			//Assert
			assertThatThrownBy(() -> { StringHelper.ToASCII(source); }).isInstanceOf(NullPointerException.class);
			
			/*assertThrows(NullPointerException.class, () -> {
				StringHelper.ToASCII(source);
			});*/
		}
		
		@Test
		@Order(5)
		@DisplayName("String.ToASCII - Empty Value")
		void testToASCII_EmptyValue() {
			//Arrange
			//Act
			String incomingResult = StringHelper.ToASCII(StringHelper.Empty);
			//Assert
			assertThat(incomingResult).isEmpty();
		}
		
		@Test @Order(6)
		@DisplayName("StringHelper.Concat - Case using StringBuilder with default capacity")
		void testConcatWithNotInitializedStringBuilderCapacity() {
			//Arrange
			String[] values = new String[] {"Bonjour ", null, " ", "", "comment ça va ?"};
			String expectedResult = "Bonjour null comment ça va ?";
			//Act
			String incomingResult = StringHelper.concat(values);
			//Assert
			assertThat(incomingResult).isNotNull().isEqualTo(expectedResult);
		}
		
		@Test @Order(7)
		@DisplayName("StringHelper.Concat - Case using StringBuilder with given capacity")
		void testConcatWithInitializedStringBuilderCapacity() {
			//Arrange
			String[] values = new String[] {"Bonjour ", null, " ", "", "comment ça va ?"};
			String expectedResult = "Bonjour null comment ça va ?";
			//Act
			String incomingResult = StringHelper.concat(200, values);
			//Assert
			assertThat(incomingResult).isNotNull().isEqualTo(expectedResult);
		}
		
		@Test @Order(8)
		@DisplayName("StringHelper.Concat - Case using StringBuilder with given capacity")
		void testConcatWithOnly2Strings() {
			//Arrange
			String[] values = new String[] {"Bonjour ", "comment ça va ?"};
			String expectedResult = "Bonjour comment ça va ?";
			//Act
			String incomingResult = StringHelper.concat(values[0], values[1]);
			//Assert
			assertThat(incomingResult).isNotNull().isEqualTo(expectedResult);
		}
		
		@Test @Order(9)
		@DisplayName("StringHelper.Concat - Case using StringBuilder with given capacity")
		void testConcatWithOnly3Strings() {
			//Arrange
			String[] values = new String[] {"Bonjour ", "comment ça va ?", " Super et toi ?"};
			String expectedResult = "Bonjour comment ça va ? Super et toi ?";
			//Act
			String incomingResult = StringHelper.concat(values[0], values[1], values[2]);
			//Assert
			assertThat(incomingResult).isNotNull().isEqualTo(expectedResult);
		}
		
		@Order(10)
		@ParameterizedTest @NullSource @EmptySource
		@DisplayName("StringHelper.regex - Case with SepRegex")
		void testRegex_With_SepRegex(String pattern) {
			fail("Test not implement");
		}
	}
	
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Tests des methodes utilisant des charSequence")
	class UnitTestMethodTakingCharSequence{
		@Test
		@Order(1)
		@DisplayName("StringHelper.IsNull - Case True")
		void test_IsNull_True() {
			//Arrange
			//Act
			boolean incomingResult = StringHelper.IsNull(null);
			//Assert
			assertThat(incomingResult).isTrue();
		}
		
		@Order(2)
		@ParameterizedTest
		@DisplayName("StringHelper.IsNull - Case False")
		@ValueSource(strings = {" ", "ferignir"})
		void test_IsNull_False(CharSequence source) {
			//Arrange
			//Act
			boolean incomingResult = StringHelper.IsNull(source);
			//Assert
			assertThat(incomingResult).isFalse();
		}
		
		@ParameterizedTest
		@Order(3) @EmptySource @NullSource
		@DisplayName("StringHelper.IsNullOrEmpty - Case True")
		void test_IsNullOrEmpty_True(String source) {
			//Arrange
			//Act
			boolean incomingResult = StringHelper.IsNullOrEmpty(source);
			//Assert
			assertThat(incomingResult).isTrue();
		}
		
		@Order(4)
		@ParameterizedTest
		@DisplayName("StringHelper.IsNullOrEmpty - Case False")
		@ValueSource( strings = {"  ", "egege", " \t  ", "/n"})
		void testIsNullOrEmpty_False(String source) {
			//Arrange
			//Act
			boolean incomingResult = StringHelper.IsNullOrEmpty(source);
			//Assert
			assertThat(incomingResult).isFalse();
		}
	}
	
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Tests autres methodes du StringHelper")
	class UnitTestOtherStringHelperMethod{
		@Test
		@Order(1)
		@SuppressWarnings("deprecation")
		@DisplayName("StringHelper.getErrorMessage - Case Null Value")
		void testGetErrorMessage_NullValue() {
			//Arrange
			//Act
			//Assert
			assertThatThrownBy(() -> { StringHelper.getErrorMessage(null); }).isInstanceOf(NullPointerException.class);
		}
		
		@Test
		@Order(2) 
		@SuppressWarnings("null")
		@DisplayName("StringHelper.getErrorMessage - Case Worked")
		void testGetErrorMessage_CaseWorks() {
			//Arrange
			int i = 0;
			NullPointerException exception = null;
			try { String test = null; test.length(); }
			catch(NullPointerException npe) { exception = npe; }
			//Act
			@SuppressWarnings("deprecation")
			String incomingResult = StringHelper.getErrorMessage(exception);
			String[] result = incomingResult.split("\n");
			//Assert
			assertThat(incomingResult).isNotNull().isNotEmpty();
			assertThat(result).hasSameSizeAs(exception.getStackTrace());
			for(String s: result) {
				assertThat(s).isEqualTo("at " + exception.getStackTrace()[i].toString());
				i++;
			}
		}
		
		@Test
		@Order(3)
		@DisplayName("StringHelper.getExceptionMessage - Case Null Value")
		void testGetExceptionMessage_NullValue() {
			//Arrange
			//Act
			//Assert
			assertThatThrownBy(() -> { StringHelper.getExceptionMessage(null); }).isInstanceOf(NullPointerException.class);
		}
		
		@Test
		@Order(4) 
		@SuppressWarnings("null")
		@DisplayName("StringHelper.getExceptionMessage - Case Worked")
		void testGetExceptionMessage_CaseWorks() {
			//Arrange
			NullPointerException exception = null;
			try { String test = null; test.length(); }
			catch(NullPointerException npe) { exception = npe; }
			List<String> expectedResult = Arrays.asList(exception.getStackTrace()).stream().map(elt -> "at " + elt.toString()).collect(Collectors.toList()) ;
			//Act
			String incomingResult = StringHelper.getExceptionMessage(exception);
			List<String> result = Arrays.nonNullElementsIn(incomingResult.split("\r\n"));
			//Assert
			assertThat(incomingResult).isNotNull().isNotEmpty();
			//assertThat(result).contains(expectedResult.toArray());
		}
	}
}
