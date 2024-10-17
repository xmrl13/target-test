package md;

import java.io.InputStream;
import org.json.JSONArray;
import java.nio.charset.StandardCharsets;

public class FaturamentoDistribuidora {

    public static void main(String[] args) {
        try {

            InputStream is = FaturamentoDistribuidora.class.getClassLoader().getResourceAsStream("dados.json");
            if (is == null) {
                System.out.println("Arquivo dados.json não encontrado.");
                return;
            }

            String content = new String(is.readAllBytes(), StandardCharsets.UTF_8);

            JSONArray faturamentoArray = new JSONArray(content);

            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0.0;
            int diasComFaturamento = 0;
            int diasAcimaDaMedia = 0;

            for (int i = 0; i < faturamentoArray.length(); i++) {
                double valor = faturamentoArray.getJSONObject(i).getDouble("valor");
                if (valor > 0) {
                    if (valor < menorFaturamento) {
                        menorFaturamento = valor;
                    }
                    if (valor > maiorFaturamento) {
                        maiorFaturamento = valor;
                    }
                    somaFaturamento += valor;
                    diasComFaturamento++;
                }
            }

            double mediaMensal = somaFaturamento / diasComFaturamento;

            for (int i = 0; i < faturamentoArray.length(); i++) {
                double valor = faturamentoArray.getJSONObject(i).getDouble("valor");
                if (valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.println("Menor faturamento: " + menorFaturamento);
            System.out.println("Maior faturamento: " + maiorFaturamento);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
