package repositories;

import display.Language;
import display.MessageKey;
import sqlrepositories.SQLLanguageRepository;

public interface LanguageRepository {
    static String getTranslation(MessageKey messageKey, Language languageType){
        return SQLLanguageRepository.fetchTranslation(messageKey, languageType);
    }
}
