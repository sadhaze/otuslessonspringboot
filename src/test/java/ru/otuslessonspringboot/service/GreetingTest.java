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

import java.io.ByteArrayInputStream;
import java.util.Locale;

@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
@DisplayName("Тест приветствия")
class GreetingTest {
    @SpyBean
    private YamlProps props;

    @Autowired
    private Greeting greeting;

    @Test
    @DisplayName("Тест приветствия")
    void greetingTest_EN(){
        props.setLocale(new Locale("en", "EN"));
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
        Assertions.assertEquals("Hello, Яфамилия Яимя!", greeting.getGreeting());
    }
}
