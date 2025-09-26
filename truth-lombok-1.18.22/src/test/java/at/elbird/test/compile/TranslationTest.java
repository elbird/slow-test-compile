package at.elbird.test.compile;

import lombok.val;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class TranslationTest {

    @Test
    void getId() {
        val translation = new Translation();
        assertThat(translation.getKey()).isNull();
        assertThat(translation.getLanguage()).isNull();
        assertThat(translation.getId()).isNull();

        translation.setKey("someKey");
        assertThat(translation.getId()).isNull();

        translation.setLanguage("someLanguage");
        assertThat(translation.getId())
                .isEqualTo(new TranslationId("someKey", "someLanguage"));

        translation.setKey(null);
        assertThat(translation.getId()).isNotNull();
    }
}