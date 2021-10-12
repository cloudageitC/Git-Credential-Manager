// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the project root.

package com.microsoft.alm.helpers;

import java.net.URI;
import java.net.URISyntaxException;

public class UriHelper
{
    public static boolean isWellFormedUriString(final String uriString)
    {
        try
        {
            new URI(uriString);
            return true;
        }
        catch (final URISyntaxException ignored)
        {
            return false;
        }
    }
}
