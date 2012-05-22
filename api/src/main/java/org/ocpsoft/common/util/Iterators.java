/*
 * Copyright 2012 <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
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
package org.ocpsoft.common.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Utility methods for working with {@link Iterator} and {@link Iterable} instances.
 * 
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
public final class Iterators
{
   public Iterators()
   {}

   /**
    * Return the elements of the given {@link Iterable} as a {@link List}.
    */
   public static <T> List<T> asList(final Iterable<T> iterable)
   {
      List<T> result = new ArrayList<T>();
      for (T t : iterable)
      {
         result.add(t);
      }
      return result;
   }

   /**
    * Return the elements of the given {@link Iterator} as a {@link List}.
    */
   public static <T> List<T> asList(final Iterator<T> iterator)
   {
      List<T> result = new ArrayList<T>();
      while (iterator.hasNext())
      {
         T t = iterator.next();
         result.add(t);
      }
      return result;
   }

   /**
    * Return the elements of the given {@link Iterable} as a {@link List}.
    */
   public static <T> Set<T> asSet(final Iterable<T> iterable)
   {
      Set<T> result = new HashSet<T>();
      for (T t : iterable)
      {
         result.add(t);
      }
      return result;
   }

   /**
    * Return the elements of the given {@link Iterator} as a {@link List}.
    */
   public static <T> Set<T> asSet(final Iterator<T> iterator)
   {
      Set<T> result = new HashSet<T>();
      while (iterator.hasNext())
      {
         T t = iterator.next();
         result.add(t);
      }
      return result;
   }
}
