package org.jboss.resteasy.resteasy_jaxrs.i18n;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.Message.Format;
import org.jboss.logging.annotations.MessageBundle;
import org.jboss.resteasy.util.WeightedLanguage;

/**
 * 
 * @author <a href="ron.sigal@jboss.com">Ron Sigal</a>
 * @version $Revision: 1.1 $
 *
 * Copyright Aug 13, 2015
 */
@MessageBundle(projectCode = "RESTEASY")
public interface Messages
{
   Messages MESSAGES = org.jboss.logging.Messages.getBundle(Messages.class);

   int BASE_3K = 3000;
   int BASE_ASYNC_9K = 9500;
   
   @Message(id = BASE_ASYNC_9K + 10, value = "Already suspended")
   String alreadySuspended();
   
   @Message(id = BASE_ASYNC_9K + 35, value = "Request not suspended")
   String requestNotSuspended();
   
   @Message(id = BASE_3K + 00, value = "SelfExpandingBufferredInputStream is always marked at index 0.")
   String alwaysMarkedAtIndex0();

   
   @Message(id = BASE_3K + 05, value = "Ambiguous inherited JAX-RS annotations applied to method: %s")
   String ambiguousInheritedAnnotations(Method method);
   
   @Message(id = BASE_3K + 10, value =  "annotations param was null")
   String annotationsParamNull();
   
   @Message(id = BASE_3K + 15, value = "application param was null")
   String applicationParamNull();
   
   @Message(id = BASE_3K + 17, value = "ClassCastException: attempting to cast {0} to {1}", format=Format.MESSAGE_FORMAT)
   String attemptingToCast(URL from, URL to);
   
   @Message(id = BASE_3K + 20, value = "Bad arguments passed to %s")
   String badArguments(String methodName);
   
   @Message(id = BASE_3K + 25, value = "Bad Base64 input character decimal {0} in array position {1}", format=Format.MESSAGE_FORMAT)
   String badBase64Character(int c, int pos);

   @Message(id = BASE_3K + 30, value = "Base64 input not properly padded.")
   String base64InputNotProperlyPadded();
   
   @Message(id = BASE_3K + 35, value = "Base64-encoded string must have at least four characters, but length specified was %s")
   String base64StringMustHaveFourCharacters(int len);
   
   @Message(id = BASE_3K + 40, value = "You have not set a base URI for the client proxy")
   String baseURINotSetForClientProxy();

   @Message(id = BASE_3K + 45, value = "CacheControl max-age header does not have a value: %s.")
   String cacheControlMaxAgeHeader(String value);

   @Message(id = BASE_3K + 50, value = "CacheControl s-maxage header does not have a value: %s.")
   String cacheControlSMaxAgeHeader(String value);
   
   @Message(id = BASE_3K + 55, value = "Cache-Control value is null")
   String cacheControlValueNull();

   @Message(id = BASE_3K + 60, value = "Callback was null")
   String callbackWasNull();
   
   @Message(id = BASE_3K + 65, value = "Cannot consume content type")
   String cannotConsumeContentType();
   
   @Message(id = BASE_3K + 70, value = "Cannot decode null source array.")
   String cannotDecodeNullSourceArray();
   
   @Message(id = BASE_3K + 75, value = "Cannot have length offset: %s")
   String cannotHaveLengthOffset(int len);
   
   @Message(id = BASE_3K + 80, value = "Cannot have negative offset: %s")
   String cannotHaveNegativeOffset(int off);

   @Message(id = BASE_3K + 85, value = "Cannot have offset of {0} and length of {1} with array of length {2}", format=Format.MESSAGE_FORMAT)
   String cannotHaveOffset(int off, int len, int srcLen);
   
   @Message(id = BASE_3K + 90, value = "You cannot inject AsynchronousResponse outside the scope of an HTTP request")
   String cannotInjectAsynchronousResponse();
   
   @Message(id = BASE_3K + 95, value = "You cannot inject into a form outside the scope of an HTTP request")
   String cannotInjectIntoForm();
   
