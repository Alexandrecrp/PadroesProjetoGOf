package estruturado;

import java.util.Map;

public class GeradorArquivoPropriedadesCriptografado extends GeradorArquivo {
	
	@Override
	protected String gerarConteudo(Map<String,Object> propriedades) {
		//responsável por gerar properties
				StringBuilder propFileBuilder = new StringBuilder();
				for (String prop: propriedades.keySet()) {
					propFileBuilder.append(prop+"m"+propriedades.get(prop)+"\n");
				}
				return propFileBuilder.toString();
	}
	
	@Override
	protected byte[] processaConteudo(byte[] bytes) {
		//responsável por criptografar
				byte[] newBytes = new byte[bytes.length];
				for (int i = 0; i<bytes.length;i++) {
					newBytes[i] = (byte)((bytes[i]+10) % Byte.MAX_VALUE);
				}
				return newBytes;
	}
}
