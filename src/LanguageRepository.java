public interface LanguageRepository {
    static String getTranslation(MessageKey messageKey, LanguageType languageType){
        return SQLLanguageRepository.fetchTranslation(messageKey, languageType);
    }
}
