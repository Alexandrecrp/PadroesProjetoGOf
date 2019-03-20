package estruturado;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GeradorArquivo {
	
	public final void gerarArquivo(String nome, Map<String,Object> propriedades, String tipo) throws IOException {
		byte[] bytes = null;
		if (tipo.equals("PROPRIEDADES_CRIPTOGRAFADO")) {
			ProcessaPropriedadesCriptografado propCript = new ProcessaPropriedadesCriptografado();
			bytes = propCript.processaPropriedadesCriptografado(propriedades);
		} else if (tipo.equals("XML_COMPACTADO")) {
			ProcessaXmlCompactado xml = new ProcessaXmlCompactado();
			bytes = xml.processaXmlCompactado(propriedades);
		} else {
			System.out.println("Desconheço essa opção");
		}
		FileOutputStream fileout = new FileOutputStream(nome);
		fileout.write(bytes);
		fileout.close();
	}


}
