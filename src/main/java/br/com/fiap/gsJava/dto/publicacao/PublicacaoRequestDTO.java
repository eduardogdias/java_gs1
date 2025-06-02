package br.com.fiap.gsJava.dto.publicacao;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PublicacaoRequestDTO {

    private String titulo;
    private String descricao;
    private String imagem;
    private String cidade;
    private String estado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date data;

    private String status;
    private Long votosConfiavel;
    private Long votosFalso;

    private PublicacaoUsuarioIdDTO usuario; // ID do usuário
}