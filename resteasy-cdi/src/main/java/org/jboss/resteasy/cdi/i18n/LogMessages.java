package org.jboss.resteasy.cdi.i18n;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

import javax.enterprise.inject.spi.Bean;

import org.jboss.logging.BasicLogger;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageLogger;
import org.jboss.logging.annotations.Message.Format;

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
   int BASE = 10500;
   
   @LogMessage(level = Level.WARN)
   @Message(id = BASE + 0, value = "ProcessInjectionTarget.getAnnotatedType() returned null. As a result, JAX-RS property injection will not work.")
   void annotatedTypeNull();

   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 5, value = "Bean {0} does not have the scope defined. Binding to {1}.", format=Format.MESSAGE_FORMAT)
   void beanDoesNotHaveScopeDefined(Class<?> clazz, Annotation scope);

   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 10, value = "Bean {0} has a scope defined.", format=Format.MESSAGE_FORMAT)
   void beanHasScopeDefined(Class<?> clazz);
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 15, value = "Bean {0} is a SLSB or Singleton. Leaving scope unmodified.", format=Format.MESSAGE_FORMAT)
   void beanIsSLSBOrSingleton(Class<?> clazz);
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 20, value = "Beans found for {0} : {1}", format=Format.MESSAGE_FORMAT)
   void beansFound(Type type, Set<Bean<?>> beans);
   

   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 25, value = "Discovered CDI bean which is javax.ws.rs.core.Application subclass {0}.", format=Format.MESSAGE_FORMAT)
   void discoveredCDIBeanApplication(String classname);
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 30, value = "Discovered CDI bean which is a JAX-RS provider {0}.", format=Format.MESSAGE_FORMAT)
   void discoveredCDIBeanJaxRsProvider(String classname);

   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 35, value = "Discovered CDI bean which is a JAX-RS resource {0}.", format=Format.MESSAGE_FORMAT)
   void discoveredCDIBeanJaxRsResource(String classname);
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 40, value = "Doing a lookup for BeanManager in {0}", format=Format.MESSAGE_FORMAT)
   void doingALookupForBeanManager(String name);
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 45, value = "Error occurred trying to look up via ServletContext.")
   void errorOccurredLookingUpServletContext(@Cause Throwable cause);
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 50, value = "Error occurred trying to look up via CDI util.")
   void errorOccurredLookingUpViaCDIUtil(@Cause Throwable cause);
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 55, value = "Found BeanManager at java:app/BeanManager")
   void foundBeanManagerAtJavaApp();

   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 60, value = "Found BeanManager at java:comp/BeanManager")
   void foundBeanManagerAtJavaComp();

   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 65, value = "Found BeanManager in ServletContext")
   void foundBeanManagerInServletContext();

   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 70, value = "Found BeanManager via CDI Util")
   void foundBeanManagerViaCDI();
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 75, value = "No CDI beans found for {0}. Using default ConstructorInjector.", format=Format.MESSAGE_FORMAT)
   void noCDIBeansFound(Class<?> clazz);

   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 80, value = "No lookup interface found for {0}", format=Format.MESSAGE_FORMAT)
   void noLookupInterface(Class<?> clazz);
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 85, value = "JaxrsInjectionTarget skipping validation outside of Resteasy context")
   void skippingValidationOutsideResteasyContext();
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 90, value = "{0} will be used for {1} lookup", format=Format.MESSAGE_FORMAT)
   void typeWillBeUsedForLookup(Type type, Class<?> clazz);

   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 95, value = "Unable to find CDI class ")
   void unableToFindCDIClass(@Cause Throwable cause);
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 100, value = "Unable to find ServletContext class.")
   void unableToFindServletContextClass(@Cause Throwable cause);
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 110, value = "Unable to obtain BeanManager from {0}", format=Format.MESSAGE_FORMAT)
   void unableToObtainBeanManager(String name);

   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 120, value = "Unable to perform JNDI lookups. You are probably running on GAE.")
   void unableToPerformJNDILookups();
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 125, value = "Using CdiConstructorInjector for class {0}.", format=Format.MESSAGE_FORMAT)
   void usingCdiConstructorInjector(Class<?> clazz);
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 130, value = "Using {0} for lookup of Session Bean {1}.", format=Format.MESSAGE_FORMAT)
   void usingInterfaceForLookup(Type type, Class<?> clazz);
}
