package br.lorena.fazenda.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * {
 *     "idDiv": "67fda7b4-2548-46cb-b8bc-91807e3f5ae2",
 *     "situacaoCodigo": 1,
 *     "situacao": "Débito",
 *     "codigoTipoContribuinte": "01",
 *     "nomeContribuinte": "JOSE REGINALDO GUIMARAES BORGES",
 *     "inscricaoMunicipal": "010101103220001",
 *     "origem": "IPTU",
 *     "ano": 2021,
 *     "codigoInscricaoDivida": 42227,
 *     "dataIncricao": "Jan 9, 2022 12:00:00 AM",
 *     "vencimentoAtual": "Jan 31, 2022 12:00:00 AM",
 *     "valorOrigem": 6004.3,
 *     "multa": 664.91,
 *     "juros": 598.42,
 *     "correcao": 644.79,
 *     "valorTotal": 7912.42,
 *     "situacaoEhDebito": "S",
 *     "documentoContribuintePessoa": "052.773.454-34",
 *     "idCalculoOrigem": "5e7bc7ed-a271-46b7-b11c-78a2f55c6c02",
 *     "parcelas": "99",
 *     "contribuinteId": "1f489e89-03a9-4ecc-a71c-4db8105fa3db",
 *     "meses": "5",
 *     "acaoJudicial": "N",
 *     "protestoCartorio": "N",
 *     "registrado": "Não",
 *     "numeroProcesso": "",
 *     "certidaoExecucao": 26495,
 *         "anoCertidaoExecucao": 2009,
 *         "certidaoProtesto": 10,
 *         "anoCertidaoProtesto": 2022,
 *
 *         StringBuffer oneLine = new StringBuffer();
 *             oneLine.append("Situcao");
 *             oneLine.append(CSV_SEPARATOR);
 *             oneLine.append("codigoTipoContribuinte");
 *             oneLine.append(CSV_SEPARATOR);
 *             oneLine.append("nomeContribuinte");
 *             oneLine.append(CSV_SEPARATOR);
 *             oneLine.append("inscricaoMunicipal");
 *             oneLine.append(CSV_SEPARATOR);
 *             oneLine.append("origem");
 *             oneLine.append(CSV_SEPARATOR);
 *             oneLine.append("ano");
 *             oneLine.append(CSV_SEPARATOR);
 *             oneLine.append("valorTotal");
 *             oneLine.append(CSV_SEPARATOR);
 *             oneLine.append("multa");
 *             oneLine.append(CSV_SEPARATOR);
 *             oneLine.append("certidaoExecucao");
 *             oneLine.append(CSV_SEPARATOR);
 *             oneLine.append("anoCertidaoExecucao");
 *             oneLine.append(CSV_SEPARATOR);
 *             oneLine.append("certidaoProtesto");
 *             oneLine.append(CSV_SEPARATOR);
 *             oneLine.append("anoCertidaoProtesto");
 *             oneLine.append(CSV_SEPARATOR);
 *             oneLine.append("situacaoEhDebito");
 *             oneLine.append(CSV_SEPARATOR);
 *             oneLine.append("acaoJudicial");
 *             oneLine.append(CSV_SEPARATOR);
 *             oneLine.append("protestoCartorio");
 *             oneLine.append(CSV_SEPARATOR);
 *             oneLine.append("registrado");
 *             oneLine.append(CSV_SEPARATOR);
 *             bw.write(oneLine.toString());
 *             bw.newLine();
 * }
 */


public class Divida implements Serializable {


    private static final long serialVersionUID = -3162805379169845366L;
    private String idDiv;
    private Integer situacaoCodigo;
    private String situacao;
    private String codigoTipoContribuinte;
    private String nomeContribuinte;
    private String inscricaoMunicipal;
    private String origem;
    private Integer ano;
    private Integer codigoInscricaoDivida;
    private String dataIncricao;
    private String vencimentoAtual;
    private BigDecimal valorOrigem;
    private BigDecimal multa;
    private BigDecimal juros;
    private BigDecimal correcao;
    private BigDecimal valorTotal;
    private String situacaoEhDebito;
    private String documentoContribuintePessoa;
    private String idCalculoOrigem;
    private String parcelas;
    private String contribuinteId;
    private String meses;
    private String acaoJudicial;
    private String protestoCartorio;
    private String registrado;
    private String numeroProcesso;
    private Integer certidaoExecucao;
    private Integer anoCertidaoExecucao;
    private Integer certidaoProtesto;
    private Integer anoCertidaoProtesto;

    public String getIdDiv() {
        return idDiv;
    }

    public void setIdDiv(String idDiv) {
        this.idDiv = idDiv;
    }

    public Integer getSituacaoCodigo() {
        return situacaoCodigo;
    }

