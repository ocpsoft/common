package org.ocpsoft.common.services;

import java.util.ArrayList;
import java.util.Collection;

import org.ocpsoft.common.spi.ServiceEnricher;


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
