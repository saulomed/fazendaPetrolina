package br.lorena.fazenda;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import br.lorena.fazenda.model.Divida;
import br.lorena.fazenda.model.ParametrosConsultaDividas;
import br.lorena.fazenda.model.RespostaDividas;
import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        ParametrosConsultaDividas parametroConsulta = recuperarParametros();
        //requestDividasInscricao(parametroConsulta.getIdCliente(), "1f489e89-03a9-4ecc-a71c-4db8105fa3db");
        List<RespostaDividas> dividas = consultaTodosImoveis(parametroConsulta);
        writeToCSV(dividas);
    }

    private static List<RespostaDividas> consultaTodosImoveis(ParametrosConsultaDividas parametros) throws IOException {
        List<RespostaDividas> listaDividasCompleta = new ArrayList();
        List<String> inscricoes = parametros.getInscricoes();
        if(Objects.nonNull(inscricoes) && !inscricoes.isEmpty())
        {
            for (String inscricao: inscricoes) {
                listaDividasCompleta.add(requestDividasInscricao(parametros.getIdCliente(),inscricao));
            }
        }
        return  listaDividasCompleta;
    }

    private static ParametrosConsultaDividas recuperarParametros() throws IOException {

        Properties prop = new Properties();
        FileInputStream in = new FileInputStream( "parametros.property" );
        prop.load(in);
        ParametrosConsultaDividas consulta = new ParametrosConsultaDividas();
        consulta.setIdCliente(prop.getProperty("idCliente"));
        consulta.setInscricoes(List.of(prop.getProperty("imoveis").split(",")));
        return consulta;
    }

    public static RespostaDividas requestDividasInscricao(String idCliente, String imovel) throws IOException {
        //https://gpi03.cloud.el.com.br/ServerExec/divida/dividaclient/recuperaDividasJson?tipoPesquisa=INSCRICAO&idTipoPesquisa=1f489e89-03a9-4ecc-a71c-4db8105fa3db&idCliente=3d6adeff-3f83-4033-8b16-3f5d42fccd1a&multApp=ServerExec
        //https://gpi03.cloud.el.com.br/ServerExec/divida/dividaclient/recuperaDividasJson?tipoPesquisa=INSCRICAO&idTipoPesquisa=1f489e89-03a9-4ecc-a71c-4db8105fa3db&idCliente=1f489e89-03a9-4ecc-a71c-4db8105fa3db&multApp=ServerExec
        String urlDividas = "https://gpi03.cloud.el.com.br/ServerExec/divida/dividaclient/recuperaDividasJson?tipoPesquisa=INSCRICAO&idTipoPesquisa=%s&idCliente=%s&multApp=ServerExec";
        urlDividas = String.format(urlDividas,imovel,idCliente);
        System.out.println(urlDividas);
        URL url = new URL(String.format(urlDividas,imovel,idCliente));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(5000);
        con.setReadTimeout(15000);
        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        con.disconnect();

        System.out.println("teste: "+content.toString());
        Divida[] respostaDividas = new Gson().fromJson(content.toString(),Divida[].class);

        RespostaDividas resposta = new RespostaDividas();
        resposta.setInscricaoImovel(imovel);
        resposta.setDividas(List.of(respostaDividas));
        System.out.println(resposta);
        return resposta;
    }


    //European countries use ";" as
    //CSV separator because "," is their digit separator
    private static final String CSV_SEPARATOR = ",";
    private static void writeToCSV(List<RespostaDividas> listaRespostas)
    {
        List<Divida> listaCompleta = new ArrayList<>();
        for (RespostaDividas respostas: listaRespostas) {
            if(Objects.nonNull(respostas.getDividas()) && !respostas.getDividas().isEmpty())
            {
                listaCompleta.addAll(respostas.getDividas());
            }
        }

        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dividas.csv"), "UTF-8"));
            //criar header
            StringBuffer oneLine = new StringBuffer();
            oneLine.append("Situação");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Cód Tipo Contribuinte");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Nome Contribuinte");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Inscrição municipal");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Origem");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Ano");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Valor Total");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Multa");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("CDA Execucao");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Ano CDA Execução");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Número Processo");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("CDA Protesto");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Ano CDA Protesto");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Situação é débito");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Ação Judicial");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Protesto Cartório");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Registrado");
            oneLine.append(CSV_SEPARATOR);
            bw.write(oneLine.toString());
            bw.newLine();

            for (Divida divida : listaCompleta)
            {
                oneLine = new StringBuffer();
                oneLine.append(divida.getSituacao());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getCodigoTipoContribuinte());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getNomeContribuinte());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getInscricaoMunicipal());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getOrigem());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getAno());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getValorTotal());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getMulta());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getCertidaoExecucao());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getAnoCertidaoExecucao());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getNumeroProcesso());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getCertidaoProtesto());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getAnoCertidaoProtesto());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getSituacaoEhDebito());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getAcaoJudicial());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getProtestoCartorio());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(divida.getRegistrado());
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
}
