/*
 * Copyright 2001-2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.net;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * The DaytimeTCPClient class is a TCP implementation of a client for the
 * Daytime protocol described in RFC 867.  To use the class, merely
 * establish a connection with
 * <a href="org.apache.commons.net.SocketClient.html#connect"> connect </a>
 * and call <a href="#getTime"> getTime() </a> to retrieve the daytime
 * string, then
 * call <a href="org.apache.commons.net.SocketClient.html#disconnect"> disconnect </a>
 * to close the connection properly.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see DaytimeUDPClient
 ***/

public final class DaytimeTCPClient extends SocketClient
{
    /*** The default daytime port.  It is set to 13 according to RFC 867. ***/
    public static final int DEFAULT_PORT = 13;

    // Received dates will likely be less than 64 characters.
    // This is a temporary buffer used while receiving data.
    private char[] __buffer = new char[64];

    /***
     * The default DaytimeTCPClient constructor.  It merely sets the default
     * port to <code> DEFAULT_PORT </code>.
     ***/
    public DaytimeTCPClient ()
    {
        setDefaultPort(DEFAULT_PORT);
    }

    /***
     * Retrieves the time string from the server and returns it.  The
     * server will have closed the connection at this point, so you should
     * call
     * <a href="org.apache.commons.net.SocketClient.html#disconnect"> disconnect </a>
     * after calling this method.  To retrieve another time, you must
     * initiate another connection with 
     * <a href="org.apache.commons.net.SocketClient.html#connect"> connect </a>
     * before calling <code> getTime() </code> again.
     * <p>
     * @return The time string retrieved from the server.
     * @exception IOException  If an error occurs while fetching the time string.
     ***/
    public String getTime() throws IOException
    {
        int read;
        StringBuffer result = new StringBuffer(__buffer.length);
        BufferedReader reader;

        reader = new BufferedReader(new InputStreamReader(_input_));

        while (true)
        {
            read = reader.read(__buffer, 0, __buffer.length);
            if (read <= 0)
                break;
            result.append(__buffer, 0, read);
        }

        return result.toString();
    }

}
