package ru.otuslessonspringboot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import ru.otuslessonspringboot.config.YamlProps;

import java.util.Locale;

@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
@DisplayName("Тест локализации")
class LocalMessageTest {
    @SpyBean
    private YamlProps props;

    @Autowired
    private LocalMessage localMessage;

    @Test
    @DisplayName("Тест русской локали")
    void LocaleTestRu() {
        props.setLocale(new Locale("ru", "RU"));
        Assertions.assertEquals("пїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ: 2 пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅ 3 пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ. пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ!", localMessage.getMessage("counter.result", new String[]{"2", "3"}));
    }

    @Test
    @DisplayName("Тест английской локали")
    void LocaleTestEn() {
        props.setLocale(new Locale("en", "EN"));
        Assertions.assertEquals("Your score: 2 right and 3 wrong answers. Congratulations!", localMessage.getMessage("counter.result", new String[]{"2", "3"}));
    }

}
