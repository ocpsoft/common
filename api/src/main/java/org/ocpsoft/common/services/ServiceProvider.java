package org.ocpsoft.common.services;

import java.util.List;

import org.ocpsoft.common.pattern.Weighted;


/**
 * Used to provide provide pre-enriched services to the {@link ServiceLoader} as an alternate method of
 * 
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public interface ServiceProvider extends Weighted
{
   public <T> List<T> getServices(Class<T> type);
}
