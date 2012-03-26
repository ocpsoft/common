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
package org.ocpsoft.common.services;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.ocpsoft.common.services.ServiceLoader;
import org.ocpsoft.common.util.Iterators;


/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public class ServiceLoaderTest
{
   @Test
   @SuppressWarnings("unchecked")
   public void testBasicBehavior()
   {
      ServiceLoader<DummyService> services = ServiceLoader.load(DummyService.class);
      List<DummyService> list = Iterators.asList(services);
      Assert.assertEquals(1, list.size());
   }

   @Test
   @SuppressWarnings("unchecked")
   public void testWithLocatorExtension()
   {
      MockServiceLocator.provide = true;
      ServiceLoader<DummyService> services = ServiceLoader.load(DummyService.class);
      List<DummyService> list = Iterators.asList(services);
      Assert.assertEquals(2, list.size());
      MockServiceLocator.provide = false;
   }

   @Test
   @SuppressWarnings("unchecked")
   public void testWithEnricherProviderDoesNotProduceUnlessTypeMatches() throws Exception
   {
      MockServiceEnricher.produceLocated = true;
      ServiceLoader<DummyService> services = ServiceLoader.load(DummyService.class);
      List<DummyService> list = Iterators.asList(services);
      Assert.assertEquals(1, list.size());
      MockServiceEnricher.produceLocated = false;
   }

   @Test
   @SuppressWarnings("unchecked")
   public void testWithEnricherAndLocatorProducesTwoSeparateNamedServiceInstances() throws Exception
   {
      MockServiceEnricher.produceLocated = true;
      MockServiceLocator.provide = true;
      ServiceLoader<DummyService> services = ServiceLoader.load(DummyService.class);
      List<DummyService> list = Iterators.asList(services);
      Assert.assertEquals(3, list.size());
      MockServiceEnricher.produceLocated = false;
      MockServiceLocator.provide = false;
   }

   @Test
   @SuppressWarnings("unchecked")
   public void testEnricherThatProvidesClassDoesNotEnrich() throws Exception
   {
      MockServiceEnricher.produceStandard = true;
      MockServiceEnricher.produced = false;
      MockServiceEnricher.enriched = false;
      Assert.assertFalse(MockServiceEnricher.produced);
      Assert.assertFalse(MockServiceEnricher.enriched);
      ServiceLoader<DummyService> services = ServiceLoader.load(DummyService.class);
      List<DummyService> list = Iterators.asList(services);
      Assert.assertEquals(1, list.size());
      Assert.assertTrue(MockServiceEnricher.produced);
      Assert.assertFalse(MockServiceEnricher.enriched);
      MockServiceEnricher.produceStandard = false;
      MockServiceLocator.provide = false;
   }
}