   @Message(id = BASE_3K + 100, value = "You cannot send both form parameters and an entity body")
   String cannotSendFormParametersAndEntity();

   @Message(id = BASE_3K + 105, value = "Cannot serialize a null array.")
   String cannotSerializeNullArray();
   
   @Message(id = BASE_3K + 110, value = "Cannot serialize a null object.")
   String cannotSerializeNullObject();
   
   @Message(id = BASE_3K + 115, value = "You can only set one of LinkHeaderParam.rel() and LinkHeaderParam.title() for on {0}.{1}", format=Format.MESSAGE_FORMAT)
   String canOnlySetLinkHeaderRelOrTitle(String className, String methodName);

   @Message(id = BASE_3K + 120, value = "Can't set method after match")
   String cantSetMethod();
   
   @Message(id = BASE_3K + 125, value = "Can't set URI after match")
   String cantSetURI();
   
   @Message(id = BASE_3K + 130, value = "Class is not a root resource.  It, or one of its interfaces must be annotated with @Path: %s implements: ")
   String classIsNotRootResource(String className);
   
   @Message(id = BASE_3K + 135, value = "Class must be annotated with @Path to invoke path(Class)")
   String classMustBeAnnotatedWithPath();
   
   @Message(id = BASE_3K + 140, value = "ClientRequest doesn't implement Clonable.  Notify the RESTEasy staff right away.")
   String clientRequestDoesntSupportClonable();
   
   @Message(id = BASE_3K + 145, value = "Unable to find a MessageBodyReader of content-type {0} and type {1}", format=Format.MESSAGE_FORMAT)
   String clientResponseFailureMediaType(MediaType mediaType, Type type);
   
   @Message(id = BASE_3K + 150, value = "Error status {0} {1} returned", format=Format.MESSAGE_FORMAT)
   String clientResponseFailureStatus(int status, Status responseStatus);
   
   @Message(id = BASE_3K + 155, value = "Constructor arg paramMapping is invalid")
   String constructorMappingInvalid();

   @Message(id = BASE_3K + 160, value = "Control character in cookie value, consider BASE64 encoding your value")
   String controlCharacterInCookieValue();
   
   @Message(id = BASE_3K + 165, value = "Cookie header value was null")
   String cookieHeaderValueNull();

   @Message(id = BASE_3K + 170, value = "Could not create a default entity type factory of type {0}", format=Format.MESSAGE_FORMAT)
   String couldNotCreateEntityFactory(String className);
   
   @Message(id = BASE_3K + 175, value = "Could not create a default entity type factory of type {0}. {1}", format=Format.MESSAGE_FORMAT)
   String couldNotCreateEntityFactoryMessage(String className, String message);
   
   @Message(id = BASE_3K + 180, value = "Could not create a URI for {0} in {1}.{2}", format=Format.MESSAGE_FORMAT)
   String couldNotCreateURI(String uri, String className, String methodName);

   @Message(id = BASE_3K + 185, value = "Could not find class %s provided to JNDI Component Resource")
   String couldNotFindClassJndi(String className);

   @Message(id = BASE_3K + 190, value = "Could not find constructor for class: %s")
   String couldNotFindConstructor(String className);
   
   @Message(id = BASE_3K + 195, value = "URITemplateAnnotationResolver could not find a getter for param %s")
   String couldNotFindGetterForParam(String param);
   
   @Message(id = BASE_3K + 200, value = "Could not find message body reader for type: {0} of content type: {1}", format=Format.MESSAGE_FORMAT)
   String couldNotFindMessageBodyReader(Type type, MediaType mediaType);
   
   @Message(id = BASE_3K + 205, value = "Could not find a method for: %s")
   String couldNotFindMethod(Method method);
   
   @Message(id = BASE_3K + 210, value = "Could not find resource for full path: %s")
   String couldNotFindResourceForFullPath(URI uri);
   
