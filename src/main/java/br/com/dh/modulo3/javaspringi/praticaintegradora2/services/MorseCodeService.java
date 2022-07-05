package br.com.dh.modulo3.javaspringi.praticaintegradora2.services;

import br.com.dh.modulo3.javaspringi.praticaintegradora2.repositories.MorseCodeRepository;
import java.util.StringJoiner;

public class MorseCodeService {

    private final MorseCodeRepository repository = new MorseCodeRepository();

    public String buildMorseCodeByPhrase(String phrase) {
        phrase = phrase.toUpperCase();
        StringJoiner result = new StringJoiner("   ");
        String[] words = phrase.split("\\s+");
        for (String word: words) {
            StringBuilder wordByCodeMorse = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                Character letter = word.charAt(i);
                repository.getMorseCodes().forEach((c,s)->{
                    if (c.equals(letter)) {
                        wordByCodeMorse.append(((wordByCodeMorse.length() > 0 ) ? " " : "") + s);
                    }
                });
            }
            result.add(wordByCodeMorse.toString());
        }
        String s = result.toString();
        return s;
    }

    public String decipherMorseCode ( String morseCodes) {
        String[] morseCode = morseCodes.split("(\\s{3})");
        StringJoiner result = new StringJoiner(" ");
        for (String morse: morseCode) {
            StringBuilder word = new StringBuilder();
            String[] morseByMorse = morse.split("\\s");
            for (String bymorse: morseByMorse) {
                repository.getMorseCodes().forEach((c,s)->{
                    if (s.equals(bymorse)) {
                        word.append(c);
                    }
                });
            }
            result.add(word.toString());
        }
        String s = (result.toString()).toLowerCase();
        return s;
    }
}
