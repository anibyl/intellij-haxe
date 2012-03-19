// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.haxe.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.intellij.plugins.haxe.lang.lexer.HaxeTokenTypes.*;
import com.intellij.plugins.haxe.lang.psi.*;

public class HaxeShiftOperatorImpl extends HaxePsiCompositeElementImpl implements HaxeShiftOperator {

  public HaxeShiftOperatorImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public HaxeShiftRightOperator getShiftRightOperator() {
    return findChildByClass(HaxeShiftRightOperator.class);
  }

  @Override
  @Nullable
  public HaxeUnsignedShiftRightOperator getUnsignedShiftRightOperator() {
    return findChildByClass(HaxeUnsignedShiftRightOperator.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HaxeVisitor) ((HaxeVisitor)visitor).visitShiftOperator(this);
    else super.accept(visitor);
  }

}