   @Message(id = BASE_3K + 215, value = "could not find writer for content-type {0} type: {1}", format=Format.MESSAGE_FORMAT)
   String couldNotFindWriterForContentType(MediaType mediaType, String className);

   @Message(id = BASE_3K + 220, value = "URITemplateAnnotationResolver could not get a value for %s")
   String couldNotGetAValue(String param);

   @Message(id = BASE_3K + 225, value = "URITemplateAnnotationResolver could not introspect class %s")
   String couldNotIntrospectClass(String className);

   @Message(id = BASE_3K + 230, value = "Could not match up an implementation for LoggerType: %s")
   String couldNotMatchUpLoggerTypeImplementation(Class<?> loggerType);
   
   @Message(id = BASE_3K + 235, value = "Could not process method %s")
   String couldNotProcessMethod(Method method);
   
   @Message(id = BASE_3K + 240, value = "Could not read type {0} for media type {1}", format=Format.MESSAGE_FORMAT)
   String couldNotReadType(Type type, MediaType mediaType);

   @Message(id = BASE_3K + 245, value = "Date instances are not supported by this class.")
   String dateInstancesNotSupported();
   
   @Message(id = BASE_3K + 250, value = "date is null")
   String dateNull();
   
   @Message(id = BASE_3K + 255, value = "Data to encode was null.")
   String dataToEncodeNull();

   @Message(id = BASE_3K + 260, value = "dateValue is null")
   String dateValueNull();
   
   @Message(id = BASE_3K + 265, value = "Destination array with length {0} cannot have offset of {1} and still store three bytes.", format=Format.MESSAGE_FORMAT)
   String destinationArrayCannotStoreThreeBytes(int len, int off);
   
   @Message(id = BASE_3K + 270, value = "Destination array was null.")
   String destinationArrayNull();

   @Message(id = BASE_3K + 275, value = "Empty field in: %s.")
   String emptyFieldInHeader(String header);
   
   @Message(id = BASE_3K + 280, value = "empty host name")
   String emptyHostName();

   @Message(id = BASE_3K + 285, value = "The entity was already read, and it was of type %s")
   String entityAlreadyRead(Class<?> clazz);
      
   @Message(id = BASE_3K + 290, value = "Entity is not backed by an input stream")
   String entityNotBackedByInputStream();
   
   @Message(id = BASE_3K + 295, value = "The object you supplied to registerInterceptor is not of an understood type")
   String entityNotOfUnderstoodType();

   @Message(id = BASE_3K + 300, value = "value of EntityTag is null")
   String entityTagValueNull();

   @Message(id = BASE_3K + 305, value = "Error in Base64 code reading stream.")
   String errorInBase64Stream();

   @Message(id = BASE_3K + 310, value = "eTag param null")
   String eTagParamNull();
   
   @Message(id = BASE_3K + 315, value = "You have exceeded your maximum forwards ResteasyProviderFactory allows.  Last good uri: %s")
   String excededMaximumForwards(String uri);
   
   @Message(id = BASE_3K + 320, value = "Failed processing arguments of %s")
   String failedProcessingArguments(String constructor);
   
   @Message(id = BASE_3K + 325, value = "Failed to construct %s")
   String failedToConstruct(String constructor);

   @Message(id = BASE_3K + 330, value = "Failed to create URI: %s")
   String failedToCreateUri(String buf);
   
   @Message(id = BASE_3K + 335, value = "Failed to parse cookie string '%s'")
   String failedToParseCookie(String value);
   
   @Message(id = BASE_3K + 340, value = "Failure parsing MediaType string: %s")
   String failureParsingMediaType(String type);

   @Message(id = BASE_3K + 345, value = "File is too big for this convenience method (%s bytes).")
   String fileTooBig(long len);
   
   @Message(id = BASE_3K + 350, value = "Garbage after quoted string: %s")
   String garbageAfterQuotedString(String header);
   
   @Message(id = BASE_3K + 355, value = "A GET request cannot have a body.")
   String getRequestCannotHaveBody();

