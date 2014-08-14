package org.problems.combinatorial.pairsOfTargetSum;

public final PairsOfTargetSums{
  private PairsOfTargetSums(){}
  
  public PairsOfTargetSum newPrinterWithSupportForDuplicates(){
    return new PairsOfTargetSumWithDuplicates();
  }
  
   public PairsOfTargetSum newPrinter(){
    return new PairsOfTargetSumWithUniqueElements();
  }
}
