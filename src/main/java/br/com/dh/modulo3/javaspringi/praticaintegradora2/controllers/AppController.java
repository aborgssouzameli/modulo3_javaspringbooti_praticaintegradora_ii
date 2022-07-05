package br.com.dh.modulo3.javaspringi.praticaintegradora2.controllers;

import br.com.dh.modulo3.javaspringi.praticaintegradora2.dto.CodeMorseDTO;
import br.com.dh.modulo3.javaspringi.praticaintegradora2.services.MorseCodeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class AppController {

    private MorseCodeService morseCodeService = new MorseCodeService();

    @PostMapping("/convert-natural-phrase-to-morse-code")
    public ResponseEntity<CodeMorseDTO> buildMorseCode(@RequestBody CodeMorseDTO codeMorseDTO) {
        String morseCodePhrase = morseCodeService.buildMorseCodeByPhrase(codeMorseDTO.getNaturalPhrase());
        codeMorseDTO.setCodeMorsePhrase(morseCodePhrase);
        return ResponseEntity.ok(codeMorseDTO);
    }

    @PostMapping("/decipher-morse-code")
    ResponseEntity<CodeMorseDTO> decipherMorseCode(@RequestBody CodeMorseDTO codeMorseDTO) {
        String naturalPhrase = morseCodeService.decipherMorseCode(codeMorseDTO.getCodeMorsePhrase());
        codeMorseDTO.setNaturalPhrase(naturalPhrase);
        return ResponseEntity.ok(codeMorseDTO);
    }
}
