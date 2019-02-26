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
@DisplayName("Тест счетчика ответов")
class AnswerCounterTest {
    @SpyBean
    private YamlProps props;

    @Autowired
    private AnswerCounter answerCounter;

    @Test
    @DisplayName("Тест счетчика ответов english")
    void answerCounterTest_EN() {
        props.setLocale(new Locale("en", "EN"));
        answerCounter.resetCount();
        answerCounter.setRight();
        answerCounter.setWrong();
        answerCounter.setRight();
        answerCounter.setWrong();
        answerCounter.setRight();

        Assertions.assertEquals("Your score: 3 right and 2 wrong answers. Congratulations!", answerCounter.getResult());
    }

    @Test
    @DisplayName("Тест счетчика ответов русский")
    void answerCounterTest_RU()  {
        props.setLocale(new Locale("ru", "RU"));
        answerCounter.resetCount();
        answerCounter.setRight();
        answerCounter.setWrong();
        answerCounter.setRight();
        answerCounter.setWrong();
        answerCounter.setRight();

        Assertions.assertEquals("пїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ: 3 пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅ 2 пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ. пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ!", answerCounter.getResult());
    }
}
