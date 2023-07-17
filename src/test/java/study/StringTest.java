package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] splited = "1,2".split(",");
        assertThat(splited).contains("1");
        assertThat(splited).contains("2");

        String[] splitedOneElement = "1".split(",");
        assertThat(splitedOneElement).containsExactly("1");
    }

    @Test
    void substring() {
        String org = "(1,2)";
        String actual = org.substring(1, org.length()-1);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("주어진 문자열의 크기를 벗어나는 인덱스로 String.charAt() 연산 수행시, StringIndexOutOfBoundsException 발생한다.")
    @Test
    void throwStringIndexOutOfBoundsException() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range: 3");
    }
}
