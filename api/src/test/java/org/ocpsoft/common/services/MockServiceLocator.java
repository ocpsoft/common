package org.ocpsoft.common.services;

import java.util.ArrayList;
import java.util.Collection;

import org.ocpsoft.common.spi.ServiceLocator;


/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public class MockServiceLocator implements ServiceLocator
{
   public static boolean provide = false;

   @Override
   @SuppressWarnings({ "rawtypes", "unchecked" })
   public <T> Collection<Class<T>> locate(final Class<T> type)
   {
      Collection result = new ArrayList();
      if (provide)
      {
         result.add(DummyServiceImpl2.class);
      }
      return result;
   }

}
