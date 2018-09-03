package org.molgenis.inheritance.tree;

import org.molgenis.cgd.CGDEntry;
import org.molgenis.data.annotation.makervcf.structs.GavinRecord;
import org.molgenis.inheritance.Checks;
import org.molgenis.inheritance.PedigreeUtils;
import org.molgenis.inheritance.model.Gender;
import org.molgenis.inheritance.model.Gene;
import org.molgenis.inheritance.model.Pedigree;

import java.util.List;

import static org.molgenis.cgd.CGDEntry.GeneralizedInheritance.*;

//Two parents both unaffected
public class Blue
{
	public static boolean filter(GavinRecord gavinRecord, List<GavinRecord> gavinRecordsForGene, Gene gene,
			Pedigree pedigree, boolean penetrant)
	{
		CGDEntry.GeneralizedInheritance inheritance = gene.getCgd().getGeneralizedInheritance();
		boolean result;
		if (inheritance == DOMINANT)
		{
			if (Checks.isDeNovo(gavinRecord, pedigree))
			{
				result = true;
			}
			else if (Checks.isNonPenetrant())
			{
				result = true;
			}
			else
			{
				result = IF.filter();
			}
		}
		else if (inheritance == NOTINCGD || inheritance == RECESSIVE)
		{
			if (Checks.isDeNovo(gavinRecord, pedigree))
			{
				result = true;
			}
			else if (Checks.isHomozygote(gavinRecord, pedigree.getChild()))
			{
				result = true;
			}
			else if (Checks.isHomozygote(gavinRecord, pedigree.getParents().get(0)) || Checks.isHomozygote(gavinRecord,
					pedigree.getParents().get(1)))
			{
				result = true;
			}
			else if (Checks.isCompound(gavinRecord, gavinRecordsForGene, pedigree))
			{
				result = true;
			}
			else
			{
				result = IF.filter();
			}
		}
		else if (inheritance == X_LINKED)
		{
			if (pedigree.getChild().getGender() == Gender.MALE)
			{
				if (!Checks.subjectHasVariant(gavinRecord, PedigreeUtils.getFather(pedigree)))
				{
					result = true;
				}
				else
				{
					result = IF.filter();
				}
			}
			else if (Checks.isDeNovo(gavinRecord, pedigree))
			{
				result = true;
			}
			else
			{
				result = IF.filter();
			}
		}
		else if (inheritance == DOMINANT_OR_RECESSIVE)
		{
			if (Checks.isDeNovo(gavinRecord, pedigree))
			{
				result = true;
			}
			else if (Checks.isNonPenetrant())
			{
				result = true;
			}
			else if (Checks.isHomozygote(gavinRecord, pedigree.getChild()))
			{
				result = true;
			}
			else if (Checks.isHomozygote(gavinRecord, pedigree.getParents().get(0)) || Checks.isHomozygote(gavinRecord,
					pedigree.getParents().get(1)))
			{
				result = true;
			}
			else if (Checks.isCompound(gavinRecord, gavinRecordsForGene, pedigree))
			{
				result = true;
			}
			else
			{
				result = IF.filter();
			}
		}
		else
		{
			result = IF.filter();
		}
		return result;
	}
}