   @Message(id = BASE_3K + 357, value = "GZIP input exceeds max size: %s")
   String gzipExceedsMaxSize(int size);
   
   @Message(id = BASE_3K + 360, value = "%s has no String constructor")
   String hasNoStringConstructor(String className);
   
   @Message(id = BASE_3K + 365, value = "Illegal hexadecimal character {0} at index {1}", format=Format.MESSAGE_FORMAT)
   String illegalHexadecimalCharacter(char ch, int index);

   @Message(id = BASE_3K + 370, value = "Illegal response media type: %s")
   String illegalResponseMediaType(String mediaType);
   
   @Message(id = BASE_3K + 375, value = "It is illegal to inject a @CookieParam into a singleton")
   String illegalToInjectCookieParam();

   @Message(id = BASE_3K + 380, value = "It is illegal to inject a @FormParam into a singleton")
   String illegalToInjectFormParam();
   
   @Message(id = BASE_3K + 385, value = "It is illegal to inject a @HeaderParam into a singleton")
   String illegalToInjectHeaderParam();
   
   @Message(id = BASE_3K + 390, value = "It is illegal to inject a @MatrixParam into a singleton")
   String illegalToInjectMatrixParam();
   
   @Message(id = BASE_3K + 395, value = "Illegal to inject a message body into a singleton into %s")
   String illegalToInjectMessageBody(AccessibleObject target);
   
   @Message(id = BASE_3K + 400, value = "Illegal to inject a non-interface type into a singleton")
   String illegalToInjectNonInterfaceType();
   
   @Message(id = BASE_3K + 405, value = "It is illegal to inject a @PathParam into a singleton")
   String illegalToInjectPathParam();
   
   @Message(id = BASE_3K + 410, value = "It is illegal to inject a @QueryParam into a singleton")
   String illegalToInjectQueryParam();

   @Message(id = BASE_3K + 415, value = "Illegal uri template: %s")
   String illegalUriTemplate(String template);

   @Message(id = BASE_3K + 420, value = "Improperly padded Base64 input.")
   String improperlyPaddedBase64Input();

   @Message(id = BASE_3K + 425, value = "Incorrect type parameter. ClientExceptionMapper requires a subclass of java.lang.Throwable as its type parameter.")
   String incorrectTypeParameterClientExceptionMapper();
   
   @Message(id = BASE_3K + 430, value = "Incorrect type parameter. ExceptionMapper requires a subclass of java.lang.Throwable as its type parameter.")
   String incorrectTypeParameterExceptionMapper();

   @Message(id = BASE_3K + 435, value = "Input stream was empty, there is no entity")
   String inputStreamEmpty();
   
   @Message(id = BASE_3K + 440, value = "Input string was null.")
   String inputStringNull();
   
   @Message(id = BASE_3K + 445, value = "Interceptor class must be annotated with @ServerInterceptor and/or @ClientInterceptor")
   String interceptorClassMustBeAnnotated();
   
   @Message(id = BASE_3K + 450, value = "Interceptor class %s must be annotated with @ServerInterceptor and/or @ClientInterceptor")
   String interceptorClassMustBeAnnotatedWithClass(Class<?> clazz);

   @Message(id = BASE_3K + 455, value = "interceptor null from class: %s")
   String interceptorNullFromClass(String className);
   
   @Message(id = BASE_3K + 460, value = "Invalid character in Base64 data.")
   String invalidCharacterInBase64Data();
   
   @Message(id = BASE_3K + 465, value = "Invalid escape character in cookie value.")
   String invalidEscapeCharacterInCookieValue();

   @Message(id = BASE_3K + 470, value = "invalid host")
   String invalidHost();
   
   @Message(id = BASE_3K + 475, value = "Invalid port value")
   String invalidPort();
   
   @Message(id = BASE_3K + 480, value = "%s is not initial request.  Its suspended and retried.  Aborting.")
   String isNotInitialRequest(String path);

