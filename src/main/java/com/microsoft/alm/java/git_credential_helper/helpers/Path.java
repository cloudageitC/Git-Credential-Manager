package com.microsoft.alm.java.git_credential_helper.helpers;

import java.io.File;

/**
 * Equivalent to System.IO.Path
 */
public class Path
{
    public static String changeExtension(final String path, final String extension)
    {
        if (StringHelper.isNullOrEmpty(path))
        {
            return path;
        }
        final StringBuilder sb = new StringBuilder(path.length());
        final String minusLastExtension = getFileNameWithoutExtension(path);
        sb.append(minusLastExtension);

        if (extension != null)
        {
            if (!extension.startsWith(".") && !path.endsWith("."))
            {
                sb.append('.');
            }
            sb.append(extension);
        }
        return sb.toString();
    }

    public static String combine(final String path1, final String path2)
    {
        final File file = new File(path1, path2);
        return file.getPath();
    }

    public static boolean directoryExists(final String path)
    {
        final File file = new File(path);
        return file.exists() && file.isDirectory();
    }

    public static boolean fileExists(final String path)
    {
        final File file = new File(path);
        return file.exists() && file.isFile();
    }

    public static String getDirectoryName(final String path)
    {
        final File file = new File(path);
        return file.getParent();
    }

    // Inspired by http://stackoverflow.com/a/4094034
    public static String getFileNameWithoutExtension(final String path)
    {
        final String result = path.replaceAll("^(.*[/\\\\]?[^/\\\\]*)(\\.[^./\\\\]+)$", "$1");
        return result;
    }

    public static boolean isAbsolute(final String path)
    {
        final File file = new File(path);
        return file.isAbsolute();
    }
}
