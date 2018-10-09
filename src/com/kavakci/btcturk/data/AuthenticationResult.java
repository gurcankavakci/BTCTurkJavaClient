package com.kavakci.btcturk.data;

public class AuthenticationResult {
    private final String timestamp;
    private final String authenticationSignature;

    public AuthenticationResult(String timestamp, String authenticationSignature) {
        this.timestamp = timestamp;
        this.authenticationSignature = authenticationSignature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getAuthenticationSignature() {
        return authenticationSignature;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();

        buf.append("Authentication Result").append("\n");
        buf.append("Timestamp: ").append(timestamp).append("\n");
        buf.append("Authentication Signature: ").append(authenticationSignature).append("\n");
        buf.append("\n");

        return buf.toString();
    }
}