   @Message(id = BASE_3K + 485, value = "JNDI Component Resource variable is not set correctly: jndi;class;true|false comma delimited")
   String jndiComponentResourceNotSetCorrectly();
   
   @Message(id = BASE_3K + 490, value = "The %s config in web.xml could not be parsed, accepted values are true,false or 1,0")
   String keyCouldNotBeParsed(String key);

   @Message(id = BASE_3K + 495, value = "lastModified param null")
   String lastModifiedParamNull();
   
   @Message(id = BASE_3K + 500, value = "Locale value is null")
   String localeValueNull();
   
   @Message(id = BASE_3K + 505, value = "Malformed media type: %s")
   String malformedMediaType(String header);
   
   @Message(id = BASE_3K + 510, value = "Malformed parameter: %s")
   String malformedParameter(String parameter);
   
   @Message(id = BASE_3K + 515, value = "Malformed parameters: %s.")
   String malformedParameters(String header);
   
   @Message(id = BASE_3K + 520, value = "Malformed quality value.")
   String malformedQualityValue();
   
   @Message(id = BASE_3K + 525, value = "map key is null")
   String mapKeyNull();
   
   @Message(id = BASE_3K + 530, value = "map value is null")
   String mapValueNull();
   
   @Message(id = BASE_3K + 535, value = "MarshalledEntity must have type information.")
   String marshalledEntityMustHaveTypeInfo();

   @Message(id = BASE_3K + 540, value = "MediaType q value cannot be greater than 1.0: %s")
   String mediaTypeQGreaterThan1(String mediaType);

   @Message(id = BASE_3K + 545, value = "MediaType q parameter must be a float: %s")
   String mediaTypeQMustBeFloat(MediaType mediaType);

   @Message(id = BASE_3K + 550, value = "MediaType q parameter must be a float: %s")
   String mediaTypeQWeightedLanguageMustBeFloat(WeightedLanguage lang);
   
   @Message(id = BASE_3K + 555, value = "MediaType value is null")
   String mediaTypeValueNull();

   @Message(id = BASE_3K + 560, value = "method is not annotated with @Path")
   String methodNotAnnotatedWithPath();
   
   @Message(id = BASE_3K + 565, value = "method was null")
   String methodNull();

   @Message(id = BASE_3K + 570, value = "Missing type parameter.")
   String missingTypeParameter();
   
   @Message(id = BASE_3K + 575, value = "You must define a @Consumes type on your client method or interface, or supply a default")
   String mustDefineConsumes();
   
   @Message(id = BASE_3K + 580, value = "You must set either LinkHeaderParam.rel() or LinkHeaderParam.title() for on {0}.{1}", format=Format.MESSAGE_FORMAT)
   String mustSetLinkHeaderRelOrTitle(String className, String methodName);
   
   @Message(id = BASE_3K + 585, value = "You must set either the port or ssl port, not both")
   String mustSetEitherPortOrSSLPort();
   
   @Message(id = BASE_3K + 590, value = "You must set the port or ssl port")
   String mustSetPort();
   
   @Message(id = BASE_3K + 595, value = "You must use at least one, but no more than one http method annotation on: %s")
   String mustUseOneHttpMethod(String methodName);

   @Message(id = BASE_3K + 600, value = "name parameter is null")
   String nameParameterNull();

   @Message(id = BASE_3K + 605, value = "name param is null")
   String nameParamIsNull();
   
   @Message(id = BASE_3K + 610, value = "name param was null")
   String nameParamWasNull();
   
   @Message(id = BASE_3K + 615, value = "NewCookie value is null")
   String newCookieValueNull();

   @Message(id = BASE_3K + 620, value = "No content")
   String noContent();

   @Message(id = BASE_3K + 625, value = "No content.  Content-Length is 0")
   String noContentContentLength0();
   
   @Message(id = BASE_3K + 630, value = "%s is no longer a supported context param.  See documentation for more details")
   String noLongerASupportedContextParam(String paramName);
   
