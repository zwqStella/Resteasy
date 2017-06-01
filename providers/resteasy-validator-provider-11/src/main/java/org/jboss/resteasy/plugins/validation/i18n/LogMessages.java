package org.jboss.resteasy.plugins.validation.i18n;

import javax.validation.ValidatorFactory;

import org.jboss.logging.BasicLogger;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageLogger;

/**
 * 
 * @author <a href="ron.sigal@jboss.com">Ron Sigal</a>
 * @version $Revision: 1.1 $
 *
 * Copyright Aug 25, 2015
 */
@MessageLogger(projectCode = "RESTEASY")
public interface LogMessages extends BasicLogger
{
   LogMessages LOGGER = Logger.getMessageLogger(LogMessages.class, LogMessages.class.getPackage().getName());
   int BASE = 8500;
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 10, value = "ResteasyCdiExtension is on the classpath.")
   void resteasyCdiExtensionOnClasspath();
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 15, value = "ResteasyCdiExtension is not on the classpath. Assuming CDI is not active")
   void resteasyCdiExtensionNotOnClasspath();
   
   @LogMessage(level = Level.INFO)
   @Message(id = BASE + 50, value = "Unable to find CDI supporting ValidatorFactory. Using default ValidatorFactory")
   void usingValidatorFactoryDoesNotSupportCDI();
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 55, value = "Using CDI supporting %s")
   void usingValidatorFactorySupportsCDI(ValidatorFactory factory);
}
