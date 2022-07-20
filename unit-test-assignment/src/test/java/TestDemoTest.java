import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



class TestDemoTest {
	
	//In TestDemoTest.java, add a private instance 
	//variable of type TestDemo named testDemo.
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
		
	
	}

	//This test asserts the different values making sure that only positive values can be added, otherwise an exception is thrown.
	
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			
		} else assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
	}
	
	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
				Arguments.arguments(2, 4, 6, false),
				Arguments.arguments(1, -2, -1, true),
				Arguments.arguments(-3, 6, 3, true),
				Arguments.arguments(-5, -5, -10, true),
				Arguments.arguments(0, 3, 3, true),
				Arguments.arguments(0, 0, 0, true),
				Arguments.arguments(4, 0, 4, true)
				);
	}

	//A test that ensures the random squared number is giving the correct result.
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	
}