   @Message(id = BASE_3K + 635, value = "No match for accept header")
   String noMatchForAcceptHeader();

   @Message(id = BASE_3K + 640, value = "No output stream allowed")
   String noOutputStreamAllowed();

   @Message(id = BASE_3K + 645, value = "No public @Path annotated method for {0}.{1}", format=Format.MESSAGE_FORMAT)
   String noPublicPathAnnotatedMethod(String resource, String method);
   
   @Message(id = BASE_3K + 650, value = "No resource method found for %s, return 405 with Allow header")
   String noResourceMethodFoundForHttpMethod(String httpMethod);
   
   @Message(id = BASE_3K + 655, value = "No resource method found for options, return OK with Allow header")
   String noResourceMethodFoundForOptions();
   
   @Message(id = BASE_3K + 660, value = "No type information to extract entity with, use other getEntity() methods")
   String noTypeInformationForEntity();
   
   @Message(id = BASE_3K + 665, value = "Not allowed to reflect on method: %s")
   String notAllowedToReflectOnMethod(String methodName);

   @Message(id = BASE_3K + 670, value = "You did not supply enough values to fill path parameters")
   String notEnoughPathParameters();

   @Message(id = BASE_3K + 675, value = "%s is not a valid injectable type for @Suspend")
   String notValidInjectableType(String typeName);
   
   @Message(id = BASE_3K + 680, value = "Null subresource for path: %s.")
   String nullSubresource(URI uri);
   
   @Message(id = BASE_3K + 685, value = "null value")
   String nullValue();
   
   @Message(id = BASE_3K + 690, value = "Number of matched segments greater than actual")
   String numberOfMatchedSegments();

   @Message(id = BASE_3K + 695, value = "Odd number of characters.")
   String oddNumberOfCharacters();
 
   @Message(id = BASE_3K + 700, value = "Origin not allowed: %s")
   String originNotAllowed(String origin);
   
   @Message(id = BASE_3K + 705, value = "param was null")
   String paramNull();
   
   @Message(id = BASE_3K + 710, value = "A passed in value was null")
   String passedInValueNull();
   
   @Message(id = BASE_3K + 715, value = "path was null")
   String pathNull();

   @Message(id = BASE_3K + 720, value = "path param %s has not been provided by the parameter map")
   String pathParameterNotProvided(String param);

   @Message(id = BASE_3K + 725, value = "pattern is null")
   String patternNull();

   @Message(id = BASE_3K + 730, value = "Accept-Language q value cannot be greater than 1.0 %s")
   String qValueCannotBeGreaterThan1(String lang);

   @Message(id = BASE_3K + 735, value = "Quoted string is not closed: %s")
   String quotedStringIsNotClosed(String header);
   
   @Message(id = BASE_3K + 740, value = "rel param was null")
   String relParamNull();
   
   @Message(id = BASE_3K + 745, value = "Removing a header is illegal for an HttpServletResponse")
   String removingHeaderIllegal();
   
   @Message(id = BASE_3K + 750, value = "Request media type is not application/x-www-form-urlencoded")
   String requestMediaTypeNotUrlencoded();

   @Message(id = BASE_3K + 755, value = "Request was already executed")
   String requestWasAlreadyExecuted();
   
   @Message(id = BASE_3K + 760, value = "resource was null")
   String resourceNull();

   @Message(id = BASE_3K + 765, value = "Response is closed.")
   String responseIsClosed();
   
   @Message(id = BASE_3K + 775, value = "schemeSpecificPart was null")
   String schemeSpecificPartNull();

   @Message(id = BASE_3K + 780, value = "A segment is null")
   String segmentNull();
   
   @Message(id = BASE_3K + 785, value = "segments parameter was null")
   String segmentsParameterNull();
   
   @Message(id = BASE_3K + 790, value = "Should be unreachable")
   String shouldBeUnreachable();

   @Message(id = BASE_3K + 795, value = "Source array with length {0} cannot have offset of {1} and process {2} bytes.", format=Format.MESSAGE_FORMAT)
   String sourceArrayCannotProcessBytes(int srcLen, int off, int len);
   
