/*
 * Copyright 2000-2013 JetBrains s.r.o.
 * Copyright 2014-2014 AS3Boyan
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
package org.jetbrains.jps.haxe.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jps.haxe.model.module.JpsHaxeModuleSettings;
import org.jetbrains.jps.model.JpsElement;
import org.jetbrains.jps.model.module.JpsModule;

/**
 * @author: Fedor.Korotkov
 */
public class JpsHaxeUtil {
  @Nullable
  public static JpsHaxeModuleSettings getModuleSettings(@NotNull JpsModule module) {
    final JpsElement result = module.getProperties();
    return result instanceof JpsHaxeModuleSettings ? (JpsHaxeModuleSettings)result : null;
  }
}
