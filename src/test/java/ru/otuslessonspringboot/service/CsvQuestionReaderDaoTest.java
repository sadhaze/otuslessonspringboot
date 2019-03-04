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

@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
@DisplayName("Тест файлридера")
class CsvQuestionReaderDaoTest {
    @SpyBean
    private YamlProps props;

    @Autowired
    private CsvQuestionReaderDao fileReader;

    @Test
    @DisplayName("Тест файлридера")
    void FileReaderTest() {
        fileReader.readFile("quizDatafile_en_EN.csv");
        Assertions.assertEquals("How much will 0*0?", fileReader.getQuestion(3));
    }
}
