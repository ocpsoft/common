/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.ocpsoft.common.services;

import java.util.ArrayList;
import java.util.Collection;

import com.ocpsoft.common.spi.ServiceEnricher;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public class MockServiceEnricher implements ServiceEnricher
{
   public static boolean produceLocated = false;
   public static boolean enriched;
   public static boolean produced;
   public static boolean produceStandard;

   @Override
   @SuppressWarnings("unchecked")
   public <T> Collection<T> produce(final Class<T> type)
   {
      Collection<T> result = new ArrayList<T>();
      /*
       * If we are asked for an instance of #2, provide two instances of #2 with different names.
       */
      if (produceLocated && DummyServiceImpl2.class.equals(type))
      {
         result.add((T) new DummyServiceImpl2("first"));
         result.add((T) new DummyServiceImpl2("second"));
         produced = true;
      }
      if (produceStandard && DummyServiceImpl.class.equals(type))
      {
         result.add((T) new DummyServiceImpl());
         produced = true;
      }
      return result;

   }

   @Override
   public <T> void enrich(final T service)
   {
      enriched = true;
   }

}
