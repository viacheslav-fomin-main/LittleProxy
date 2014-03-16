package org.littleshoot.proxy;

import org.littleshoot.proxy.extras.SelfSignedMitmManager;

/**
 * Tests a single proxy that requires username/password authentication.
 */
public class MITMUsernamePasswordAuthenticatingProxyTest extends
        UsernamePasswordAuthenticatingProxyTest
        implements ProxyAuthenticator {
    @Override
    protected void setUp() {
        this.proxyServer = bootstrapProxy()
                .withPort(proxyServerPort)
                .withProxyAuthenticator(this)
                .withManInTheMiddle(new SelfSignedMitmManager())
                .start();
    }
    
    @Override
    protected boolean isMITM() {
        return true;
    }
}