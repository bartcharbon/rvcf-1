package org.molgenis.data.annotation.makervcf.structs;

import org.molgenis.cgd.CGDEntry;
import org.molgenis.data.Entity;
import org.molgenis.data.annotation.entity.impl.gavin.Judgment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joeri on 6/13/16.
 */
public class RelevantVariant
{
    VcfEntity variant;
    Judgment gavinJudgment;
    Judgment clinvarJudgment;
    String allele;
    String gene;
    Map<String, String> sampleStatus;
    double alleleFreq;
    String transcript;

    CGDEntry cgdInfo;

    public RelevantVariant(VcfEntity variant, String allele, String transcript, double alleleFreq, String gene, Judgment gavinJudgment, Judgment clinvarJudgment)
    {
        this.variant = variant;
        this.allele = allele;
        this.transcript = transcript;
        this.alleleFreq = alleleFreq;
        this.gene = gene;
        this.gavinJudgment = gavinJudgment;
        this.clinvarJudgment = clinvarJudgment;
    }

    public String getAllele() {
        return allele;
    }

    public String getGene() {
        return gene;
    }

    public double getAlleleFreq() {
        return alleleFreq;
    }

    public String getTranscript() {
        return transcript != null ? transcript : "";
    }

    public VcfEntity getVariant() {
        return variant;
    }

    public Judgment getGavinJudgment() {
        return gavinJudgment;
    }

    public Judgment getClinvarJudgment() {
        return clinvarJudgment;
    }

    @Override
    public String toString() {
        return "RelevantVariant{" +
                "variant=" + variant +
                ", gavinJudgment=" + gavinJudgment +
                ", clinvarPathoMatch=" + clinvarJudgment +
                '}';
    }

    public CGDEntry getCgdInfo() {
        return cgdInfo;
    }

    public void setCgdInfo(CGDEntry cgdInfo) {
        this.cgdInfo = cgdInfo;
    }

    public Map<String, String> getSampleStatus() {
        return sampleStatus != null ? sampleStatus : new HashMap<String, String>();
    }

    public void setSampleStatus(Map<String, String> sampleStatus) {
        this.sampleStatus = sampleStatus;
    }
}