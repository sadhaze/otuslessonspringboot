package ru.otuslessonspringboot.service;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import ru.otuslessonspringboot.config.YamlProps;

@Service("Localiztion message service")
public class LocalMessageImpl implements LocalMessage {
    private MessageSource messageSource;
    private YamlProps props;

    public LocalMessageImpl(YamlProps props){
        this.setMessageSource(props);
        this.props = props;
    }

    private void setMessageSource(YamlProps props){
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename(props.getMessageSourceBasename());
        ms.setDefaultEncoding(props.getMessageSourceEncoding());
        this.messageSource = ms;
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
