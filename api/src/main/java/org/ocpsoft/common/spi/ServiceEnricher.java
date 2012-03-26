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
package org.ocpsoft.common.spi;

import java.util.Collection;

import org.ocpsoft.common.services.ServiceLoader;


/**
 * Provides enriching for services loaded with {@link ServiceLoader}
 * 
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
public interface ServiceEnricher
{
   /**
    * Produce a {@link Collection} of enriched services of the given type. If no instances were produced, this method
    * must return an empty {@link Collection}. Only one {@link ServiceEnricher} may produce a service at any given time.
    * If more than one {@link ServiceEnricher} may produce the same service, only the first will be used.
    */
   <T> Collection<T> produce(Class<T> type);

   /**
    * Enrich an instantiated instance of the given service type. If no enriching took place, this method must return the
    * original service without modification. This method is called only when the service was <strong>not</strong>
    * produced by this {@link ServiceEnricher}; in that case, enrichment should have already taken place at the time of
    * production.
    */
   <T> void enrich(T service);
}
