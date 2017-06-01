package org.jboss.resteasy.wadl.i18n;

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
 * Copyright January 6, 2016
 */
@MessageLogger(projectCode = "RESTEASY")
public interface LogMessages extends BasicLogger
{
   int BASE = 19000;

   LogMessages LOGGER = Logger.getMessageLogger(LogMessages.class, LogMessages.class.getPackage().getName());

   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 5, value = "Loading ResteasyWadlServlet")
   void loadingResteasyWadlServlet();
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 20, value = "Path: %s")
   void path(String key);
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 25, value = "Query %s")
   void query(String query);
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 30, value = "ResteasyWadlServlet loaded")
   void resteasyWadlServletLoaded();
   
   @LogMessage(level = Level.DEBUG)
   @Message(id = BASE + 35, value = "Serving %s")
   void servingPathInfo(String pathInfo);
   
}
