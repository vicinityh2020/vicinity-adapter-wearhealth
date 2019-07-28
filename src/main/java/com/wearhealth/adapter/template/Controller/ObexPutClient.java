/*
Copyright © 2019 Wearhealth. All rights reserved.

This file is part of vicinity-adapter-wearhealth.

Vicinity-adapter-wearhealth is free software: you can redistribute it and/or modify it under the terms of MIT License.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT ANY WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT,
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

See README file for the full disclaimer information and LICENSE file for full license information in the project root.
*/

package com.wearhealth.adapter.template.Controller;

import java.io.IOException;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.obex.*;

/**
 * @author WearHealth
 */

public class ObexPutClient {

    public static void main(String[] args) throws IOException, InterruptedException {

        String serverURL = null; // server url
        if ((args != null) && (args.length > 0)) {
            serverURL = args[0];
        }
        if (serverURL == null) {
            String[] searchArgs = null;
            // Connect to OBEXPutServer from examples
            // searchArgs
            ServicesSearch.main(searchArgs);
            if (ServicesSearch.serviceFound.size() == 0) {
                System.out.println("TechUnit device not found! OBEX service not found");
                return;
            }
            // Select the first service found
            serverURL = (String)ServicesSearch.serviceFound.elementAt(0);
        }

        System.out.println("Connecting to " + serverURL);

        ClientSession clientSession = (ClientSession) Connector.open(serverURL);
        HeaderSet hsConnectReply = clientSession.connect(null);
        if (hsConnectReply.getResponseCode() != ResponseCodes.OBEX_HTTP_OK) {
            System.out.println("Failed to connect");
            return;
        }

        HeaderSet hsOperation = clientSession.createHeaderSet();
        hsOperation.setHeader(HeaderSet.NAME, "Hello.txt");
        hsOperation.setHeader(HeaderSet.TYPE, "text");

        //Create PUT Operation
        Operation putOperation = clientSession.put(hsOperation);

        // Send some text to server
        byte data[] = "Hello world!".getBytes("iso-8859-1");
        OutputStream os = putOperation.openOutputStream();
        os.write(data);
        os.close();

        putOperation.close();

        clientSession.disconnect(null);

        clientSession.close();
    }
}