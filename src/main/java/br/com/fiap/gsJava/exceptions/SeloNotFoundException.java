package br.com.fiap.gsJava.exceptions;

public class SeloNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SeloNotFoundException(Long seloId) {
        super("Selo com ID " + seloId + " não encontrado.");
    }
}
