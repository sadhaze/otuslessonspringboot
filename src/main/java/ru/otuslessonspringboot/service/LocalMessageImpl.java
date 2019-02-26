package ru.otuslessonspringboot.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otuslessonspringboot.config.YamlProps;

@Service("Localiztion message service")
public class LocalMessageImpl implements LocalMessage {
    private MessageSource messageSource;
    private YamlProps props;

    public LocalMessageImpl(YamlProps props, MessageSource messageSource){
        this.messageSource = messageSource;
        this.props = props;
    }

    public String getMessage(String indexString) {
        return messageSource.getMessage(
                indexString,
                new String[] {""},
                props.getLocale());
    }

    public String getMessage(String indexString, String[] string) {
        return messageSource.getMessage(
                indexString,
                string,
                props.getLocale());
    }
}