   @Message(id = BASE_3K + 800, value = "Source array with length {0} cannot have offset of {1} and still process four bytes.", format=Format.MESSAGE_FORMAT)
   String sourceArrayCannotProcessFourBytes(int srcLen, int off);
   
   @Message(id = BASE_3K + 805, value = "Source array was null.")
   String sourceArrayNull();

   @Message(id = BASE_3K + 810, value = "Stream wrapped by Signature, cannot reset the stream without destroying signature")
   String streamWrappedBySignature();
   
   @Message(id = BASE_3K + 815, value = "Subresource for target class has no jax-rs annotations.: %s")
   String subresourceHasNoJaxRsAnnotations(String className);
   
   @Message(id = BASE_3K + 820, value = "tClass parameter is null")
   String tClassParameterNull();
   
   @Message(id = BASE_3K + 825, value = "Tailing garbage: %s")
   String tailingGarbage(String header);
   
   @Message(id = BASE_3K + 830, value = "NULL value for template parameter: %s")
   String templateParameterNull(String param);

   @Message(id = BASE_3K + 835, value = "templateValues param null")
   String templateValuesParamNull();
   
   @Message(id = BASE_3K + 840, value = "title param was null")
   String titleParamNull();
   
   @Message(id = BASE_3K + 845, value = "there are two method named %s")
   String twoMethodsSameName(String method);

   @Message(id = BASE_3K + 850, value = "type param was null")
   String typeParamNull();
   
   @Message(id = BASE_3K + 855, value = "Unable to create URI: %s")
   String unableToCreateURI(String buf);
   
   @Message(id = BASE_3K + 860, value = "Unable to decode query string")
   String unableToDecodeQueryString();

   @Message(id = BASE_3K + 865, value = "Unable to determine base class from Type")
   String unableToDetermineBaseClass();
   
   @Message(id = BASE_3K + 870, value = "Unable to extract parameter from http request: {0} value is '{1}' for {2}", format=Format.MESSAGE_FORMAT)
   String unableToExtractParameter(String paramSignature, String strVal, AccessibleObject target);
   
   @Message(id = BASE_3K + 875, value = "Unable to find a constructor that takes a String param or a valueOf() or fromString() method for {0} on {1} for basetype: {2}", format=Format.MESSAGE_FORMAT)
   String unableToFindConstructor(String paramSignature, AccessibleObject target, String className);
   
   @Message(id = BASE_3K + 880, value = "Unable to find contextual data of type: %s")
   String unableToFindContextualData(String className);

   @Message(id = BASE_3K + 885, value = "Unable to find InjectorFactory implementation.")
   String unableToFindInjectorFactory();
   
   @Message(id = BASE_3K + 890, value = "Unable to find JAX-RS resource associated with path: %s.")
   String unableToFindJaxRsResource(String path);

   @Message(id = BASE_3K + 895, value = "Unable to find a public constructor for class %s")
   String unableToFindPublicConstructorForClass(String className);
   
   @Message(id = BASE_3K + 900, value = "Unable to find a public constructor for provider class %s")
   String unableToFindPublicConstructorForProvider(String className);

   @Message(id = BASE_3K + 905, value = "Unable to find type arguments of %s")
   String unableToFindTypeArguments(Class<?> clazz);

   @Message(id = BASE_3K + 910, value = "Unable to instantiate ClientExceptionMapper")
   String unableToInstantiateClientExceptionMapper();
   
   @Message(id = BASE_3K + 915, value = "Unable to instantiate context object %s")
   String unableToInstantiateContextObject(String key);

   @Message(id = BASE_3K + 920, value = "Unable to instantiate ContextResolver")
   String unableToInstantiateContextResolver();

   @Message(id = BASE_3K + 925, value = "Unable to instantiate ExceptionMapper")
   String unableToInstantiateExceptionMapper();
   
