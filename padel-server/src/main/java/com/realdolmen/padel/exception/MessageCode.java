package com.realdolmen.padel.exception;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageCode {

    private static final long serialVersionUID = 1L;
    private String m_system;
    private String m_subSystem;
    private String m_code;
    private String m_defaultName;
    private String m_defaultMessageTemplate;
    protected String m_nameBundleName;
    protected String m_messageBundleName;
    private static final int LEN_SYS_ID = 10;
    private static final int LEN_CODE = 20;
    private static final int LEN_NAME = 40;
    private static final int LEN_MSG = 800;
    private static final Pattern MESSAGE_CODE_PATTERN = Pattern.compile("^\\[(\\w+|\\*):(\\w+|\\*):(.+)\\]$");

    protected MessageCode(String p_system, String p_subSystem, String p_code) {
        this(p_system, p_subSystem, p_code, (String)null, (String)null);
    }

    protected MessageCode(String p_system, String p_subSystem, String p_code, String p_defaultName, String p_defaultMsgTemplate) {
        this.m_nameBundleName = this.getClass().getName() + "Names";
        this.m_messageBundleName = this.getClass().getName() + "Messages";
        this.m_system = p_system;
        this.m_subSystem = p_subSystem;
        this.m_code = p_code;
        this.m_defaultName = p_defaultName;
        this.m_defaultMessageTemplate = p_defaultMsgTemplate;
        if (this.m_defaultName == null) {
            this.m_defaultName = "!NONAME:" + p_system + "-" + p_subSystem + "-" + p_code;
        }

        if (this.m_defaultMessageTemplate == null) {
            this.m_defaultMessageTemplate = "!NOMSG:" + p_system + "-" + p_subSystem + "-" + p_code;
        }

        this.trimAll();
    }

    private void trimAll() {
        this.m_system = this.trim("system", this.m_system, 10);
        this.m_subSystem = this.trim("subsystem", this.m_subSystem, 10);
        this.m_code = this.trim("code", this.m_code, 20);
        this.m_defaultName = this.trim("defaultName", this.m_defaultName, 40);
        this.m_defaultMessageTemplate = this.trim("defaultMessage", this.m_defaultMessageTemplate, 800);
    }

    private String trim(String key, String value, int length) {
        if (value != null && value.length() > length) {
            //LOG.warn("trimmed " + key + " value '" + value + "' of messagecode " + this + " to length " + length);
            return value.substring(0, length);
        } else {
            return value;
        }
    }

    public String getName(Locale p_locale) {
        try {
            return ResourceBundle.getBundle(this.m_nameBundleName, p_locale != null ? p_locale : Locale.getDefault(), this.getClass().getClassLoader()).getString(this.m_code);
        } catch (MissingResourceException var3) {
            return this.m_defaultName;
        }
    }

    public String getName() {
        return this.getName(Locale.getDefault());
    }

    public String getDefaultMessageTemplate() {
        return this.m_defaultMessageTemplate;
    }

    public String getDefaultName() {
        return this.m_defaultName;
    }

    public String getMessageTemplate(Locale p_locale) {
        try {
            return ResourceBundle.getBundle(this.m_messageBundleName, p_locale != null ? p_locale : Locale.getDefault(), this.getClass().getClassLoader()).getString(this.m_code);
        } catch (MissingResourceException var3) {
            return this.m_defaultMessageTemplate;
        }
    }

    public String getMessageTemplate() {
        return this.getMessageTemplate(Locale.getDefault());
    }

    public String getMessage(Locale p_locale, Map<String, String> p_info) {
        String l_template = this.getMessageTemplate(p_locale);
        if (p_info != null && l_template != null) {
            Iterator var4 = p_info.entrySet().iterator();

            while(var4.hasNext()) {
                Map.Entry<String, String> l_infoEntry = (Map.Entry)var4.next();
                if (l_infoEntry.getValue() != null) {
                    l_template = l_template.replace("@" + (String)l_infoEntry.getKey() + "@", (CharSequence)l_infoEntry.getValue());
                }
            }
        }

        return this.trim("message", l_template, 800);
    }

    public String getMessage(Locale p_locale, String[] p_info) {
        return this.getMessage(p_locale, (Map)(p_info == null ? null : new MessageCode.StringArrayPropMap(p_info)));
    }

    public String getMessage(String[] p_info) {
        return this.getMessage(Locale.getDefault(), p_info);
    }

    public String getMessage(Map<String, String> p_info) {
        return this.getMessage(Locale.getDefault(), p_info);
    }

    public String getSystem() {
        return this.m_system;
    }

    public String getSubSystem() {
        return this.m_subSystem;
    }

    public String getCode() {
        return this.m_code;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append('[').append(this.getSystem());
        sb.append(':').append(this.getSubSystem());
        sb.append(':').append(this.getCode());
        sb.append(']');
        return sb.toString();
    }


    public static final MessageCode parseMessageCode(String messageCodeString) {
        Matcher m = MESSAGE_CODE_PATTERN.matcher(messageCodeString);
        if (m.matches()) {
            return new MessageCode(m.group(1), m.group(2), m.group(3)) {
            };
        } else {
            //LOG.warn("messageCodeString '" + messageCodeString + "' does not have pattern '" + MESSAGE_CODE_PATTERN + "'");
            return null;
        }
    }

    public static class StringArrayPropMap implements Map<String, String> {
        String[] m_info;

        public StringArrayPropMap(String[] p_info) {
            this.m_info = p_info;
        }

        public String get(Object p_key) {
            String l_key = (String)p_key;
            if ("n".equals(l_key)) {
                StringBuffer l_val = new StringBuffer();
                l_val.append("[");
                int i = 0;

                for(int len = this.m_info.length; i < len; ++i) {
                    if (i > 0) {
                        l_val.append(",");
                    }

                    l_val.append(this.m_info[i]);
                }

                l_val.append("]");
                return l_val.toString();
            } else {
                try {
                    return this.m_info[Integer.parseInt(l_key) - 1];
                } catch (ArrayIndexOutOfBoundsException var6) {
                    return null;
                } catch (NumberFormatException var7) {
                    return null;
                }
            }
        }

        public int size() {
            throw new UnsupportedOperationException("not implemented");
        }

        public boolean isEmpty() {
            return this.m_info.length > 0;
        }

        public boolean containsKey(Object p_key) {
            return "n".equals(p_key) || Integer.parseInt((String)p_key) <= this.m_info.length;
        }

        public boolean containsValue(Object p_val) {
            throw new UnsupportedOperationException("not implemented");
        }

        public String put(String p_key, String p_val) {
            throw new UnsupportedOperationException("not implemented");
        }

        public String remove(Object p_key) {
            throw new UnsupportedOperationException("not implemented");
        }

        public void putAll(Map<? extends String, ? extends String> p_map) {
            throw new UnsupportedOperationException("not implemented");
        }

        public void clear() {
            throw new UnsupportedOperationException("not implemented");
        }

        public Set<String> keySet() {
            throw new UnsupportedOperationException("not implemented");
        }

        public Collection<String> values() {
            throw new UnsupportedOperationException("not implemented");
        }

        private Entry<String, String> createEntry(final String key, final String value) {
            return new Entry<String, String>() {
                public String getKey() {
                    return key;
                }

                public String getValue() {
                    return value;
                }

                public String setValue(String object) {
                    throw new UnsupportedOperationException("not implemented");
                }
            };
        }

        public Set<Entry<String, String>> entrySet() {
            Set<Entry<String, String>> entries = new HashSet();

            for(int i = 1; i <= this.m_info.length; ++i) {
                entries.add(this.createEntry("" + i, this.m_info[i - 1]));
            }

            entries.add(this.createEntry("n", this.get("n")));
            return entries;
        }
    }
}

