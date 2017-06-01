package org.jboss.resteasy.cdi.i18n;

import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageBundle;

/**
 * 
 * @author <a href="ron.sigal@jboss.com">Ron Sigal</a>
 * @version $Revision: 1.1 $
 *
 * Copyright Aug 25, 2015
 */
@MessageBundle(projectCode = "RESTEASY")
public interface Messages
{
   Messages MESSAGES = org.jboss.logging.Messages.getBundle(Messages.class);
   int BASE = 10500;

   @Message(id = BASE + 105, value = "Unable to lookup BeanManager.")
   String unableToLookupBeanManager();

   @Message(id = BASE + 115, value = "Unable to obtain ResteasyCdiExtension instance.")
   String unableToObtainResteasyCdiExtension();

}
