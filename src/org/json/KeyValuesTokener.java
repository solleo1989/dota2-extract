package org.json;

import java.io.InputStream;
import java.io.Reader;

public class KeyValuesTokener extends JSONTokener {

    public final static char STRING_DELIMITER = '"';
    public final static char OBJECT_START = '{';
    public final static char OBJECT_END = '}';
    public final static char EOF = 0;
    public final static char ESCAPE = '\\';

    public KeyValuesTokener(InputStream inputStream) throws JSONException {
        super(inputStream);
    }
    
    public KeyValuesTokener(String string) {
        super(string);
    }

    public KeyValuesTokener(Reader reader) {
        super(reader);
    }
    
    public char nextClean() throws JSONException {
        char c = 0, last;
        do {
            last = c;
            c = next();
            if (last == '/' && c == '/') skipTo('\n');
        } while (!(last != ESCAPE && (c == STRING_DELIMITER || c == OBJECT_START || c == OBJECT_END))
                && c != EOF);
        return c;
    }
    
    public Object nextValue() throws JSONException {
        char c = nextClean();
        if (c == STRING_DELIMITER)
            return nextString(STRING_DELIMITER);
        else if (c == OBJECT_START) 
            return KeyValues.toJSONObject(this);
        else if (c == EOF)
            throw syntaxError("Unexpected EOF");
        else
            throw syntaxError("Unexpected data");
    }
    
    /**
     * Return the characters up to the next close quote character.
     * Backslash processing is done. The formal JSON format does not
     * allow strings in single quotes, but an implementation is allowed to
     * accept them.
     * @param quote The quoting character, either
     *      <code>"</code>&nbsp;<small>(double quote)</small> or
     *      <code>'</code>&nbsp;<small>(single quote)</small>.
     * @return      A String.
     * @throws JSONException Unterminated string.
     */
    public String nextString(char quote) throws JSONException {
        char c;
        StringBuffer sb = new StringBuffer();
        for (;;) {
            c = this.next();
            switch (c) {
            case 0:
            //case '\n':
            //case '\r':
                throw this.syntaxError("Unterminated string");
            case '\\':
                c = this.next();
                switch (c) {
                case 't':
                    sb.append('\t');
                    break;
                case 'n':
                    sb.append('\n');
                    break;
                case 'r':
                    sb.append('\r');
                    break;
                default:
                    sb.append(c);
                }
                break;
            default:
                if (c == quote) {
                    return sb.toString();
                }
                sb.append(c);
            }
        }
    }
}
