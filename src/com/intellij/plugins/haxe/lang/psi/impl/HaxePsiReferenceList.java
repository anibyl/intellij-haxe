/*
 * Copyright 2000-2013 JetBrains s.r.o.
 * Copyright 2014-2014 AS3Boyan
 * Copyright 2014-2014 Elias Ku
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.plugins.haxe.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.plugins.haxe.lang.psi.HaxePsiCompositeElement;
import com.intellij.psi.*;
import com.intellij.psi.impl.PsiManagerEx;
import com.intellij.psi.impl.source.PsiReferenceListImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Srikanth.Ganapavarapu
 */
public class HaxePsiReferenceList extends PsiReferenceListImpl implements PsiReferenceList {

  private Role mRole;
  private AbstractHaxePsiClass mContainingClass;
  private List<PsiElement> mChildren;

  public HaxePsiReferenceList(ASTNode node) {
    super(node);
    mRole = null;
    mChildren = new ArrayList<PsiElement>();
  }

  public HaxePsiReferenceList(AbstractHaxePsiClass containingClass, ASTNode node, Role inRole) {
    super(node);
    mRole = inRole;
    mContainingClass = containingClass;
    mChildren = new ArrayList<PsiElement>();
  }

  @Override
  public Role getRole() {
    return mRole;
  }

  @NotNull
  public void addReferenceElements(PsiElement[] psiElements) {
    if (mRole.equals(PsiReferenceList.Role.EXTENDS_LIST) ||
        mRole.equals(PsiReferenceList.Role.IMPLEMENTS_LIST)) {
      for (PsiElement element : psiElements) {
        mChildren.add(element);
      }
    }
    //else {
    //  // throw exception?
    //}
  }

  @NotNull
  @Override
  public PsiClass[] getReferenceElements() {
    if (mRole.equals(PsiReferenceList.Role.EXTENDS_LIST) || mRole.equals(PsiReferenceList.Role.IMPLEMENTS_LIST)) {
        return ((PsiClass[])(mChildren.toArray(new PsiElement[mChildren.size()])));
    }
    else {
      return ((PsiClass[])((HaxePsiCompositeElement) getNode()).getChildren());
    }
  }

  @NotNull
  @Override
  public PsiClassType[] getReferencedTypes() {
    final PsiElement[] referenceElements = getReferenceElements();
    final PsiClassType[] psiClassTypes = new PsiClassType[referenceElements.length];
    final PsiElementFactory psiElementFactory = JavaPsiFacade.getElementFactory(mContainingClass.getProject());
    for (int index = 0; index < psiClassTypes.length; index++) {
      psiClassTypes[index] = psiElementFactory.createType((PsiClass)referenceElements[index]);
    }
    return psiClassTypes;
  }

  @Override
  public boolean isWritable() {
    return true; // TODO: [TiVo]: FIX
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    super.accept(visitor);
  }

  @Override
  public PsiElement getParent() {
    return mContainingClass;
  }

  @Override
  public PsiManagerEx getManager() {
    return mContainingClass.getManager();
  }

  @NotNull
  @Override
  public Project getProject() {
    return mContainingClass.getProject();
  }

  @NotNull
  @Override
  public PsiFile getContainingFile() {
    return mContainingClass.getContainingFile();
  }
}
