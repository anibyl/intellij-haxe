// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.haxe.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaxeIfStatement extends HaxePsiCompositeElement {

  @NotNull
  List<HaxeBlockStatement> getBlockStatementList();

  @NotNull
  List<HaxeBreakStatement> getBreakStatementList();

  @NotNull
  List<HaxeCaseStatement> getCaseStatementList();

  @NotNull
  List<HaxeContinueStatement> getContinueStatementList();

  @NotNull
  List<HaxeDefaultStatement> getDefaultStatementList();

  @NotNull
  List<HaxeDoWhileStatement> getDoWhileStatementList();

  @NotNull
  List<HaxeExpression> getExpressionList();

  @NotNull
  List<HaxeForStatement> getForStatementList();

  @NotNull
  List<HaxeIfStatement> getIfStatementList();

  @NotNull
  List<HaxeLocalFunctionDeclaration> getLocalFunctionDeclarationList();

  @NotNull
  List<HaxeLocalVarDeclaration> getLocalVarDeclarationList();

  @NotNull
  List<HaxePp> getPpList();

  @NotNull
  List<HaxeReturnStatement> getReturnStatementList();

  @NotNull
  List<HaxeSwitchStatement> getSwitchStatementList();

  @NotNull
  List<HaxeThrowStatement> getThrowStatementList();

  @NotNull
  List<HaxeTryStatement> getTryStatementList();

  @NotNull
  List<HaxeWhileStatement> getWhileStatementList();

}
