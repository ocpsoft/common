/*
 * Copyright 2011 <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ocpsoft.common.spi;

import java.util.Collection;

import com.ocpsoft.common.services.ServiceLoader;

/**
 * Locates additional service implementation classes to be instantiated by the {@link ServiceLoader}
 * 
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
public interface ServiceLocator
{
   /**
    * Locate additional class types of which can be produced by this {@link ServiceLocator}. If no services could be
    * located, this method must return an empty collection.
    */
   <T> Collection<Class<T>> locate(Class<T> type);
}
