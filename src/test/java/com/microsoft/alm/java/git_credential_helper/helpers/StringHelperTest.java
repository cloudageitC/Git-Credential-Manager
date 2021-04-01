package com.microsoft.alm.java.git_credential_helper.helpers;

import org.junit.Assert;
import org.junit.Test;

public class StringHelperTest
{
    @Test public void endsWithIgnoreCase_positive()
    {
        Assert.assertTrue(StringHelper.endsWithIgnoreCase("Session", "Session"));
        Assert.assertTrue(StringHelper.endsWithIgnoreCase("Session", ""));
        Assert.assertTrue(StringHelper.endsWithIgnoreCase("Session", "SiOn"));
    }

    @Test public void endsWithIgnoreCase_negative()
    {
        Assert.assertFalse(StringHelper.endsWithIgnoreCase("Session", "SiO"));
        Assert.assertFalse(StringHelper.endsWithIgnoreCase("Session", "LongerThanSession"));
        Assert.assertFalse(StringHelper.endsWithIgnoreCase("Session", "noisseS"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void endsWithIgnoreCase_firstNull()
    {
        Assert.assertTrue(StringHelper.endsWithIgnoreCase(null, "SiO"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void endsWithIgnoreCase_secondNull()
    {
        Assert.assertTrue(StringHelper.endsWithIgnoreCase("Session", null));
    }

    @Test public void isNullOrWhiteSpace_null()
    {
        Assert.assertTrue(StringHelper.isNullOrWhiteSpace(null));
    }

    @Test public void isNullOrWhiteSpace_empty()
    {
        Assert.assertTrue(StringHelper.isNullOrWhiteSpace(StringHelper.Empty));
    }

    @Test public void isNullOrWhiteSpace_whiteSpace()
    {
        Assert.assertTrue(StringHelper.isNullOrWhiteSpace(" "));
        Assert.assertTrue(StringHelper.isNullOrWhiteSpace("\n"));
        Assert.assertTrue(StringHelper.isNullOrWhiteSpace("\t"));
    }

    @Test public void isNullOrWhiteSpace_content()
    {
        Assert.assertFalse(StringHelper.isNullOrWhiteSpace("isNullOrWhiteSpace"));
        Assert.assertFalse(StringHelper.isNullOrWhiteSpace(" isNullOrWhiteSpace"));
        Assert.assertFalse(StringHelper.isNullOrWhiteSpace("isNullOrWhiteSpace "));
        Assert.assertFalse(StringHelper.isNullOrWhiteSpace(" isNullOrWhiteSpace "));
    }

    @Test public void join_typical()
    {
        final String[] a = {"a", "b", "c"};

        final String actual = StringHelper.join(",", a, 0, a.length);

        Assert.assertEquals("a,b,c", actual);
    }

    @Test public void join_returnsStringEmptyIfCountZero()
    {
        final String[] a = {"a", "b", "c"};

        Assert.assertEquals(StringHelper.Empty, StringHelper.join(",", a, 0, 0));
    }

    @Test public void join_returnsStringEmptyIfValueHasNoElements()
    {
        final String[] emptyArray = {};

        Assert.assertEquals(StringHelper.Empty, StringHelper.join(",", emptyArray, 0, 0));
    }

    @Test public void join_returnsStringEmptyIfSeparatorAndAllElementsAreEmpty()
    {
        final String[] arrayOfEmpty = {StringHelper.Empty, StringHelper.Empty, StringHelper.Empty};

        Assert.assertEquals(StringHelper.Empty, StringHelper.join(StringHelper.Empty, arrayOfEmpty, 0, 3));
    }
}
