package br.com.dh.modulo3.javaspringi.praticaintegradora2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CodeMorseDTO {
    private String naturalPhrase;
    private String codeMorsePhrase;
}
