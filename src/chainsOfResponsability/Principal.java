package chainsOfResponsability;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Principal {
	//gerador do arquivo principal
	public static void main(String[] args) throws IOException {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("nome", "Leonam");
		mapa.put("idade", 32);
		
		Processador processaCompactado = new ProcessaCompactado();
		Processador processaCriptografado = new ProcessaCriptografado(processaCompactado);
		
		GeradorArquivo gerador = new GeradorArquivoPropriedades(processaCriptografado);
		gerador.gerarArquivo("c:\\Gerador\\prop1.zip", mapa);


	}

}
