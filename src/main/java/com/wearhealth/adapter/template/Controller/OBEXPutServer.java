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
import java.io.InputStream;

import javax.bluetooth.*;
import javax.microedition.io.Connector;
import javax.obex.*;

/**
 * @author WearHealth
 */

public class OBEXPutServer {

    static final String serverUUID = "040AXXXX-6C30-4F6F-8FF8-B4B0822905CB";

    public static void main(String[] args) throws IOException {

        LocalDevice.getLocalDevice().setDiscoverable(DiscoveryAgent.GIAC);

        SessionNotifier serverConnection = (SessionNotifier) Connector.open("btgoep://localhost:"
                + serverUUID + ";name=ObexExample");

        int count = 0;
        while(count < 2) {
            RequestHandler handler = new RequestHandler();
            serverConnection.acceptAndOpen(handler);
            System.out.println("Received OBEX connection " + (++count));
        }
    }

    private static class RequestHandler extends ServerRequestHandler {

        public int onPut(Operation op) {
            try {
                HeaderSet hs = op.getReceivedHeaders();
                String name = (String) hs.getHeader(HeaderSet.NAME);
                if (name != null) {
                    System.out.println("put name:" + name);
                }

                InputStream is = op.openInputStream();

                StringBuffer buf = new StringBuffer();
                int data;
                while ((data = is.read()) != -1) {
                    buf.append((char) data);
                }

                System.out.println("got:" + buf.toString());

                op.close();
                return ResponseCodes.OBEX_HTTP_OK;
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseCodes.OBEX_HTTP_UNAVAILABLE;
            }
        }
    }
}