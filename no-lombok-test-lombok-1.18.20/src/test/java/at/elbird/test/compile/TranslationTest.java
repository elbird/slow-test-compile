package at.elbird.test.compile;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TranslationTest {

    @Test
    void getId() {
        final var translation = new Translation();
        assertThat(translation.getKey()).isNull();
        assertThat(translation.getLanguage()).isNull();
        assertThat(translation.getId()).isNull();

        translation.setKey("someKey");
        assertThat(translation.getId()).isNull();

        translation.setLanguage("someLanguage");
        assertThat(translation.getId())
                .isEqualTo(new TranslationId("someKey", "someLanguage"));

        translation.setKey(null);
        assertThat(translation.getId()).isNull();
    }
}