   @Message(id = BASE_3K + 930, value = "Unable to instantiate @Form class. No no-arg constructor.")
   String unableToInstantiateForm();
   
   @Message(id = BASE_3K + 935, value = "Unable to instantiate InjectorFactory implementation.")
   String unableToInstantiateInjectorFactory();

   @Message(id = BASE_3K + 940, value = "Unable to instantiate MessageBodyReader")
   String unableToInstantiateMessageBodyReader();
   
   @Message(id = BASE_3K + 945, value = "Unable to instantiate MessageBodyWriter")
   String unableToInstantiateMessageBodyWriter();

   @Message(id = BASE_3K + 950, value = "Unable to parse the date %s")
   String unableToParseDate(String dateValue);
   
   @Message(id = BASE_3K + 955, value = "Unable to parse Link header.  No end to link: %s")
   String unableToParseLinkHeaderNoEndToLink(String value);

   @Message(id = BASE_3K + 960, value = "Unable to parse Link header.  No end to parameter: %s")
   String unableToParseLinkHeaderNoEndToParameter(String value);
   
   @Message(id = BASE_3K + 965, value = "Unable to parse Link header. Too many links in declaration: %s")
   String unableToParseLinkHeaderTooManyLinks(String value);

   @Message(id = BASE_3K + 970, value = "Unable to resolve type variable")
   String unableToResolveTypeVariable();
   
   @Message(id = BASE_3K + 975, value = "Unable to unmarshall response for %s")
   String unableToUnmarshalResponse(String attributeExceptionsTo);
   
   @Message(id = BASE_3K + 977, value = "Unexpected Number subclass: %s")
   String unexpectedNumberSubclass(String classname);
   
   @Message(id = BASE_3K + 980, value = "Unknown interceptor precedence: %s")
   String unknownInterceptorPrecedence(String precedence);
   
   @Message(id = BASE_3K + 985, value = "Unknown media type for response entity")
   String unknownMediaTypeResponseEntity();
   
   @Message(id = BASE_3K + 990, value = "Unknown @PathParam: {0} for path: {1}", format=Format.MESSAGE_FORMAT)
   String unknownPathParam(String paramName, String path);

   @Message(id = BASE_3K + 995, value = "Unknown state.  You have a Listener messing up what resteasy expects")
   String unknownStateListener();
   
   @Message(id = BASE_3K + 1000, value = "Unsupported collectionType: %s")
   String unsupportedCollectionType(Class<?> clazz);
   
   @Message(id = BASE_3K + 1005, value = "Unsupported parameter: %s")
   String unsupportedParameter(String parameter);

   @Message(id = BASE_3K + 1010, value = "URI was null")
   String uriNull();

   @Message(id = BASE_3K + 1015, value = "uri param was null")
   String uriParamNull();

   @Message(id = BASE_3K + 1020, value = "uriTemplate parameter is null")
   String uriTemplateParameterNull();
   
   @Message(id = BASE_3K + 1025, value = "URI value is null")
   String uriValueNull();

   @Message(id = BASE_3K + 1030, value = "User is not registered: %s")
   String userIsNotRegistered(String user);
   
   @Message(id = BASE_3K + 1035, value = "A value was null")
   String valueNull();

   @Message(id = BASE_3K + 1040, value = "value param is null")
   String valueParamIsNull();
   
   @Message(id = BASE_3K + 1045, value = "value param was null")
   String valueParamWasNull();

   @Message(id = BASE_3K + 1050, value = "values param is null")
   String valuesParamIsNull();
   
   @Message(id = BASE_3K + 1055, value = "values param was null")
   String valuesParamWasNull();
   
   @Message(id = BASE_3K + 1060, value = "values parameter is null")
   String valuesParameterNull();
   
   @Message(id = BASE_3K + 1065, value = "Variant list must not be zero")
   String variantListMustNotBeZero();
   
   @Message(id = BASE_3K + 1070, value = "Wrong password for: %s")
   String wrongPassword(String user);
}
