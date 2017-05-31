package org.jboss.resteasy.util;

import org.jboss.resteasy.specimpl.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class Encode
{
   private static final String UTF_8 = StandardCharsets.UTF_8.name();

   private static final Pattern PARAM_REPLACEMENT = Pattern.compile("_resteasy_uri_parameter");

   private static final String[] pathEncoding = new String[128];
   private static final String[] pathSegmentEncoding = new String[128];
   private static final String[] matrixParameterEncoding = new String[128];
   private static final String[] queryNameValueEncoding = new String[128];
   private static final String[] queryStringEncoding = new String[128];

   static
   {
      /*
       * Encode via <a href="http://ietf.org/rfc/rfc3986.txt">RFC 3986</a>.  PCHAR is allowed allong with '/'
       *
       * unreserved  = ALPHA / DIGIT / "-" / "." / "_" / "~"
       * sub-delims  = "!" / "$" / "&" / "'" / "(" / ")"
                     / "*" / "+" / "," / ";" / "="
       * pchar = unreserved / pct-encoded / sub-delims / ":" / "@"
       *
       */
      for (int i = 0; i < 128; i++)
      {
         if (i >= 'a' && i <= 'z') continue;
         if (i >= 'A' && i <= 'Z') continue;
         if (i >= '0' && i <= '9') continue;
         switch ((char) i)
         {
            case '-':
            case '.':
            case '_':
            case '~':
            case '!':
            case '$':
            case '&':
            case '\'':
            case '(':
            case ')':
            case '*':
            case '+':
            case ',':
            case '/':
            case ';':
            case '=':
            case ':':
            case '@':
               continue;
         }
         pathEncoding[i] = URLEncoder.encode(String.valueOf((char) i));
      }
      pathEncoding[' '] = "%20";
      System.arraycopy(pathEncoding, 0, matrixParameterEncoding, 0, pathEncoding.length);
      matrixParameterEncoding[';'] = "%3B";
      matrixParameterEncoding['='] = "%3D";
      matrixParameterEncoding['/'] = "%2F"; // RESTEASY-729
      System.arraycopy(pathEncoding, 0, pathSegmentEncoding, 0, pathEncoding.length);
      pathSegmentEncoding['/'] = "%2F";
      /*
       * Encode via <a href="http://ietf.org/rfc/rfc3986.txt">RFC 3986</a>.
       *
       * unreserved  = ALPHA / DIGIT / "-" / "." / "_" / "~"
       * space encoded as '+'
       *
       */
      for (int i = 0; i < 128; i++)
      {
         if (i >= 'a' && i <= 'z') continue;
         if (i >= 'A' && i <= 'Z') continue;
         if (i >= '0' && i <= '9') continue;
         switch ((char) i)
         {
            case '-':
            case '.':
            case '_':
            case '~':
            case '?':
               continue;
            case ' ':
               queryNameValueEncoding[i] = "+";
               continue;
         }
         queryNameValueEncoding[i] = URLEncoder.encode(String.valueOf((char) i));
      }

      /*
       * query       = *( pchar / "/" / "?" )

       */
      for (int i = 0; i < 128; i++)
      {
         if (i >= 'a' && i <= 'z') continue;
         if (i >= 'A' && i <= 'Z') continue;
         if (i >= '0' && i <= '9') continue;
         switch ((char) i)
         {
            case '-':
            case '.':
            case '_':
            case '~':
            case '!':
            case '$':
            case '&':
            case '\'':
            case '(':
            case ')':
            case '*':
            case '+':
            case ',':
            case ';':
            case '=':
            case ':':
            case '@':
            case '?':
            case '/':
               continue;
            case ' ':
               queryStringEncoding[i] = "%20";
               continue;
         }
         queryStringEncoding[i] = URLEncoder.encode(String.valueOf((char) i));
      }
   }

   /**
    * Keep encoded values "%..." and template parameters intact.
    */
   public static String encodeQueryString(String value)
   {
      return encodeValue(value, queryStringEncoding);
   }

   public static void encodeQueryString(String value, StringBuilder appendTo)
   {
      encodeValue(value, queryStringEncoding, appendTo);
   }

   /**
    * Keep encoded values "%...", matrix parameters, template parameters, and '/' characters intact.
    */
   public static String encodePath(String value)
   {
      return encodeValue(value, pathEncoding);
   }

   public static void encodePath(String value, StringBuilder appendTo)
   {
      encodeValue(value, pathEncoding, appendTo);
   }

   /**
    * Keep encoded values "%...", matrix parameters and template parameters intact.
    */
   public static String encodePathSegment(String value)
   {
      return encodeValue(value, pathSegmentEncoding);
   }

   public static void encodePathSegment(String value, StringBuilder appendTo)
   {
      encodeValue(value, pathSegmentEncoding, appendTo);
   }

   /**
    * Keep encoded values "%..." and template parameters intact.
    */
   public static String encodeFragment(String value)
   {
      return encodeValue(value, queryStringEncoding);
   }

   /**
    * Keep encoded values "%..." and template parameters intact.
    */
   public static String encodeMatrixParam(String value)
   {
      return encodeValue(value, matrixParameterEncoding);
   }

   public static void encodeMatrixParam(String value, StringBuilder appendTo)
   {
      encodeValue(value, matrixParameterEncoding, appendTo);
   }

   /**
    * Keep encoded values "%..." and template parameters intact.
    */
   public static String encodeQueryParam(String value)
   {
      return encodeValue(value, queryNameValueEncoding);
   }

   public static void encodeQueryParam(String value, StringBuilder appendTo)
   {
      encodeValue(value, queryNameValueEncoding, appendTo);
   }

   //private static final Pattern nonCodes = Pattern.compile("%([^a-fA-F0-9]|$)");
   private static final Pattern nonCodes = Pattern.compile("%([^a-fA-F0-9]|[a-fA-F0-9]$|$|[a-fA-F0-9][^a-fA-F0-9])");
   private static final Pattern encodedChars = Pattern.compile("%([a-fA-F0-9][a-fA-F0-9])");
   private static final Pattern encodedCharsMulti = Pattern.compile("((%[a-fA-F0-9][a-fA-F0-9])+)");

   public static String decodePath(String path)
   {
      Matcher matcher = encodedCharsMulti.matcher(path);
      int start=0;
      StringBuilder builder = new StringBuilder();
      CharsetDecoder decoder = Charset.forName(UTF_8).newDecoder();
      while (matcher.find())
      {
    	 builder.append(path, start, matcher.start());
         decoder.reset();
         String decoded = decodeBytes(matcher.group(1), decoder);
         builder.append(decoded);
         start = matcher.end();
      }
      builder.append(path, start, path.length());
      return builder.toString();
   }

   private static String decodeBytes(String enc, CharsetDecoder decoder)
   {
      Matcher matcher = encodedChars.matcher(enc);
      ByteBuffer bytes = ByteBuffer.allocate(enc.length() / 3);
      while (matcher.find())
      {
         int b = Integer.parseInt(matcher.group(1), 16);
         bytes.put((byte) b);
      }
      bytes.flip();
      try
      {
         return decoder.decode(bytes).toString();
      }
      catch (CharacterCodingException e)
      {
         throw new RuntimeException(e);
      }
   }

   /**
    * Encode '%' if it is not an encoding sequence
    *
    * @param string
    * @return
    */
   public static String encodeNonCodes(String string)
   {
      StringBuilder sb = stringToMinimalStringBuilder(string);
      StringBuilder res = new StringBuilder();
      encodeNonCodes(sb, res);
      return res.toString();
   }
   
   public static void encodeNonCodes(CharSequence sb, StringBuilder appendTo)
   {
      Matcher matcher = nonCodes.matcher(sb);

      // FYI: we do not use the no-arg matcher.find()
      //      coupled with matcher.appendReplacement()
      //      because the matched text may contain
      //      a second % and we must make sure we
      //      encode it (if necessary).
      int idx = 0;
      while (matcher.find(idx))
      {
         int start = matcher.start();
         appendTo.append(sb, idx, start);
         appendTo.append("%25");
         idx = start + 1;
      }
      appendTo.append(sb, idx, sb.length());
   }

   private static StringBuilder savePathParams(String segment, List<String> params)
   {
      boolean foundParam = false;
      // Regular expressions can have '{' and '}' characters.  Replace them to do match
      segment = PathHelper.replaceEnclosedCurlyBraces(segment);
      Matcher matcher = PathHelper.URI_TEMPLATE_PATTERN.matcher(segment);
      int start = 0;
      StringBuilder newSegment = null;
      while (matcher.find())
      {
         if (newSegment == null)
         {
            newSegment = new StringBuilder();
         }
         newSegment.append(segment, start, matcher.start());
         foundParam = true;
         String group = matcher.group();
         // Regular expressions can have '{' and '}' characters.  Recover earlier replacement
         params.add(PathHelper.recoverEnclosedCurlyBraces(group));
         newSegment.append("_resteasy_uri_parameter");
         start = matcher.end();
      }
      if (!foundParam)
      {
         return null;
      }
      newSegment.append(segment, start, segment.length());
      return newSegment;
   }

   /**
    * Keep encoded values "%..." and template parameters intact i.e. "{x}"
    *
    * @param segment
    * @param encoding
    * @return
    */
   public static String encodeValue(String segment, String[] encoding) {
      StringBuilder sb = new StringBuilder();
      encodeValue(segment, encoding, sb);
      return sb.toString();
   }
   
   private static void encodeValue(String segment, String[] encoding, StringBuilder appendTo)
   {
      ArrayList<String> params = new ArrayList<String>();
      StringBuilder sb = savePathParams(segment, params);
      if (sb != null)
      {
         encodeFromArray(sb, encoding, false);
         StringBuilder tmp = new StringBuilder();
         encodeNonCodes(sb, tmp);
         pathParamReplacement(tmp, params, appendTo);
      } else {
         sb = stringToMinimalStringBuilder(segment);
         encodeFromArray(sb, encoding, false);
         encodeNonCodes(sb, appendTo);
      }
   }

   /**
    * Encode via <a href="http://ietf.org/rfc/rfc3986.txt">RFC 3986</a>.  PCHAR is allowed allong with '/'
    * <p/>
    * unreserved  = ALPHA / DIGIT / "-" / "." / "_" / "~"
    * sub-delims  = "!" / "$" / "&" / "'" / "(" / ")"
    * / "*" / "+" / "," / ";" / "="
    * pchar = unreserved / pct-encoded / sub-delims / ":" / "@"
    */
   public static String encodePathAsIs(String segment)
   {
      StringBuilder sb = new StringBuilder();
      encodeFromArray(segment, pathEncoding, true, sb);
      return sb.toString();
   }
   
   public static void encodePathAsIs(CharSequence segment, StringBuilder appendTo)
   {
      encodeFromArray(segment, pathEncoding, true, appendTo);
   }
   
   /**
    * Keep any valid encodings from string i.e. keep "%2D" but don't keep "%p"
    *
    * @param segment
    * @return
    */
   public static String encodePathSaveEncodings(String segment)
   {
      StringBuilder res = new StringBuilder();
      encodePathSaveEncodings(segment, res);
      return res.toString();
   }

   public static void encodePathSaveEncodings(String segment, StringBuilder appendTo)
   {
      StringBuilder sb = stringToMinimalStringBuilder(segment);
      encodeFromArray(sb, pathEncoding, false);
      encodeNonCodes(sb, appendTo);
   }

   /**
    * Encode via <a href="http://ietf.org/rfc/rfc3986.txt">RFC 3986</a>.  PCHAR is allowed allong with '/'
    * <p/>
    * unreserved  = ALPHA / DIGIT / "-" / "." / "_" / "~"
    * sub-delims  = "!" / "$" / "&" / "'" / "(" / ")"
    * / "*" / "+" / "," / ";" / "="
    * pchar = unreserved / pct-encoded / sub-delims / ":" / "@"
    */
   public static String encodePathSegmentAsIs(String segment)
   {
      StringBuilder sb = new StringBuilder();
      encodeFromArray(segment, pathSegmentEncoding, true, sb);
      return sb.toString();
   }

   public static void encodePathSegmentAsIs(CharSequence segment, StringBuilder appendTo)
   {
      encodeFromArray(segment, pathSegmentEncoding, true, appendTo);
   }

   /**
    * Keep any valid encodings from string i.e. keep "%2D" but don't keep "%p"
    *
    * @param segment
    * @return
    */
   public static String encodePathSegmentSaveEncodings(String segment)
   {
      StringBuilder res = new StringBuilder();
      encodePathSegmentSaveEncodings(segment, res);
      return res.toString();
   }
   
   public static void encodePathSegmentSaveEncodings(String segment, StringBuilder appendTo)
   {
      StringBuilder sb = stringToMinimalStringBuilder(segment);
      encodeFromArray(sb, pathSegmentEncoding, false);
      encodeNonCodes(sb, appendTo);
   }

   /**
    * Encodes everything of a query parameter name or value.
    *
    * @param nameOrValue
    * @return
    */
   public static String encodeQueryParamAsIs(String nameOrValue)
   {
      StringBuilder sb = new StringBuilder();
      encodeFromArray(nameOrValue, queryNameValueEncoding, true, sb);
      return sb.toString();
   }

   public static void encodeQueryParamAsIs(CharSequence nameOrValue, StringBuilder appendTo)
   {
      encodeFromArray(nameOrValue, queryNameValueEncoding, true, appendTo);
   }

   /**
    * Keep any valid encodings from string i.e. keep "%2D" but don't keep "%p"
    *
    * @param segment
    * @return
    */
   public static String encodeQueryParamSaveEncodings(String segment)
   {
      StringBuilder res = new StringBuilder();
      encodeQueryParamSaveEncodings(segment, res);
      return res.toString();
   }

   public static void encodeQueryParamSaveEncodings(String segment, StringBuilder appendTo)
   {
      StringBuilder sb = stringToMinimalStringBuilder(segment);
      encodeFromArray(sb, queryNameValueEncoding, false);
      encodeNonCodes(sb, appendTo);
   }

   public static String encodeFragmentAsIs(String nameOrValue)
   {
      StringBuilder sb = new StringBuilder();
      encodeFromArray(nameOrValue, queryNameValueEncoding, true, sb);
      return sb.toString();
   }

   protected static void encodeFromArray(CharSequence segment, String[] encodingMap, boolean encodePercent, StringBuilder appendTo)
   {
      final int l = segment.length();
      for (int i = 0; i < l; i++)
      {
         char currentChar = segment.charAt(i);
         if (!encodePercent && currentChar == '%')
         {
            appendTo.append(currentChar);
            continue;
         }
         String encoding = encode(currentChar, encodingMap);
         if (encoding == null)
         {
            appendTo.append(currentChar);
            continue;
         }
         else
         {
            appendTo.append(encoding);
         }
      }
   }

   protected static void encodeFromArray(StringBuilder segment, String[] encodingMap, boolean encodePercent)
   {
      final int l = segment.length();
      int j = 0;
      for (int i = 0; i < l; i++)
      {
         char currentChar = segment.charAt(j);
         if (!encodePercent && currentChar == '%')
         {
            j++;
            continue;
         }
         String encoding = encode(currentChar, encodingMap);
         if (encoding == null)
         {
            j++;
            continue;
         }
         else
         {
            segment.replace(j, j + 1, encoding);
            j = j + encoding.length();
         }
      }
   }

   /**
    * @param zhar        integer representation of character
    * @param encodingMap encoding map
    * @return URL encoded character
    */
   private static String encode(int zhar, String[] encodingMap)
   {
      String encoded;
      if (zhar < encodingMap.length)
      {
         encoded = encodingMap[zhar];
      }
      else
      {
         try
         {
            encoded = URLEncoder.encode(Character.toString((char) zhar), UTF_8);
         }
         catch (UnsupportedEncodingException e)
         {
            throw new RuntimeException(e);
         }
      }
      return encoded;
   }

   public static void pathParamReplacement(StringBuilder segment, List<String> params, StringBuilder appendTo)
   {
      Matcher matcher = PARAM_REPLACEMENT.matcher(segment);
      int i = 0;
      int start = 0;
      while (matcher.find())
      {
    	 appendTo.append(segment, start, matcher.start());
         String replacement = params.get(i++);
         appendTo.append(replacement);
		 start = matcher.end();
      }
      appendTo.append(segment, start, segment.length());
   }

   /**
    * decode an encoded map
    *
    * @param map
    * @return
    */
   public static MultivaluedMap<String, String> decode(MultivaluedMap<String, String> map)
   {
      MultivaluedMapImpl<String, String> decoded = new MultivaluedMapImpl<String, String>();
      for (Map.Entry<String, List<String>> entry : map.entrySet())
      {
         List<String> values = entry.getValue();
         for (String value : values)
         {
            try
            {
               decoded.add(URLDecoder.decode(entry.getKey(), UTF_8), URLDecoder.decode(value, UTF_8));
            }
            catch (UnsupportedEncodingException e)
            {
               throw new RuntimeException(e);
            }
         }
      }
      return decoded;
   }
   
   /**
    * decode an encoded map
    *
    * @param map
    * @param charset
    * @return
    */
   public static MultivaluedMap<String, String> decode(MultivaluedMap<String, String> map, String charset)
   {
      if (charset == null)
      {
         charset = UTF_8;
      }
      MultivaluedMapImpl<String, String> decoded = new MultivaluedMapImpl<String, String>();
      for (Map.Entry<String, List<String>> entry : map.entrySet())
      {
         List<String> values = entry.getValue();
         for (String value : values)
         {
            try
            {
               decoded.add(URLDecoder.decode(entry.getKey(), charset), URLDecoder.decode(value, charset));
            }
            catch (UnsupportedEncodingException e)
            {
               throw new RuntimeException(e);
            }
         }
      }
      return decoded;
   }

   public static MultivaluedMap<String, String> encode(MultivaluedMap<String, String> map)
   {
      MultivaluedMapImpl<String, String> decoded = new MultivaluedMapImpl<String, String>();
      for (Map.Entry<String, List<String>> entry : map.entrySet())
      {
         List<String> values = entry.getValue();
         for (String value : values)
         {
            try
            {
               decoded.add(URLEncoder.encode(entry.getKey(), UTF_8), URLEncoder.encode(value, UTF_8));
            }
            catch (UnsupportedEncodingException e)
            {
               throw new RuntimeException(e);
            }
         }
      }
      return decoded;
   }

   public static String decode(String string)
   {
      try
      {
         return URLDecoder.decode(string, UTF_8);
      }
      catch (UnsupportedEncodingException e)
      {
         throw new RuntimeException(e);
      }
   }

   private static StringBuilder stringToMinimalStringBuilder(String s)
   {
      StringBuilder sb = new StringBuilder(s.length());
      sb.append(s);
      return sb;
   }
}
