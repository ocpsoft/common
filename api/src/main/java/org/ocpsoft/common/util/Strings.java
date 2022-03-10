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

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * Utility methods for manipulating {@link String} instances
 * 
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
public final class Strings
{
   public Strings()
   {}

   /**
    * Return true if the given {@link String} instances are equal, or if both {@link String} instances are null.
    */
   public static boolean areEqual(final String left, final String right)
   {
      return Objects.equals(left, right);
   }

   /**
    * Return true if the given {@link String} instances are equal when outer whitespace is removed, or if both
    * {@link String} instances are null. (E.g.: "  hello world  " is equal to "hello world  ")
    */
   public static boolean areEqualTrimmed(final String left, final String right)
   {
      if ((left != null) && (right != null))
      {
         return left.trim().equals(right.trim());
      }
      return areEqual(left, right);
   }

   /**
    * Capitalize the given {@link String}: "input" -> "Input"
    */
   public static String capitalize(final String input)
   {
      if ((input == null) || (input.length() == 0))
      {
         return input;
      }
      return input.substring(0, 1).toUpperCase() + input.substring(1);
   }

   /**
    * Return true if the given {@link String} is null or is empty.
    */
   public static boolean isNullOrEmpty(final String string)
   {
      return (string == null) || string.isEmpty();
   }

   /**
    * Return true if the given {@link String} equals "true", case insensitive; otherwise return false.
    */
   public static boolean isTrue(final String value)
   {
      return value == null ? false : "true".equalsIgnoreCase(value.trim());
   }

   /**
    * Join a {@link Collection} of {@link String} instances using the given delimiter.
    */
   public static String join(final Collection<?> collection, final String delimiter)
   {
      StringBuilder buffer = new StringBuilder();
      Iterator<?> iter = collection.iterator();
      while (iter.hasNext())
      {
         buffer.append(iter.next());
         if (iter.hasNext())
         {
            buffer.append(delimiter);
         }
      }
      return buffer.toString();
   }

   /**
    * Uncapitalize the given {@link String}. (E.g.: "CamelCase" -> "camelCase")
    */
   public static String uncapitalize(final String input)
   {
      if ((input == null) || (input.length() == 0))
      {
         return input;
      }
      return input.substring(0, 1).toLowerCase() + input.substring(1);
   }
}