    public void setSituacaoCodigo(Integer situacaoCodigo) {
        this.situacaoCodigo = situacaoCodigo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getCodigoTipoContribuinte() {
        return codigoTipoContribuinte;
    }

    public void setCodigoTipoContribuinte(String codigoTipoContribuinte) {
        this.codigoTipoContribuinte = codigoTipoContribuinte;
    }

    public String getNomeContribuinte() {
        return nomeContribuinte;
    }

    public void setNomeContribuinte(String nomeContribuinte) {
        this.nomeContribuinte = nomeContribuinte;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getCodigoInscricaoDivida() {
        return codigoInscricaoDivida;
    }

    public void setCodigoInscricaoDivida(Integer codigoInscricaoDivida) {
        this.codigoInscricaoDivida = codigoInscricaoDivida;
    }

    public String getDataIncricao() {
        return dataIncricao;
    }

    public void setDataIncricao(String dataIncricao) {
        this.dataIncricao = dataIncricao;
    }

    public String getVencimentoAtual() {
        return vencimentoAtual;
    }

    public void setVencimentoAtual(String vencimentoAtual) {
        this.vencimentoAtual = vencimentoAtual;
    }

    public BigDecimal getValorOrigem() {
        return valorOrigem;
    }

    public void setValorOrigem(BigDecimal valorOrigem) {
        this.valorOrigem = valorOrigem;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public BigDecimal getJuros() {
        return juros;
    }

    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    public BigDecimal getCorrecao() {
        return correcao;
    }

    public void setCorrecao(BigDecimal correcao) {
        this.correcao = correcao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getSituacaoEhDebito() {
        return situacaoEhDebito;
    }

    public void setSituacaoEhDebito(String situacaoEhDebito) {
        this.situacaoEhDebito = situacaoEhDebito;
    }

    public String getDocumentoContribuintePessoa() {
        return documentoContribuintePessoa;
    }

    public void setDocumentoContribuintePessoa(String documentoContribuintePessoa) {
        this.documentoContribuintePessoa = documentoContribuintePessoa;
    }

    public String getIdCalculoOrigem() {
        return idCalculoOrigem;
    }

    public void setIdCalculoOrigem(String idCalculoOrigem) {
        this.idCalculoOrigem = idCalculoOrigem;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    public String getContribuinteId() {
        return contribuinteId;
    }

    public void setContribuinteId(String contribuinteId) {
        this.contribuinteId = contribuinteId;
    }

    public String getMeses() {
        return meses;
    }

    public void setMeses(String meses) {
        this.meses = meses;
    }

    public String getAcaoJudicial() {
        return acaoJudicial;
    }

    public void setAcaoJudicial(String acaoJudicial) {
        this.acaoJudicial = acaoJudicial;
    }

    public String getProtestoCartorio() {
        return protestoCartorio;
    }

    public void setProtestoCartorio(String protestoCartorio) {
        this.protestoCartorio = protestoCartorio;
    }

    public String getRegistrado() {
        return registrado;
    }

    public void setRegistrado(String registrado) {
        this.registrado = registrado;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public Integer getCertidaoExecucao() {
        return certidaoExecucao;
    }

    public void setCertidaoExecucao(Integer certidaoExecucao) {
        this.certidaoExecucao = certidaoExecucao;
    }

    public Integer getAnoCertidaoExecucao() {
        return anoCertidaoExecucao;
    }

    public void setAnoCertidaoExecucao(Integer anoCertidaoExecucao) {
        this.anoCertidaoExecucao = anoCertidaoExecucao;
    }

    public Integer getCertidaoProtesto() {
        return certidaoProtesto;
    }

    public void setCertidaoProtesto(Integer certidaoProtesto) {
        this.certidaoProtesto = certidaoProtesto;
    }

    public Integer getAnoCertidaoProtesto() {
        return anoCertidaoProtesto;
    }

    public void setAnoCertidaoProtesto(Integer anoCertidaoProtesto) {
        this.anoCertidaoProtesto = anoCertidaoProtesto;
    }

    @Override
    public String toString() {
        return "Divida{" +
                "idDiv='" + idDiv + '\'' +
                ", situacaoCodigo=" + situacaoCodigo +
                ", situacao='" + situacao + '\'' +
                ", codigoTipoContribuinte='" + codigoTipoContribuinte + '\'' +
                ", nomeContribuinte='" + nomeContribuinte + '\'' +
                ", inscricaoMunicipal='" + inscricaoMunicipal + '\'' +
                ", origem='" + origem + '\'' +
                ", ano=" + ano +
                ", codigoInscricaoDivida=" + codigoInscricaoDivida +
                ", dataIncricao='" + dataIncricao + '\'' +
                ", vencimentoAtual='" + vencimentoAtual + '\'' +
                ", valorOrigem=" + valorOrigem +
                ", multa=" + multa +
                ", juros=" + juros +
                ", correcao=" + correcao +
                ", valorTotal=" + valorTotal +
                ", situacaoEhDebito='" + situacaoEhDebito + '\'' +
                ", documentoContribuintePessoa='" + documentoContribuintePessoa + '\'' +
                ", idCalculoOrigem='" + idCalculoOrigem + '\'' +
                ", parcelas='" + parcelas + '\'' +
                ", contribuinteId='" + contribuinteId + '\'' +
                ", meses='" + meses + '\'' +
                ", acaoJudicial='" + acaoJudicial + '\'' +
                ", protestoCartorio='" + protestoCartorio + '\'' +
                ", registrado='" + registrado + '\'' +
                ", numeroProcesso='" + numeroProcesso + '\'' +
                '}';
    }
}
